/**
* A java program to check if four given points form a square or not.
*/ 
import java.util.Scanner;


class IsSquare {
	
	/**
	* Data Structure for Point in 2D space
	*/
	public static class Point {
		int x;
		int y;
		
		public Point (int x , int y) {
			this.x = x;
			this.y = y;
		}

	}
	
	/** A utility function to find square of distance
	* 	from point 'p' to point 'q'
	*/
	int distSq(Point p, Point q) {
    	return (p.x - q.x)*(p.x - q.x) + (p.y - q.y)*(p.y - q.y);
	}
        
        /**
         * This function returns true if (p1, p2, p3, p4) 
         * form a square, otherwise false 
         */
        boolean isSquare(Point p1, Point p2, Point p3, Point p4) {
		
            int d2 = distSq(p1, p2);  // from p1 to p2
            int d3 = distSq(p1, p3);  // from p1 to p3
            int d4 = distSq(p1, p4);  // from p1 to p4

            // If lengths if (p1, p2) and (p1, p3) are same, then
            // following conditions must met to form a square.
            // 1) Square of length of (p1, p4) is same as twice
            //    the square of (p1, p2)
            // 2) p4 is at same distance from p2 and p3
            if (d2 == d3 && 2*d2 == d4) {
                int d = distSq(p2, p4);
                return (d == distSq(p3, p4) && d == d2);
            }

            // The below two cases are similar to above case
            if (d3 == d4 && 2*d3 == d2)
            {
                int d = distSq(p2, p3);
                return (d == distSq(p2, p4) && d == d3);
            }
            if (d2 == d4 && 2*d2 == d3)
            {
                int d = distSq(p2, p3);
                return (d == distSq(p3, p4) && d == d2);
            }

            return false;
}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Point p1 = new Point(20, 10);
		Point p2 = new Point(10, 20);
		Point p3 = new Point(20, 20);
		Point p4 = new Point(10, 10);
                IsSquare obj = new IsSquare();
                boolean square = obj.isSquare(p1, p2, p3, p4);
                System.out.println(square?"Yes":"No");

	}
}
