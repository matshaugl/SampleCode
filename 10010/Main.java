import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));
		int c = Integer.parseInt(in.readLine());
		int t = 0;
		String line;
		String[] tokens;
		while (t < c) {
			t++;
			// read blank line
			in.readLine();
			if ((line = in.readLine()) != null) {
				tokens = line.split(" ");
				int row = Integer.parseInt(tokens[0]);
				int col = Integer.parseInt(tokens[1]);
				char[][] a = new char[row][col];

				for (int n = 0; n < row; n++) {
					line = in.readLine();
					char[] chars = line.toCharArray();
					for (int m = 0; m < chars.length; m++) {
						a[n][m] = Character.toLowerCase(chars[m]);
					}
				}

				int nWords = Integer.parseInt(in.readLine());
				for (int w = 0; w < nWords; w++) {
					String word = in.readLine().toLowerCase();
					int[] coord = findString(a, word);
					System.out.println((coord[0]+1) + " " + (coord[1]+1));
				}

				if (t < c) {
					System.out.println();
				}
			}
		}
	}

	static int[] findString(char[][] a, String s) {
		for (int n = 0; n < a.length; n++) {
			for (int m = 0; m < a[n].length; m++) {
				if (a[n][m] == s.charAt(0)) { // char in this grid position is the same as the first character of the string
					if (checkE(a, s, n, m) || checkN(a, s, n, m) || checkNE(a, s, n, m)
							|| checkNW(a, s, n, m) || checkS(a, s, n, m) || checkSE(a, s, n, m)
							|| checkSW(a, s, n, m) || checkW(a, s, n, m)) {
						return new int[] { n, m };
					}
				}
			}
		}

		return null;
	}

	static boolean checkN(char[][] a, String string, int n, int m) {
		boolean ret = true;
		for (int i = 0; i < string.length(); i++) {
			if (!(n >= 0 && a[n][m] == string.charAt(i))) {
				ret = false;
			}
			n--;
		}
		return ret;
	}

	static boolean checkS(char[][] a, String string, int n, int m) {
		boolean ret = true;
		for (int i = 0; i < string.length(); i++) {
			if (!(n < a.length && a[n][m] == string.charAt(i))) {
				ret = false;
			}
			n++;
		}
		return ret;
	}

	static boolean checkW(char[][] a, String string, int n, int m) {
		boolean ret = true;
		for (int i = 0; i < string.length(); i++) {
			if (!(m >= 0 && a[n][m] == string.charAt(i))) {
				ret = false;
			}
			m--;
		}
		return ret;
	}

	static boolean checkE(char[][] a, String string, int n, int m) {
		boolean ret = true;
		for (int i = 0; i < string.length(); i++) {
			if (!(m < a[n].length && a[n][m] == string.charAt(i))) {
				ret = false;
			}
			m++;
		}
		return ret;
	}

	static boolean checkNE(char[][] a, String string, int n, int m) {
		boolean ret = true;
		for (int i = 0; i < string.length(); i++) {
			if (!(n >= 0 && m < a[n].length && a[n][m] == string.charAt(i))) {
				ret = false;
			}
			n--;
			m++;
		}
		return ret;
	}

	static boolean checkNW(char[][] a, String string, int n, int m) {
		boolean ret = true;
		for (int i = 0; i < string.length(); i++) {
			if (!(n >= 0 && m >= 0 && a[n][m] == string.charAt(i))) {
				ret = false;
			}
			n--;
			m--;
		}
		return ret;
	}

	static boolean checkSW(char[][] a, String string, int n, int m) {
		boolean ret = true;
		for (int i = 0; i < string.length(); i++) {
			if (!(n < a.length && m >= 0 && a[n][m] == string.charAt(i))) {
				ret = false;
			}
			n++;
			m--;
		}
		return ret;
	}

	static boolean checkSE(char[][] a, String string, int n, int m) {
		boolean ret = true;
		for (int i = 0; i < string.length(); i++) {
			if (!(n < a.length && m < a[n].length && a[n][m] == string.charAt(i))) {
				ret = false;
			}
			n++;
			m++;
		}
		return ret;
	}
}
