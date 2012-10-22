import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {
	public static void main(String[] args) throws Exception {
		//final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));

		int N = 500;
		BigInteger[] fib = new BigInteger[N];
		fib[0] = new BigInteger("0");
		fib[1] = new BigInteger("1");
		//fib[2] = new BigInteger("2");
		for (int i = 2; i < N; i++) {
			fib[i] = fib[i - 1].add(fib[i - 2]);
		}
		String line;
		String[] tokens;
		
		while ((line = in.readLine()) != null) {
			BigInteger n, m;
			tokens = line.split(" ");
			int c = 0;
			n = new BigInteger(tokens[0]);
			m = new BigInteger(tokens[1]);
			if (n.compareTo(new BigInteger("0")) == 0 && m.compareTo(new BigInteger("0")) == 0) {
				break;
			}
			if(n.toString().equals("0")){
				n=n.add(new BigInteger("1"));
			}
			int j = 0, i = 0;
			while (fib[i].compareTo(n) == -1)
				i++;
			j = i;
			while (fib[j].compareTo(m) == -1)
				j++;
			if (fib[j].compareTo(m) == 0)
				j++;
			System.out.println(j - i);

		}
	}
}
