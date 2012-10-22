import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("sampleinput"));
		String s1;
		String s2;
		char[] a1;
		char[] a2;

		while (sc.hasNextLine()) {
			s1 = sc.nextLine();
			s2 = sc.nextLine();

			a1 = s1.toCharArray();
			a2 = s2.toCharArray();

			Arrays.sort(a1);
			Arrays.sort(a2);

			int i = 0;
			int j = 0;
			StringBuilder sb = new StringBuilder();
			while (i < a1.length && j < a2.length) {
				if (a1[i] < a2[j]) {
					i++;
				} else if (a1[i] > a2[j]) {
					j++;
				} else {
					sb.append(a1[i]);
					i++;
					j++;
				}
			}
			System.out.println(sb);
		}
	}
}