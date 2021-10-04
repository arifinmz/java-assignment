package com.muhammadarifin.grocerybilling;

import java.util.*;

public class App 
{
	
	public static ArrayList<User> allUser = new ArrayList<User>();
	public static ArrayList<ItemShopDetail> itemShopDetailList = new ArrayList<ItemShopDetail>();
	
	
	public static void initData() {
		ItemShopDetail item1 = new ItemShopDetail.ItemShopDetailBuilder("Carrot  :", 2, 8).build();
		ItemShopDetail item2 = new ItemShopDetail.ItemShopDetailBuilder("Onion   :", 3, 12).build();
		ItemShopDetail item3 = new ItemShopDetail.ItemShopDetailBuilder("Cabbage :", 4, 7).build();
		ItemShopDetail item4 = new ItemShopDetail.ItemShopDetailBuilder("Broccoli:", 4, 5).build();
		ItemShopDetail item5 = new ItemShopDetail.ItemShopDetailBuilder("Pumpkin :", 5, 2).build();

		itemShopDetailList.add(item1);
		itemShopDetailList.add(item2);
		itemShopDetailList.add(item3);
		itemShopDetailList.add(item4);
		itemShopDetailList.add(item5);
		
		ItemShop itemShop = new ItemShop.ItemShopBuilder(itemShopDetailList, PaymentEnum.CREDIT_CARD).build();
		User user = new User.UserBuilder("User 1", itemShop, false).build();
		allUser.add(user);	
	}
		
	public static boolean isPaymentUsingCreditCard(PaymentEnum payment) {
		return payment == PaymentEnum.CREDIT_CARD;
	}
	
	public static boolean isMoreThan100$(float totalAmount) {
		return totalAmount > 100;
	}
	
	public static float calculatePricePerItem(ItemShopDetail item) {
		return (float)item.getItemPrice()*item.getItemSize();
	}
	
	public static float calculateWhenUsingCreditCard(float totalAmount) {
		return (((float)2/100)*totalAmount)+totalAmount;
	}
	
	public static float calculateWhenIsMember(float totalAmount) {
		return totalAmount-(((float)5/100)*totalAmount);
	}
	
    public static void main(String[] args){
    	initData();
		for(User user : allUser) {
			ArrayList<String>offerApplicable = new ArrayList<String>();
			float totalAmount=0;
			for(int i =0;i < user.getItemShop().getItem().size();i++) {
				totalAmount+=calculatePricePerItem(user.getItemShop().getItem().get(i));
			}
			
			float baseTotalAmount = totalAmount;
			
			if(isPaymentUsingCreditCard(user.getItemShop().getPaymentMethod())) {
				totalAmount = calculateWhenUsingCreditCard(totalAmount);
				offerApplicable.add("Payment Using Credit Card, fee=2%");
			}
			

			if(user.isWantToBeMember() && !user.isMember()) {
				totalAmount+=100;
				user = new User.UserBuilder(user.getUserID(), user.getItemShop(), user.isWantToBeMember()).setMember(true).build();
				offerApplicable.add("Want to Be a Member");
			}
			
			if(user.isMember()) {
				totalAmount = calculateWhenIsMember(totalAmount);
				offerApplicable.add("Already Member");
			}
			
			if(isMoreThan100$(totalAmount)) {
				totalAmount-=10;
				offerApplicable.add("Payment More Than 100$, discount $10");
			}
			
			user = new User.UserBuilder(user.getUserID(), user.getItemShop(), user.isWantToBeMember()).setOfferApplicableList(offerApplicable).build();
			
			System.out.println("=========BILLING========");
			System.out.println("Total Base Bill Amount : "+baseTotalAmount);
			System.out.println("========================");
			System.out.println("=====Items Name , Price ,  Quantity=====");
			for(int i =0;i < user.getItemShop().getItem().size();i++) {
				System.out.println(""
						+user.getItemShop().getItem().get(i).getItemName()+ " - $ "
						+user.getItemShop().getItem().get(i).getItemPrice()+ " - "
						+user.getItemShop().getItem().get(i).getItemSize() + " Kg");
			}
			System.out.println("==================================");
			System.out.println("Total Amount : $"+baseTotalAmount);
			System.out.println("==================================");
			System.out.println("=======OFFER APPLICABLE===========");
			for(int i=0 ; i < user.getOfferApplicable().size();i++) {
				System.out.println(user.getOfferApplicable().get(i));
			}
			System.out.println("=================================");
			System.out.println("Final Amount : $"+totalAmount);
			System.out.println("=================================");
		}
    }
}
