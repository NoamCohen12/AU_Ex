package Exe.EX3;

import java.util.LinkedList;
import java.util.Queue;


/**
 * This class implements the Map2D interface.
 * You should change (implement) this class as part of Ex3. */
public class MyMap2D implements Map2D{
	private int[][] _map;
	private int numbers [][];//ADEDD


	public MyMap2D(int w, int h) {init(w,h);}
	public MyMap2D(int size) {this(size,size);}

	public MyMap2D(int[][] data) { 
		this(data.length, data[0].length);
		init(data);
	}
	@Override
	public void init(int w, int h) {
		_map = new int[w][h];

	}
	@Override
	public void init(int[][] arr) {
		init(arr.length,arr[0].length);
		for(int x = 0;x<this.getWidth()&& x<arr.length;x++) {
			for(int y=0;y<this.getHeight()&& y<arr[0].length;y++) {
				this.setPixel(x, y, arr[x][y]);
			}
		}
	}
	@Override
	public int getWidth() {return _map.length;}
	@Override
	public int getHeight() {return _map[0].length;}
	@Override
	public int getPixel(int x, int y) { return _map[x][y];}
	@Override
	public int getPixel(Point2D p) { 
		return this.getPixel(p.ix(),p.iy());
	}

	public void setPixel(int x, int y, int v) {_map[x][y] = v;}
	public void setPixel(Point2D p, int v) { 
		setPixel(p.ix(), p.iy(), v);
	}
	@Override
	/**
	 * this function finds the linear equation
	 * than colculates the x and y values for each point on the way of the segment
	 * if the distance between the y value of two points is longer than the distance between the x value of two points
	 * so it caculate's the x of every y from beggining to end
	 * and exactky the oposite for the oposite case 
	 */
	public void drawSegment(Point2D p1, Point2D p2, int v) {

		// defining min&max values to work with
		int maxX = Math.max(p1.ix(), p2.ix());
		int minX = Math.min(p1.ix(), p2.ix());
		int maxY = Math.max(p1.iy(), p2.iy());
		int minY = Math.min(p1.iy(), p2.iy());

		// defining values for the linear equation
		double dx = p1.x()-p2.x();
		double dy = p1.y()-p2.y();
		double m = dy/dx;				// incline of the line
		double b = p1.iy()-m*p1.ix(); 	// the 'free variable'

		if (Math.abs(dx)>=Math.abs(dy)) {			// case dx is longer than dy
			for (int i=minX; i<=maxX; i++) {		// run over all the x values
				double y = Math.round(m*i+b);		// calculates y value using the linear equation
				if ( !(i<0 || y<0 || i>=this.getWidth() || y>=this.getHeight()) ){		// make sure the point is in the map range
					setPixel(i, (int)y, v);
				}
			}
		}
		else {										// case dy is longer than dx
			for (int i=minY; i<=maxY; i++) {		// run over all the y values
				double x = Math.round((i-b)/m);		// calculates x value using the linear equation
				if ( !(x<0 || i<0 || x>=this.getWidth() || i>=this.getHeight()) ) {		// make sure the point is in the map range
					setPixel((int)x, i, v);
				}
			}
		}

	}



	@Override
	public void drawRect(Point2D p1, Point2D p2, int col) {//מלבן
		// TODO Auto-generated method stub

		for (int y=Math.max(p1.iy(), p2.iy()); y>=Math.min(p1.iy(), p2.iy()); y--) {
			for (int x = Math.min(p1.ix(), p2.ix()); x<=Math.max(p1.ix(), p2.ix()); x++) {
				setPixel(x, y, col);
			}
		}
	}

	@Override
	public void drawCircle(Point2D p, double rad, int col) {//מעגל
		// TODO Auto-generated method stub
		Point2D start = new Point2D(p.x()-rad ,p.y()+rad);
		Point2D end = new Point2D(p.x()+rad ,p.y()-rad);
		for(int y=start.iy();y>=end.iy();y--) {
			for (int x=start.ix();x<=end.ix();x++) {
				if ((x<0)||(y<0)||(x>=this.getWidth())||(y>=this.getHeight())) {continue;}
				Point2D tmp = new Point2D(x,y);

				double d = tmp.distance(p);
				if(d<=rad) {
					setPixel((int)x, (int)y,col);
				}
			}
		}
	}

	@Override
	public int fill(Point2D p, int new_v) { //מילוי צבע
		// TODO Auto-generated method stub
		boolean visit[][] = new boolean [this.getWidth()][this.getHeight()];
		Queue<Point2D> queue = new LinkedList<>();
		int firstColor = _map[p.ix()][p.iy()];
		queue.add(p);
		visit[p.ix()][p.iy()] = true;

		while(queue.size() != 0) {
			Point2D outPoint = queue.remove();	
			setPixel(outPoint, new_v);
			int x = outPoint.ix();
			int y = outPoint.iy();
			visit[x][y] = true;
			for (int i=x-1; i<=x+1; i++) {
				for (int j=y-1 ; j<=y+1 ; j++) {
					if(i!=x&&j!=y) {continue;}
					if(i<0||j<0||i>=this.getWidth()||j>=this.getHeight()){continue;}

					if(!visit[i][j] && _map[i][j]==firstColor) {
						queue.add(new Point2D(i, j));
						visit[i][j] = true;
					}
				}
			}

		}


		return 0;
	}

	@Override
	public int fill(int x, int y, int new_v) {
		Point2D p = new Point2D(x,y);
		this.fill(p, new_v);

		return 0;
	}

	@Override
	public Point2D[] shortestPath(Point2D p1, Point2D p2) {//דרך קצרה
		// TODO Auto-generated method stub
		int dist =shortestPathDist(p1, p2);
		if (dist==0) {return null;}
		if (dist==1){
			Point2D [] arr= new Point2D [1];
			arr[0]=p1;
			return arr  ;
		}
		Point2D ans []=new Point2D[dist];
		int index =0;
		Point2D current = p2;
		ans[index]=current;
		index++;

		while(current.ix()!=p1.ix()||current.iy()!=p1.iy()) {
			int x = current.ix();
			int y= current.iy();
			boolean exit = false;
			for (int i=x-1; i<=x+1&&!exit; i++) {
				for (int j=y-1 ; j<=y+1&&!exit ; j++) {
					if(i!=x&&j!=y) {continue;}
					if(i<0||j<0||i>=numbers.length||j>=numbers.length){continue;}

					if(numbers[i][j] == numbers[x][y]-1) {
						current=new Point2D (i ,j);
						ans[index]=current;
						index++;
						exit = true;


					}
				}
			}
		}

		return ans;
	}

	@Override
	public int shortestPathDist(Point2D p1, Point2D p2) {
		// TODO Auto-generated method stub

		Point2D first =p1;
		Point2D last =p2;
		if (first.ix()==last.ix()&&first.iy()==last.iy()) {
			return 1;
		}
		int firstColor = _map[p1.ix()][p1.iy()];
		int secondColor = _map[p2.ix()][p2.iy()];
		if (firstColor!=secondColor) {
			return 0;
		}

		numbers =new int [this.getWidth()][this.getHeight()];
		for (int i=0;i<this.getWidth();i++) {
			//Numbers[i] = new int[this.getHeight()];
			for (int j=0;j<this.getHeight();j++) {
				if (_map[i][j]!=firstColor) {
					numbers[i][j]=-1;
				}
			}
		}
		numbers [first.ix()][first.iy()]=1;
		Queue<Point2D> queue = new LinkedList<>();
		queue.add(first);
		while(true) {
			if(queue==null) {return 0;}
			Point2D outPoint = queue.remove();	
			if(queue==null) {return 0;}


			int x = outPoint.ix();
			int y = outPoint.iy();
			if(queue==null) {return 0;}

			for (int i=x-1; i<=x+1; i++) {
				for (int j=y-1 ; j<=y+1 ; j++) {
					if(i!=x&&j!=y) {continue;}
					if(i<0||j<0||i>=this.getWidth()||j>=this.getHeight()){continue;}

					if(numbers[i][j] == 0) {
						numbers[i][j]=numbers[x][y]+1;
						if(last.ix()==i&&last.iy()==j) {return numbers[i][j] ;}

						queue.add(new Point2D(i, j));
					}
				}
			}

		}
	}


	@Override
	public void nextGenGol() {  //המשחק של החיים
		// TODO Auto-generated method stub
		int [][] nextGen = new int [this.getWidth()][this.getHeight()];

		// run over the map to chek which cell is alive
		for (int i=0; i<this.getWidth(); i++) {
			for (int j=0; j<this.getHeight(); j++) {

				int aliveNeighbors = this.neighbors(i, j);

				// Implementing the rules of the game

				if ( (_map[i][j] != -1) && (aliveNeighbors<2) ) {		// cell dies becouse it's lonlyness
					nextGen [i][j] = -1;
				}
				else if ( (_map[i][j] != -1) && (aliveNeighbors>3) ) {	// cell dies due to over population
					nextGen [i][j] = -1;
				}
				else if ( (_map[i][j] == -1) && (aliveNeighbors==3) ) {	// new cell is born
					nextGen [i][j] = -16777216; // means alive (black)
				}
				else {												// remain the same as before
					nextGen [i][j] = _map[i][j];
					if ( (nextGen[i][j] != -1) && (nextGen[i][j] != -16777216) ) {nextGen[i][j] = -16777216;}
				}
			}
		}				// end of 'creating nextGen' loop

		_map = nextGen;

	}




	@Override
	public void fill(int c) {
		for(int x = 0;x<this.getWidth();x++) {
			for(int y = 0;y<this.getHeight();y++) {
				this.setPixel(x, y, c);
			}
		}

	}
	// this function counts how much alive neighbores a Point has
	public int neighbors (int x, int y) {
		int neighbors = 0;

		// run over all 8 neighbors
		for (int i=x-1; i<x+2; i++) {
			for (int j=y-1; j<y+2; j++) {

				if ( (i<0) || (j<0) || (i==this.getWidth()) || (j==this.getHeight()) ) {continue;}		// if this point is out of range

				if (i==x && j==y) {continue;}			// if this is the current point
				if (_map[i][j]==-1) {continue;}
				else {neighbors += 1;}
			}
		}
		return neighbors;
	}

}

