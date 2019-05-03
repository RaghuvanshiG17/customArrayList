package com.epam.test;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.epam.exception.ArrayIndexOutOfBound;
import com.epam.grow.CustomList;


public class CustomListTest {
	
	CustomList<Integer> iList;
	
	@Before
	public void initializeList() {
		iList = new CustomList<Integer>(10);
	}
	
	@Test
	public void testAdd() {
		for(int i = 0 ; i < 10 ; i++) {
			iList.add(i);
		}
		assertEquals(10, iList.size());
	}
	
	@Test
	public void testfindMax() throws Exception {
		for(int i = 0 ; i < 10 ; i++) {
			iList.add(i);
		}
		assertEquals(Optional.of(9), iList.findMax());
	}
	
	@Test
	public void testfindMin() throws Exception {
		for(int i = 0 ; i < 10 ; i++) {
			iList.add(i);
		}
		assertEquals((Integer)0, iList.findMin());
	}
	
	@Test(expected = ArrayIndexOutOfBound.class)
    public void upperBound() throws ArrayIndexOutOfBound{
        iList.getElementByIndex(11);
    }
	
	@Test
	public void getElementByIndex() throws Exception {
		for(int i = 0 ; i < 10 ; i++) {
			iList.add(i);
		}
		assertEquals((Integer)5, iList.getElementByIndex(5));
	}
	
	@Test(expected = ArrayIndexOutOfBound.class)
    public void lowerBound() throws Exception{
        iList.getElementByIndex(-1);
    }
	
	
	
	
	
}
