import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

//Prefix Sum
//Kadane Algorithm

public class Main {
	public static void main(String[] args) throws Exception {
		final Scanner in = new Scanner(new File("sampleinput"));
		// final Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int[][] a = new int[n + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = in.nextInt() + a[i - 1][j];
				}
			}
			System.out.println(solv(a, n));
		}
	}

	static long solv(int[][] a, int n) {

		int k = 0;
		int sum;
		int max = -2147483647;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= n - i; j++, k = 0) {
				for (int d = 0; d < n; d++) {
					sum = a[j + i][d] - a[j][d];
					if (k >= 0) {
						k = k + sum;
					} else {
						k = sum;
					}
					if (k > max) {
						max = k;
					}
				}
			}
		}
		return max;
	}
}
