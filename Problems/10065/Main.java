import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		//final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));
		String line;
		String[] tokens;
		Point p;

		while ((line = in.readLine()) != null){

			int c = Integer.parseInt(line);
			if(c==0){
				break;
			}
			Point[] poly = new Point[c];
			Point[] poly2;

			for(int i=0; i<c; i++){
				line = in.readLine();
				tokens = line.split(" ");
				p = new Point(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]));
				poly[i] = p;
			}

			ArrayList<Point> graham;

			graham = grahamScan(poly);

			poly2 = new Point[graham.size()];

			for(int i=0; i<poly2.length; i++){
				poly2[i] = graham.get(i);
			}
			double a1 = Math.abs(area(poly2));
			double a2 = Math.abs(area(poly));
			System.out.println("Tile #" + c);
			System.out.printf(Locale.US, "Wasted Space = %.2f\n", (1-(a2/a1)));

		}

	}


	public static double area(Point[] polyPoints) {
		int i, j, n = polyPoints.length;
		double area = 0;

		for (i = 0; i < n; i++) {
			j = (i + 1) % n;
			area += polyPoints[i].getX() * polyPoints[j].getY();
			area -= polyPoints[j].getX() * polyPoints[i].getY();
		}
		area /= 2.0;
		return (area);
	}

	
	public static ArrayList<Point> grahamScan(Point[] polygon) {
		int min = 0;
        int length = polygon.length;
        for (int i = 1; i < length; i++) {
            Point get = polygon[i];
            if (get.y < polygon[min].y) {
                min = i;
            } else {
                if (get.y == polygon[min].y) {
                    if (get.x < polygon[min].x) {
                        min = i;
                    }
                }
            }
        }
        final Point pivot = polygon[min];
        ArrayList<Point> sorted = new ArrayList<Point>();
        for(int i=0; i<polygon.length; i++){
        	sorted.add(polygon[i]);
        }
        Collections.sort(sorted, new C(pivot));
        sorted.add(0, pivot);
        Stack<Point> stack = new Stack<Point>();
        stack.push(sorted.get(length - 1));
        stack.push(pivot);
        int i = 1;
        while (i < length) {
            Point pt1 = stack.pop();
            Point pt2 = stack.peek();
            stack.push(pt1);
            if (isLeftTurn(pt1, pt2, sorted.get(i))) {
            	stack.push(sorted.get(i));
                i++;
            } else {
                stack.pop();
            }
        }
        ArrayList<Point> convex = new ArrayList<Point>();
        while (!stack.isEmpty()) {
            convex.add(stack.pop());
        }
        convex.remove(convex.size() - 1);
        return convex;
    }

    private static int distance(Point a, Point b) {
        int dx = a.x - b.x, dy = a.y - b.y;
        return dx * dx + dy * dy;
    }

    private static int area(Point a, Point b, Point c) {
        int area = a.x * b.y - a.y * b.x + b.x * c.y - b.y * c.x + c.x * a.y - c.y * a.y;
    	return area;
    }

    private static boolean angle_cmp(Point pivot, Point a, Point b) {
        if (area(pivot, a, b) == 0) {
            return distance(pivot, a) < distance(pivot, b);
        }
        int d1x = a.x - pivot.x, d1y = a.y - pivot.y;
        int d2x = b.x - pivot.x, d2y = b.y - pivot.y;
        return (Math.atan2((double) d1y, (double) d1x) - Math.atan2((double) d2y, (double) d2x)) < 0;
    }

    private static int turnTest(Point p, Point q, Point r) {
        int result = (r.x - q.x) * (p.y - q.y) - (r.y - q.y) * (p.x - q.x);
        if (result < 0) {
            return -1;
        }
        if (result > 0) {
            return 1;
        }
        return 0;
    }

    private static boolean isLeftTurn(Point p, Point q, Point r) {
        return turnTest(p, q, r) > 0;
    }
    static class C implements Comparator<Point> {
    	Point pivot;
    	public C(Point p){
    		pivot = p;
    	}
        public int compare(Point o1, Point o2) {
            if (o1.equals(o2)) {
                return 0;
            }
            if (angle_cmp(pivot, o1, o2)) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
