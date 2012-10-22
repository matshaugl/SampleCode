import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

class Main {

	static int n, m;
	static char[][] a = new char[102][102];

	public static void main(String[] args) throws Exception {
		// final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));

		String line;
		String[] tokens;
		char[] ctokens;
		int c = 1;
		boolean firstLine = true;

		while ((line = in.readLine()) != null) {
			if(!firstLine){
				System.out.println();
			}
			firstLine = false;
			tokens = line.split(" ");
			n = Integer.parseInt(tokens[0]);
			m = Integer.parseInt(tokens[1]);
			if (n == 0 && m == 0) {
				break;
			}
			for (int i = 0; i < n; i++) {
				ctokens = in.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					a[i + 1][j + 1] = ctokens[j];
				}
			}
			System.out.println("Field #" + c + ":");
			solve();
			c++;
		}
	}

	static void solve() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a[i][j] == '*') {
					System.out.print('*');
				} else {
					int c = check(i - 1, j - 1) + check(i - 1, j) + check(i - 1, j + 1) + check(i, j - 1) + check(i, j + 1) + check(i + 1, j - 1)
							+ check(i + 1, j) + check(i + 1, j + 1);
					System.out.print(c);
				}
			}
			System.out.println();
		}
	}

	static int check(int i, int j) {
		return (a[i][j] == '*') ? 1 : 0;
	}
}