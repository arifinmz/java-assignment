package com.muhammadarifin.grocerybilling;

import java.util.ArrayList;

public class User {
	private String userID;
	private boolean isMember = false;
	private ItemShop itemShop;
	private boolean wantToBeMember=false;
	private ArrayList<String>offerApplicableList;
	
	
	 private User(UserBuilder builder) {
		  this.userID = builder.userID;
		  this.isMember = builder.isMember;
		  this.itemShop= builder.itemShop;
		  this.wantToBeMember = builder.wantToBeMember;
		  this.offerApplicableList = builder.offerApplicableList;
	 }
	
	public ArrayList<String> getOfferApplicable() {
		return offerApplicableList;
	}
	
	public String getUserID() {
		return userID;
	}
	public boolean isWantToBeMember() {
		return wantToBeMember;
	}
	public boolean isMember() {
		return isMember;
	}
	public ItemShop getItemShop() {
		return itemShop;
	}

	public static class UserBuilder {
		private String userID;
		private boolean isMember = false;
		private ItemShop itemShop;
		// To Trigger 100$ (If want to be a member)
		private boolean wantToBeMember=false;
		private ArrayList<String>offerApplicableList;
		
		public UserBuilder(String userID,ItemShop itemShop,boolean wantToBeMember) {
			this.userID = userID;
			this.itemShop = itemShop;
			this.wantToBeMember = wantToBeMember;
		}
		
		 public UserBuilder setMember(boolean isMember) {
	         this.isMember = isMember;
	         return this;
	     }
		 
		 public UserBuilder setOfferApplicableList(ArrayList<String> offerArrayList) {
			 this.offerApplicableList = offerArrayList;
			 return this;
		 }
		 
		public User build() {
	        User user =  new User(this);
	        return user;
	    }
	}	
}

