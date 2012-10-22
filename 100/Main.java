import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader(new File("sampleinput")));
		String line;
		String[] tokens = new String[2];
		int n = 0;
		int m = 0;
		int max = 0;
		int temp = 0;

		while ((line = in.readLine()) != null) {
			max = 0;
			tokens = line.split(" ");
			if (tokens.length == 2) {
				n = Integer.parseInt(tokens[0]);
				m = Integer.parseInt(tokens[1]);
				System.out.println("" + n + " " + m + " " + maks(n, m));
			}
		}
	}

	static int cycle(int n) {
		int length = 1;
		while (n != 1) {
			length++;
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
		}
		return length;
	}

	static int maks(int n, int m) {
		int maxLengde = 0;
		int fra;
		int til;
		if (n < m) {
			fra = n;
			til = m;
		} else {
			fra = m;
			til = n;
		}

		for (int i = fra; i <= til; i++) {
			int c = cycle(i);
			if (c > maxLengde)
				maxLengde = c;
		}

		return maxLengde;
	}

}
