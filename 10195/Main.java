import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));
		double p,q,val,r;
		String line;
		String [] tokens;
		while ((line = in.readLine()) != null && !line.isEmpty()) {
				tokens = line.split(" ");
				p = Double.parseDouble(tokens[0]);
				q = Double.parseDouble(tokens[1]);
				r = Double.parseDouble(tokens[2]);
				
				if(p==0 || q==0 || r==0){
					System.out.printf("The radius of the round table is: %.3f\n" , 0.0);
				}
				else
				{
					val = (p+q+r)/2;
					val = Math.sqrt((val-p)*(val-q)*(val-r)/val);
					System.out.printf("The radius of the round table is: %.3f\n" , val);
				}
			 
		}
	}
}

