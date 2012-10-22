import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		int l = 0;
		int n = 0;
		int c[] = new int[54];
		int dp[][] = new int[54][54];
		// final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader(new File("sampleinput")));
		String line = "";
		String[] tokens;

		while ((line = in.readLine()) != null) {

			l = Integer.parseInt(line);
			if (l == 0) {
				break;
			}
			line = in.readLine();
			n = Integer.parseInt(line);
			line = in.readLine();
			tokens = line.split(" ");
			c = new int[54];
			for (int i = 0; i < tokens.length; i++) {
				c[i + 1] = Integer.parseInt(tokens[i]);
			}

			c[0] = 0;
			c[n + 1] = l;

			tøm(dp);
			
			System.out.printf("The minimum cutting is %d.\n", bktk(0, n + 1, dp, c));
		}
	}

	static int bktk(int s, int e, int[][] dp, int[] c) {
		if (s + 1 == e)
			return 0;

		if (dp[s][e] != -1)
			return dp[s][e];

		int cost = 0;
		int minimum = 2147483647;

		for (int i = s + 1; i < e; i++) {
			cost = bktk(s, i, dp, c) + bktk(i, e, dp, c) + c[e] - c[s];
			if (cost < minimum)
				minimum = cost;
		}

		return dp[s][e] = minimum;
	}

	static void tøm(int[][] dp) {
		for (int i = 0; i < 54; i++) {
			for (int j = 0; j < 54; j++)
				dp[i][j] = -1;
		}
	}
}
