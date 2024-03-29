/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import bean.*;
/**
 *
 * @author BEST
 */
public class MoneyBagTest {
    private Money f12CHF;
    private Money _f12CHF;
    private Money f14CHF;
    private Money f7USD;
    private Money f21USD;
    private MoneyBag fMB2;
    private MoneyBag fMB1;
    
    
    @Before
    public void setUp() {
        f12CHF= new Money(12, "CHF");
        _f12CHF= new Money(-12, "CHF");
        f14CHF= new Money(14, "CHF");
        f7USD= new Money( 7, "USD");
        f21USD= new Money(21, "USD");
        fMB1= new MoneyBag(f12CHF, f7USD);
        fMB2= new MoneyBag(f14CHF, f21USD);
    }
    @Test
    public void testBagEquals() {
        assertTrue(!fMB1.equals(null)); 
        assertEquals(fMB1, fMB1); 
        assertTrue(!fMB1.equals(f12CHF)); 
        assertTrue(!f12CHF.equals(fMB1)); 
        assertTrue(!fMB1.equals(fMB2));
    }
    @Test
    public void testMixedSimpleAdd() {
        // [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
        Money bag[] = { f12CHF, f7USD };
        MoneyBag expected = new MoneyBag(bag);
        assertEquals(expected, f12CHF.add(f7USD));
    }
  @Test
public void testBagSimpleAdd() {
    // [12 CHF] + [21 USD] + [14 CHF] == {[12 CHF][21 USD][14 CHF]}
    Money bag[] = { f21USD, f14CHF };
    MoneyBag bag_ = new MoneyBag(bag);
    MoneyBag result = (MoneyBag) f12CHF.add(bag_);
    MoneyBag expected = new MoneyBag(new IMoney[] { f12CHF, f21USD, f14CHF });
   
    assertEquals(expected, result);
}

    /**
     *
     */
    @Test
public void testSimpleBagAdd() {
     // [12 CHF] + [7 USD] + [14 CHF] == {[12 CHF][7 USD][14 CHF]}
    
    Money bag1[] = { f7USD, f12CHF };
    MoneyBag bag1_ = new MoneyBag(bag1);
    _f12CHF.add(bag1_);
    Money bagExp[] = {  f7USD,_f12CHF , f12CHF  };
    MoneyBag expected = new MoneyBag(bagExp);
    System.out.println("type of add bag  "+bag1_.typeOf());
    System.out.println("type of the expected  "+expected.typeOf());
      

    assertEquals(expected, bag1_);
}
    @Test
    public void testBagBagAdd() {
        // [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
        Money bag1[] = { f12CHF, f7USD };
        MoneyBag bag1_ = new MoneyBag(bag1);
        Money bag2[] = { f12CHF, f7USD };
        MoneyBag bag2_ = new MoneyBag(bag2);
        Money bag[] = { f12CHF, f7USD,f12CHF, f7USD };
        MoneyBag expected = new MoneyBag(bag);
        bag1_.add(bag2_);
        assertEquals(expected,bag1_ );
    }
    @Test
    public void test3() {
    
        Money bag1[] = { f7USD, f12CHF };
        MoneyBag bag1_ = new MoneyBag(bag1);
        _f12CHF.add(bag1_);
        Money bagExp[] = {  f7USD,_f12CHF , f12CHF  };
        MoneyBag expected = new MoneyBag(bagExp);
        System.out.println("type of add bag  "+bag1_.typeOf());
        System.out.println("type of the expected  "+expected.typeOf());
          
    
        assertEquals(expected, bag1_);
    }
    @Test
    public void test2() {
        Money bag[] = {  f7USD };
        MoneyBag bag_ = new MoneyBag(bag);
        Money bag1[] = { f7USD };
        MoneyBag bag1_ = new MoneyBag(bag);
        bag_.add(bag1_);
        Money bagExp[] = {  f7USD, f7USD };
        MoneyBag expected = new MoneyBag(bagExp);
        System.out.println("type of add bag  "+bag_.typeOf());
        System.out.println("type of the expected  "+expected.typeOf());
          
    
        assertEquals(expected, bag_);
    }
    @Test
    public void test1() {
        Money bag[] = { f12CHF, f7USD };
        MoneyBag bag_ = new MoneyBag(bag);
        bag_.add(_f12CHF);
        Money bagExp[] = { f12CHF, f7USD, _f12CHF };
        MoneyBag expected = new MoneyBag(bagExp);
        for(IMoney m : bag_.getFMonies()){
    
            System.out.println(m);
            System.out.println(m.amount());
            System.out.println(m.currency());
        }
    }
    
}
