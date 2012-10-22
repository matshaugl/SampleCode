import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));
		String line;
		String[] tokens;
		int n, p, r;
		int c = Integer.parseInt(in.readLine());
		for (int i = 0; i < c; i++) {
			tokens = in.readLine().split(" ");
			n = Integer.parseInt(tokens[0]);
			p = Integer.parseInt(tokens[1]);
			r = Integer.parseInt(tokens[2]);
			System.out.println(solve(n, p, r));
		}
	}

	static int solve(int n, int p, int r) {
		int res = 0;
		int k;

		if (n == p) {
			return 1;
		}
		if ((n == 1) && ((p != 1) || (r != 1))) {
			return 0;
		}
		if ((n >= 2) && ((p + r) < 3)) {
			return 0;
		}
		if ((n >= 2) && ((p + r) > n + 1)) {
			return 0;
		}
		if (r > p) {
			return solve(n, r, p);
		}
		if ((p == 2) && (r == 1)) {
			return fac(n - 2);
		}
		if (r == 1) {
			for (k = p - 1; k <= n - 1; k++) {
				res = res + solve(k, p - 1, 1) * bin(n - 2, k - 1) * fac(n - k - 1);
			}
			return res;
		}
		for (k = p; k <= n - r + 1; k++) {
			res = res + solve(k, p, 1) * solve(n - k + 1, r, 1) * bin(n - 1, k - 1);
		}
		return res;
	}

	static int fac(int n) {
		int res = 1;
		if (n <= 1) {
			return res;
		}
		for (int i = 2; i <= n; i++) {
			res = res * i;
		}
		return res;
	}

	static int bin(int n, int m) {
		int[] b = new int[n + 1];
		b[0] = 1;
		for (int i = 1; i <= n; i++) {
			b[i] = 1;
			for (int j = (i - 1); j > 0; j--) {
				b[j] = b[j] + b[j - 1];
			}
		}
		return b[m];
	}
}
