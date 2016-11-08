package com.intercom.intv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.intercom.intv.FlattenArray.InvalidInputException;

import junit.framework.Assert;

/**
 * <p>
 * JUnit test to test {@link FlattenArray} class.
 * </p> 
 */


public class FlattenArrayTest {

	//Object to be tested.
	FlattenArray flattenArray;
	
	Object[] nestedArray;
	Object[] nestedArrayWithEmptyArray;
	Object[] nestedArrayWithAllEmptyArray;
	Object[] nestedArrayWithFirstElementEmptyArray;
	Object[] nestedArrayWithLastElementEmptyArray;
	Object[] nestedArrayWithStringArray;
	Object[] nestedArrayWithCharArray;
	Object[] nestedArrayWithDoubleArray;

	 /**
     * This method calls at startup, all setup or initialisation of object is done here.
     */

    @Before
    public void setUp() throws Exception {
    	flattenArray = new FlattenArray();
    	int a= 1;
		int[] b = {2,3,4};
		int[] b1 = {};
		String[] stringArray = {"a", "b"};
		char[] charArray = {'a', 'b'};
		double[] doubleArray = {1.44, 4.44};
		
		Object []c = {5, b,a};
		Object []d = {6, c,b};
		Object []e = {7};
		Object []f = {8};
		Object []g1 = {9, f, e, d, c, b, a};
		Object []g2 = {9, f, e, d, c, b, b1, a};
		Object []g3 = {b1,b1,b1};
		Object []g4 = {b1,g1};
		Object []g5 = {g1,b1};
		
		nestedArray = g1;
		nestedArrayWithEmptyArray = g2;
		nestedArrayWithAllEmptyArray = g3;
		
		nestedArrayWithFirstElementEmptyArray = g4;
		nestedArrayWithLastElementEmptyArray = g5;
		
		
		Object[] g6 = {g1, stringArray};
		Object[] g7 = {g1, charArray};
		Object[] g8 = {g1, doubleArray};
		
		nestedArrayWithStringArray = g6;
		nestedArrayWithCharArray = g7;
		nestedArrayWithDoubleArray = g8;
		
    }
    
    //Covers the happy flow. i.e. nested array has only integer values.
    @Test
	public void testFlattenArrayHappyFlow() throws InvalidInputException 
	{
		List flattenedArray = new ArrayList();
		
		int actualResult[] = flattenArray.flattenArrayToIntArray(nestedArray, flattenedArray);
		int[] expectedResult = {9, 8, 7, 6, 5, 2, 3, 4, 1, 2, 3, 4, 5, 2, 3, 4, 1, 2, 3, 4, 1};
	
		Assert.assertTrue("Actual and Expected are not equal. Please fix the code.", Arrays.equals(actualResult, expectedResult));
	}
    
    //Part of happy flow, except that some arrays are empty.
    @Test
	public void testFlattenArrayWithEmptyArray()throws InvalidInputException
	{
		List flattenedArray = new ArrayList();
		
		int actualResult[] = flattenArray.flattenArrayToIntArray(nestedArrayWithEmptyArray, flattenedArray);
		int[] expectedResult = {9, 8, 7, 6, 5, 2, 3, 4, 1, 2, 3, 4, 5, 2, 3, 4, 1, 2, 3, 4, 1};
	
		Assert.assertTrue("Actual and Expected are not equal. Please fix the code.", Arrays.equals(actualResult, expectedResult));
	}
    
    //Part of happy flow, except that all arrays are empty.
    @Test
	public void testFlattenArrayWithAllEmptyArray()throws InvalidInputException
	{
		List flattenedArray = new ArrayList();
		
		int actualResult[] = flattenArray.flattenArrayToIntArray(nestedArrayWithAllEmptyArray, flattenedArray);
		int[] expectedResult = {};
	
		Assert.assertTrue("Actual and Expected are not equal. Please fix the code.", Arrays.equals(actualResult, expectedResult));
	}
    
    //Part of happy flow, except that 1st array element is empty.
    @Test
	public void testFlattenArrayWithFirstElementEmptyArray()throws InvalidInputException
	{
		List flattenedArray = new ArrayList();
		
		int actualResult[] = flattenArray.flattenArrayToIntArray(nestedArrayWithFirstElementEmptyArray, flattenedArray);
		int[] expectedResult = {9, 8, 7, 6, 5, 2, 3, 4, 1, 2, 3, 4, 5, 2, 3, 4, 1, 2, 3, 4, 1};
	
		Assert.assertTrue("Actual and Expected are not equal. Please fix the code.", Arrays.equals(actualResult, expectedResult));
	}   
    
    //Part of happy flow, except that last array element is empty.
    @Test
   	public void testFlattenArrayWithLastElementEmptyArray()throws InvalidInputException
   	{
   		List flattenedArray = new ArrayList();
   		
   		int actualResult[] = flattenArray.flattenArrayToIntArray(nestedArrayWithLastElementEmptyArray, flattenedArray);
		int[] expectedResult = {9, 8, 7, 6, 5, 2, 3, 4, 1, 2, 3, 4, 5, 2, 3, 4, 1, 2, 3, 4, 1};
   	
   		Assert.assertTrue("Actual and Expected are not equal. Please fix the code.", Arrays.equals(actualResult, expectedResult));
   	}
    
    
    //This test should throw exception as the inputs are invalid. (input contains string array)
    @Test(expected = InvalidInputException.class) 
	public void testFlattenArrayIntAndStringArray()throws InvalidInputException
	{
		List flattenedArray = new ArrayList();
		
		int actualResult[] = flattenArray.flattenArrayToIntArray(nestedArrayWithStringArray, flattenedArray);
		int[] expectedResult = {9, 8, 7, 6, 5, 2, 3, 4, 1, 2, 3, 4, 5, 2, 3, 4, 1, 2, 3, 4, 1};
	
		Assert.assertTrue("Actual and Expected are not equal. Please fix the code.", Arrays.equals(actualResult, expectedResult));
	}
  
    //This test should throw exception as the inputs are invalid. (input contains char array)
    @Test(expected = InvalidInputException.class) 
	public void testFlattenArrayIntAndCharArray()throws InvalidInputException
	{
		List flattenedArray = new ArrayList();
		
		int actualResult[] = flattenArray.flattenArrayToIntArray(nestedArrayWithCharArray, flattenedArray);
		int[] expectedResult = {9, 8, 7, 6, 5, 2, 3, 4, 1, 2, 3, 4, 5, 2, 3, 4, 1, 2, 3, 4, 1};
	
		Assert.assertTrue("Actual and Expected are not equal. Please fix the code.", Arrays.equals(actualResult, expectedResult));
	}
  
    //This test should throw exception as the inputs are invalid. (input contains double array)
    @Test(expected = InvalidInputException.class) 
	public void testFlattenArrayIntAndDoubleArray()throws InvalidInputException
	{
		List flattenedArray = new ArrayList();
		
		int actualResult[] = flattenArray.flattenArrayToIntArray(nestedArrayWithDoubleArray, flattenedArray);
		int[] expectedResult = {9, 8, 7, 6, 5, 2, 3, 4, 1, 2, 3, 4, 5, 2, 3, 4, 1, 2, 3, 4, 1};
	
		Assert.assertTrue("Actual and Expected are not equal. Please fix the code.", Arrays.equals(actualResult, expectedResult));
	}
}
