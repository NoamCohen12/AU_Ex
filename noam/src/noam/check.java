package noam;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class check {

	public static void main(String[] args) {
		int arr [][]=new int [10][10];
		arr [5][6]=-1;
		arr [5][5]=-1;
		arr [5][4]=-1;
		arr [5][3]=-1;
		arr [6][9]=-1;
		arr [6][9]=-1;
		arr [7][9]=-1;
		arr [8][9]=-1;
		arr [9][9]=-1;
		arr [2][2]=-1;
		arr [3][2]=-1;
		arr [4][2]=-1;
		arr [5][2]=-1;
		arr [6][2]=-1;
		arr [7][2]=-1;
		arr [8][2]=-1;


		Point2D first =new Point2D (5,0);
		Point2D last =new Point2D (5,7);
		arr[first.ix()][first.iy()]=1;
		arr[last.ix()][last.iy()]=0;

		Queue<Point2D> queue = new LinkedList<>();
		queue.add(first);
		boolean exit = false;
		while(!exit) {
			Point2D outPoint = queue.remove();	

			int x = outPoint.ix();
			int y = outPoint.iy();
			for (int i=x-1; i<=x+1; i++) {
				for (int j=y-1 ; j<=y+1 ; j++) {
					if(i!=x&&j!=y) {continue;}
					if(i<0||j<0||i>=arr.length||j>=arr.length){continue;}

					if(arr[i][j] == 0) {
						arr[i][j]=arr[x][y]+1;
						if(last.ix()==i&&last.iy()==j) {exit = true;}
						queue.add(new Point2D(i, j));
					}
				}
			}

		}
		printArr(arr);
		System.out.println("****************************************************************************");
		System.out.println();


		int color [][]=new int [10][10];


		Point2D current = last;
		int x = current.ix();
		int y= current.iy();
		color[x][y]=1;

		while(current.ix()!=first.ix()||current.iy()!=first.iy()) {
			x = current.ix();
			y= current.iy();
			exit = false;
			for (int i=x-1; i<=x+1&&!exit; i++) {
				for (int j=y-1 ; j<=y+1&&!exit ; j++) {
					if(i!=x&&j!=y) {continue;}
					if(i<0||j<0||i>=arr.length||j>=arr.length){continue;}

					if(arr[i][j] == arr[x][y]-1) {
						color[i][j]=1;
						current=new Point2D (i ,j);
						exit = true;


					}
				}
			}
		}
		printArr(color);


	}
	public static void printArr(int arr [][]) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]+"\t");

			}
			System.out.println();
		}


	}
}
