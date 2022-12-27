package test;

public class Ex1old {


	public static void main(String[] args) {

		int x = 5; int y = 10;

		int ans = 1;
		
		int min = x;
		
		if(y < x) {
			min = y;
}		
		
		for(int i = min; i  > 1  ; i=i-1) {
			
			if(x % i == 0 && y % i == 0) {
				
				ans = i;

				for(int j = 2; j <= Math.sqrt(i); j = j+1) {
					if(i % j == 0) {
						ans = 1;
						break;
					}
				}

				if(ans != 1) {
					break;
				}

			}
			
								
		}		

		System.out.println(ans);
//		//return ans;
//
		
	}



	}

