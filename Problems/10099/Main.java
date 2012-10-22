import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.util.Scanner;

/*
 * DP:
 * from k = 1 to N
 from i = 1 to N
 from j = 1 to N
 dp[i][j] = max(dp[i][j], min(dp[i][k], dp[k][j]) )
 */
public class Main {
	public static void main(String[] args) throws Exception {

		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));

		String line;
		String[] tokens;
		int n, e, start, stop, numP;
		int scenario = 1;
		int[][] graph;
		while ((line = in.readLine()) != null) {
			tokens = line.split(" ");
			n = Integer.parseInt(tokens[0]);
			e = Integer.parseInt(tokens[1]);
			if (n == 0 && e == 0) {
				break;
			}
			int l;
			int trips;
			graph = new int[n][n];
			for (int i = 0; i < e; i++) {
				line = in.readLine();
				tokens = line.split(" ");
				graph[Integer.parseInt(tokens[0]) - 1][Integer.parseInt(tokens[1]) - 1] = Integer.parseInt(tokens[2]);
				graph[Integer.parseInt(tokens[1]) - 1][Integer.parseInt(tokens[0]) - 1] = Integer.parseInt(tokens[2]);
			}
			line = in.readLine();
			tokens = line.split(" ");
			start = Integer.parseInt(tokens[0]) - 1;
			stop = Integer.parseInt(tokens[1]) - 1;
			numP = Integer.parseInt(tokens[2]);
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						graph[i][j] = max(graph[i][j], min(graph[i][k], graph[k][j]));
					}
				}
			}
			trips = numP / (graph[start][stop] - 1);
			numP = numP % (graph[start][stop] - 1);

			System.out.println("Scenario #" + scenario);
			scenario++;
			System.out.printf("Minimum Number of Trips = ");
			if (numP == 0) {
				System.out.println(trips + "\n");
			} else {
				trips++;
				System.out.println(trips + "\n");
			}
			
		}
	}

	private static int max(int x, int y) {
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}

	private static int min(int x, int y) {
		if (x < y) {
			return x;
		} else {
			return y;
		}
	}
}