package com.muhammadarifin.grocerybilling;

import java.util.ArrayList;


public class ItemShop {
	private ArrayList<ItemShopDetail> item;
	private PaymentEnum paymentMethod;
	
	 private ItemShop(ItemShopBuilder builder) {
		  this.item = builder.item;
		  this.paymentMethod = builder.paymentMethod;
	 }

	public ArrayList<ItemShopDetail> getItem() {
		return item;
	}
	public PaymentEnum getPaymentMethod() {
		return paymentMethod;
	}
	
	public static class ItemShopBuilder {
		private ArrayList<ItemShopDetail> item;
		private PaymentEnum paymentMethod;
		
		public ItemShopBuilder(ArrayList<ItemShopDetail> item, PaymentEnum paymentMethod) {
			this.item = item;
			this.paymentMethod = paymentMethod;
		}
		
		public ItemShop build() {
	        ItemShop itemshop =  new ItemShop(this);
	        return itemshop;
	    }
	}
}
