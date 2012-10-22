import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));

		String line;
		String[] tokens;
		int n;
		int e;

		while ((line = in.readLine()) != null) {
			n = Integer.parseInt(line);
			if (Integer.parseInt(line) == 0) {
				break;
			}
			line = in.readLine();
			e = Integer.parseInt(line);
			Node[] node = new Node[n];
			for (int i = 0; i < n; i++) {
				node[i] = new Node();
			}
			for (int i = 0; i < e; i++) {
				line = in.readLine();
				tokens = line.split(" ");
				node[Integer.parseInt(tokens[0])].nabo.add(Integer.parseInt(tokens[1]));
				node[Integer.parseInt(tokens[1])].nabo.add(Integer.parseInt(tokens[0]));
			}

			node[0].color = 1;
			boolean bipartite = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < node[i].nabo.size(); j++) {
					if (node[i].color == 1 && !(node[i].color == 0)) {
						if (node[j].color == 0) {
							node[j].color = 2;
						}
						if (node[j].color == 1) {
							bipartite = false;
							break;
						}
					} else if (node[i].color == 2) {
						if (node[j].color == 0) {
							node[j].color = 1;
						}
						if (node[j].color == 2) {
							bipartite = false;
							break;
						}
					}
				}
			}
			if (bipartite) {
				System.out.println("BICOLORABLE.");
			} else {
				System.out.println("NOT BICOLORABLE.");
			}
		}
	}
}

class Node {
	ArrayList<Integer> nabo = new ArrayList<Integer>();
	int color = 0;
}