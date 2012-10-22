import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Bruk long/cent
public class Main {
	public static void main(String[] args) throws Exception {
		// final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));

		String line;
		int n;
		int[] expenses = null;

		while ((line = in.readLine()) != null) {
			n = Integer.parseInt(line);
			if (n == 0) {
				break;
			}
			expenses = new int[n];
			for (int i = 0; i < n; i++) {
				line = in.readLine();
				float value = Float.parseFloat(line) * 100;
				expenses[i] = Math.round(value);
			}

			long amount = amountExchanged(expenses);
			System.out.print("$" + amount / 100 + ".");
			if (amount % 100 < 10)
				System.out.print("0");
			System.out.println(amount % 100);
		}
	}

	public static long amountExchanged(int[] expenses) {
		long amountExchangd = 0;
		int n = expenses.length;

		long snitt = 0;
		long totalExpenses = 0;
		for (double expense : expenses)
			totalExpenses += expense;

		snitt = Math.round((double)totalExpenses / n);
		long tr = 0;
		long tg = 0;
		for (int i = 0; i < n; i++) {
			long diff = expenses[i] - snitt;
			if (diff > 0)
				tr = tr + diff;
			else
				tg = tg - diff;
		}
		if (tr < tg) {
			amountExchangd = tr;
		} else {
			amountExchangd = tg;
		}
		return amountExchangd;
	}
}