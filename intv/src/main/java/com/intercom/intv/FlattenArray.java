package com.intercom.intv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Java class to flatten an array of arbitrarily nested arrays of integers 
 * into a flat array of integers. 
 * E.g. [[1,2,[3]],4] -> [1,2,3,4].
 * </p>
 */

public class FlattenArray {

	/**
	 * Method that converts a nested array of integers(eg: [1,2,[3]],4]) 
	 * into a flattened array(Eg. [1,2,3,4])
	 * @param nestedArray: nested array of objects. Which further gets granulated into array of integers 
	 * @param flattenedArray: Resultant flattened array list.
	 * @return: This is a array version of the param2 of the method.
	 * @throws InvalidInputException 
	 */
	public int[] flattenArrayToIntArray(Object[] nestedArray, List flattenedArray) throws InvalidInputException
	{
		//variable to store the resultant int array.
		List<Integer> flattenedArrayList = flattenArrayToList(nestedArray, flattenedArray);

		//Since the ask of the test is to get a integer array this variable stores the integer array.
		int intArray[] = new int[flattenedArrayList.size()];
		
		//Covert list to integer array. This could have been done in a one line operation using Java8.
		//Since I dont have Java 8 I am using traditional conversion.
		for(int i=0; i< flattenedArrayList.size(); i++){
			intArray[i] = (int) flattenedArrayList.get(i);
		}
		
		return intArray;
	}
	
	/**
	 * Method that converts a nested array of integers(eg: [1,2,[3]],4]) 
	 * into a flattened array(Eg. [1,2,3,4])
	 * @param nestedArray: nested array of objects. Which further gets granulated into array of integers 
	 * @param flattenedArray: Resultant flattened array list.
	 * @return: The value of the return method is same as Param2. It is used in param2 so that method 
	 * can be reused recursively.
	 * @throws InvalidInputException 
	 */
	private List flattenArrayToList(Object[] nestedArray, List flattenedArray) throws InvalidInputException
	{
		for(int i=0; i< nestedArray.length; i++)
		{
			//the nested array's i'th value copied to object. 
			//(Only for readability) 
			Object object = nestedArray[i];

			//object is checked if it is an integer. If it is it is added to the flattened list.
			if(object instanceof Integer)
			{
				flattenedArray.add(object);
			}
			//object is checked if it is an integer array. If it is it is added to the flattened list.
			else if(object instanceof int[])
			{
				int[] integerArray = ((int[])object);
				for(int j=0; j< integerArray.length; j++)
				{
					flattenedArray.add(integerArray[j]);
				}
			}
			//This is where the recursive call is made depending on the type of the object. 
			//Should the object be a instance of Object array it is expected to call the method itself recursively.
			else if(object instanceof Object[])
			{
				//Recursive call.
				//we pass the new object array as argument and retain the flattened array. 
				flattenArrayToList(((Object[])object), flattenedArray); 
			}
			else
			{
				throw new InvalidInputException();
			}
		}
		return flattenedArray;
	}



	public class InvalidInputException extends Exception{
		
	}
}
