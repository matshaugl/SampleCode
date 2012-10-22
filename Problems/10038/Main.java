import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));

		String line;
		String[] tokens;
		int n;
		int[] a;
		boolean[] v;

		while ((line = in.readLine()) != null) {
			tokens = line.split(" ");
			n = Integer.parseInt(tokens[0]);
			a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(tokens[i + 1]);
			}
			v = new boolean[n];
			for (int i = 0; i < n - 1; i++) {
				int abs = Math.abs(a[i] - a[i + 1]);
				if (abs > 0 && abs < n)
					v[abs] = true;
			}
			boolean check = true;
			for (int i = 1; i < n && check; i++)
				if (!v[i])
					check = false;
			if (check) {
				System.out.println("Jolly");
			} else {
				System.out.println("Not jolly");
			}
		}
	}
}
