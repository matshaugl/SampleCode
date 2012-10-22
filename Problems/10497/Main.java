import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

//10497
//Rekn ut fib til 800. BigIntger
public class Main {
	public static void main(String[] args) throws Exception {
		// final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));

		BigInteger[] fib = new BigInteger[801];
		fib[1] = new BigInteger("0");
		fib[0] = new BigInteger("0");
		for (int i = 2; i < 801; i++) {
			fib[i] = fib[i - 1].multiply(BigInteger.valueOf(i));
			if (i % 2 == 0) {
				fib[i] = fib[i].add(BigInteger.valueOf(1));
			} else {
				fib[i] = fib[i].add(BigInteger.valueOf(-1));
			}
		}
		int n;
		while ((n = Integer.parseInt(in.readLine())) != -1) {
			System.out.println(fib[n]);
		}
	}
}
