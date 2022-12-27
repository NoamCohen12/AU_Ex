package test;

import java.util.Scanner;

public class marach {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	}
		   public static boolean Palindrome(String s) {
		        int a=0;
		        int b=s.length()-1;
		        
		        while (a<b) {
		            if (s.charAt(a) != s.charAt(b))
		                return false;
		            a++;
		            b--;
		        }
		        return true;
		   } 
			}

	
