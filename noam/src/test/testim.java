package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class testim {

	@Test
	public void test() {
		int [] input1 = {10,5,4,7};
		assertEquals(MySimpleArrayOperations.findMin(input1), 4);

		int [] input2 = {4,5,4,7};
		assertEquals(MySimpleArrayOperations.findMin(input2), 4);

		int [] input3 = {7,7,7,7};
		assertEquals(MySimpleArrayOperations.findMin(input3), 7);
	

		int [] input4 = {-1,5,4,7};
		assertEquals(MySimpleArrayOperations.findMin(input4), -1);
	
	}
	

	@Test
	public void test2() {
		int [] input5 = {10,5,4,7};
		//assertEquals(MySimpleArrayOperations.multiply(input5, 10, );

		
		
		
		
		
		
		
		
		
		
		
		
}
}