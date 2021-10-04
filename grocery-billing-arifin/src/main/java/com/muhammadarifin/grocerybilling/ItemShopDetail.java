package com.muhammadarifin.grocerybilling;

public class ItemShopDetail {
	private String itemName;
	private float itemPrice;
	private int itemSize;
	
	public ItemShopDetail(ItemShopDetailBuilder builder) {
		this.itemName = builder.itemName;
		this.itemPrice = builder.itemPrice;
		this.itemSize = builder.itemSize;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemSize() {
		return itemSize;
	}
	public void setItemSize(int itemSize) {
		this.itemSize = itemSize;
	}
	
	public static class ItemShopDetailBuilder {
		private String itemName;
		private float itemPrice;
		private int itemSize;
		
		public ItemShopDetailBuilder(String itemName,float itemPrice,int itemSize) {
			this.itemName = itemName;
			this.itemPrice = itemPrice;
			this.itemSize = itemSize;
		}
		
		public ItemShopDetail build() {
			ItemShopDetail itemshop =  new ItemShopDetail(this);
	        return itemshop;
	    }
	}
	
	
}
