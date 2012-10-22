import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {

		// final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));
		String line;
		String[] tokens;
		int c = Integer.parseInt(in.readLine());

		for (int i = 0; i < c; i++) {
			tokens = in.readLine().split(" ");
			int r = Integer.parseInt(tokens[0]);
			int[] relatives = new int[r];
			for (int j = 1; j <= r; j++) {
				relatives[j - 1] = Integer.parseInt(tokens[j]);
			}
			int sum = 0;
			int median;
			if(r%2==0){
				median = (relatives[r / 2] + relatives[r / 2 - 1]) / 2;
			}
			else{
				median = relatives[r / 2];
			}
			for (int j = 0; j < relatives.length; j++)
				sum += Math.abs(relatives[j] - median);
			System.out.println(sum);

		}
	}
}