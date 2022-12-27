package Exe.Ex2;

import java.util.Arrays;

public class chek2 {
	
	
	public static double[] getPolynomFromString1(String p) {
		// *** add your code here ***
 
		String [] polynom = p.split("(\\s+)");
		double [] ans =	new double [polynom.length];
		for(int i = 0; i < polynom.length ;i++) {
			String monom =polynom[i];
			String num = monom.split("x")[0];
			double n = Double.parseDouble(num);
			ans[ans.length-1-i]=n;
		}
		// **************************
		return ans;
	}

	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static double[] derivative (double[] po) {
		double[] p = {1,2,3};	
		double deriv []=new double [p.length-1];//Array maximal for the derivative
		deriv[0]=p[0]+p[1];
		for (int i=2;i<p.length;i++) {
			deriv[i]=p[i]*i;
			deriv[1]=deriv[1]+p[i];
		}
		System.out.println(5);
		return po;
	}
	
	
	
	
	
	
	
	
	
	

	public static double area(double[] p1,double[]p2, double x1, double x2, int numberOfBoxes) {
		double ans = 0;

		double width =x2-x1;
		double boxWidth = width/numberOfBoxes;

		for(int i=0;i<numberOfBoxes;i++) {
			double xi = x1+boxWidth*i;
			double sum1 = f(p1, xi);
			double sum2 = f(p2,xi);
			double length = Math.abs(sum1-sum2);
			double boxArea = boxWidth *length;
			ans = ans + boxArea;

		}

		return ans;
	}




	public static double f(double[] poly, double x) {
		double ans = 0;
		// *** add your code here ***
		for(int i =0 ;i<poly.length;i=i+1) {
			ans = ans + poly[i]*Math.pow(x,i);
		}
		// **************************
		return ans;
	}






		
		
		
		
		
		
		
		
		
		
		
		
		
	//	 * For example the array {2,0,3.1,-1.2} will be presented as the following String  "-1.2x^3 +3.1x^2 +2.0"


	public static double[] getPolynomFromString(String p) {

		String [] polynom = p.split("(\\s+)");
		double [] ans =	new double [polynom.length];
		System.out.println(Arrays.toString(ans));
		for(int i = 0; i < polynom.length ;i++) {
			String monom =polynom[i];
			String num = monom.split("x")[0];
			double n = Double.parseDouble(num);
			ans[ans.length-1-i]=n;
		}
		return ans;
		// **************************
	}


	
	
	
	
	
	
	
	
	
	
	public static String poly(double[] poly) {
		String ans = "";
		// *** add your code here ***
		double [] p =  {0};
		if(p.length == 1 && p[0]==0) {// Returning the "zero polynomial"
			return "0";
		}
		for(int i = 0; i < p.length ;i++) {
			if (p[i]!=0) {
				
				if(i==0) {
					ans = p[i]+ " " + ans;
				}
				else if (i==1) {
					ans = p[i]+ "x" + " " + ans;	
				}

				else {
					ans = p[i]+ "x^" + i + " " + ans;
				}
				if(p[i]>0) {
					ans = "+" + ans;
				}
			}
		}
		if(ans.charAt(0) == '+') {
			ans = ans.substring(1, ans.length());
		}
		System.out.println(ans);
		// **************************
		return ans;
	}
	public static void main(String[] args) {
		
		
		
		
		double[] p11 =   {1,2,3,4,5};
		String str = poly(p11);
		// char c = str.charAt(0);
		String p2 = "x +5x +10x^2";
		String [] polynom = p2.split("(\\s+)");
		double [] ans =	new double [polynom.length];
		 System.out.println(Arrays.toString(ans));


		for(int i = 0; i < polynom.length ;i++) {
			String monom =polynom[i];
			String num = monom.split("x")[0];
			// System.out.print(monom+ "|");
			 //System.out.print(num+"|");
			 double n = Double.parseDouble(num);
			// System.out.print(n+"|");
			 ans[ans.length-1-i]=n;
			
		}
		 System.out.println(Arrays.toString(ans));
		// System.out.println(str.split(".^").toString());
	//	 System.out.println(p11.toString());
		
		
		
		
		
		
		//  double[] p21 =   {1,2,3,4,5,6,7};
		//  double[] sum = new double[Math.max(p11.length, p21.length)]; 
		//	
		//  int i = 0;
		//  
		//	while (i<p11.length&&i<p21.length) {
		//	sum[i] = p11[i] + p21[i];
		//	i=i+1;
		//	}
		//    while (i<p11.length) {
		//    	sum[i]=p11[i];
		//    i=i+1;
		//    }
		//
		//    while (i<p11.length) {
		//    	sum[i]=p11[i];
		//    i=i+1;
		//    }
		//	 System.out.println(sum);


	}
}
