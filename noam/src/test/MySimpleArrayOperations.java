package test;

public class MySimpleArrayOperations {
    
    public static int findMin(int[] array) {
        if(!(array.length > 0)) {
            throw new IllegalArgumentException("Input array is empty");
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<array.length; i++) {
            if(array[i] <= min)
                min = array[i];
        }
        
        return min;
    }
    
    public static void multiply(int[] array, int factor) {
        if(!(array.length > 0)) {
            throw new IllegalArgumentException("Input array is empty");
        }
        
        for( int i=0; i<array.length; i++ ) {
            array[i] = array[i] * factor;
        }
    }

}
