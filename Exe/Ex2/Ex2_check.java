package Exe.Ex2;

import java.util.Arrays;

public class Ex2_check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] p2= {3,10,-2}, pl = {-7,-3,1};
		double x1=1;
		double x2=10;
		double eps = 0.001;
		double ans =  sameValue(pl, p2, x1, x2, eps);
		System.out.println(ans);

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




	public static double sameValue(double[] p1, double[] p2, double x1, double x2, double eps) {
		double x12 = (x1+x2)/2;
		// *** add your code here ***

		if (f(p1, x1) > f(p2, x1)) {											// if p1 go's down and p2 go's up

			do {

				if ( Math.abs(f(p1, x12) - f(p2, x12)) < eps ) {return x12;}	// calculate to know if this is the cut point

				if (f(p1, x12) < f(p2, x12)) {									// this means we passet over the cut point
					x2 = x12;													// change the maximal value of the range
					x12 = (x1+x2)/2;
				}

				else if (f(p1, x12) > f(p2, x12)) {								// this means we didn't pass over the cut point yet
					x1 = x12;													// change the minimal value of the range
					x12 = (x1+x2)/2;
				}

			} while (f(p1, x12) != f(p2, x12));
		}

		else if (f(p1, x1) < f(p2, x1)) {											// if p2 go's down and p1 go's up

			do {

				if ( Math.abs(f(p1, x12) - f(p2, x12)) < eps ) {return x12;}		// calculate to know if this is the cut point

				if (f(p1, x12) < f(p2, x12)) {										// this means we didn't pass over the cut point yet
					x1 = x12;														// change the minimal value of the range
					x12 = (x1+x2)/2;
				}

				else if (f(p1, x12) > f(p2, x12)) {									// this means we passet over the cut point
					x2 = x12;														// change the maximal value of the range
					x12 = (x1+x2)/2;
				}

			} while (f(p1, x12) != f(p2, x12));
		}

		// **************************
		

		// *** add your code here ***

		// **************************
		return x12;
	}
}	

