import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

//1 + n choose 2 + n choose 4
public class Main {
	public static void main(String[] args) throws Exception {
		// final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));

		String line = in.readLine();
		int c = Integer.parseInt(line);
		for (int i = 0; i < c; i++) {
			line = in.readLine();
			int n = Integer.parseInt(line);
			solve(n);
		}
	}

	public static void solve(int n) {
		BigInteger one = new BigInteger("1");
		System.out.println(binomial(n, 2).add(binomial(n, 4).add(one)));
	}

	static BigInteger binomial(int n, int k) {
		BigInteger bin = new BigInteger("1");
		for (int i = 0; i < k; i++) {
			bin = bin.multiply(BigInteger.valueOf(n - i)).divide(BigInteger.valueOf(i + 1));
		}
		return bin;
	}

}
