package com.muhammadarifin.grocerybilling;

import com.muhammadarifin.grocerybilling.ItemShopDetail.ItemShopDetailBuilder;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    
    public void testIsPaymentUsingCreditCard() {
    	assertTrue(App.isPaymentUsingCreditCard(PaymentEnum.CREDIT_CARD));
    }
    
    public void testIsPaymentUsingNotCreditCard() {
    	assertFalse(App.isPaymentUsingCreditCard(PaymentEnum.CASH));
    }
    
    public void testIsMoreThan100$() {
    	assertTrue(App.isMoreThan100$(105));
    }
    
    public void testIsLessThan100$() {
    	assertFalse(App.isMoreThan100$(50));
    }
    
    public void testCalculatePricePerItem() {
    	ItemShopDetail itemShopDetail = new ItemShopDetail.ItemShopDetailBuilder("Item 1", 2, 10).build();
    	assertEquals(App.calculatePricePerItem(itemShopDetail), 20.0,0);
    }
    
    public void testCalculateWhenUsingCreditCard() {
    	assertEquals(App.calculateWhenUsingCreditCard(100), 102.0, 0);
    }
    
    public void testCalculateWhenIsMember() {
    	assertEquals(App.calculateWhenIsMember(100), 95.0, 0);
    }
    
    
    
}
