import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.awt.Point;
import java.awt.geom.Point2D;


public class Main {
	public static void main(String[] args) throws IOException {

		//final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));
		String line = "";
		String fail = "The gopher cannot escape.";
		String safe = "The gopher can escape through the hole at (";
		Point.Double hole;
		Point.Double gopher;
		Point.Double dog;
		Point.Double p = new Point.Double();


		while ((line = in.readLine()) != null) {
			if(!line.equals("")&&!line.equals(" ")){
				String[] token = line.split(" ");
				int c = Integer.parseInt(token[0]);
				gopher = new Point.Double();
				gopher.setLocation(Double.parseDouble(token[1]), Double.parseDouble(token[2]));
				dog = new Point.Double();
				dog.setLocation(Double.parseDouble(token[3]), Double.parseDouble(token[4]));
				boolean sikkerhet = false;
				for(int i=0; i<c; i++){
					line = in.readLine();
					token = line.split(" ");
					hole = new Point.Double();
					hole.setLocation(Double.parseDouble(token[0]), Double.parseDouble(token[1]));

					if(dist(dog, hole)>=(dist(gopher, hole)*2.0)){
						if(!sikkerhet){
							System.out.print(safe);
							customFormat("0.000", hole.getX());
							System.out.print(",");
							customFormat("0.000", hole.getY());
							System.out.println(").");
							sikkerhet = true;
						}
					}
				}
				if(!sikkerhet){
					System.out.println(fail);
				}
			}
		}
	}
	public static double dist(Point.Double p1, Point.Double p2){
		double dx = p2.x-p1.x;
		double dy = p2.y-p1.y;
		return Math.sqrt(dx*dx + dy*dy);
	}
	static public void customFormat(String pattern, double value ) {
		DecimalFormatSymbols symbol = new DecimalFormatSymbols();  
		symbol.setDecimalSeparator('.');
		DecimalFormat myFormatter = new DecimalFormat(pattern, symbol);
		String output = myFormatter.format(value);
		System.out.print(output);
	}
}

