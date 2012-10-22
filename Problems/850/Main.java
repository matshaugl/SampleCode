import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {
	public static void main(String[] args) throws IOException {

		//final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));
		String line;
		int n;
		ArrayList<String> lines;
		
		while ((line = in.readLine()) != null){
			n = Integer.parseInt(line);
			in.readLine();
			for(int i=0; i<n; i++){
				lines = new ArrayList<String>();
				while ((line = in.readLine()) != null){
					if(line.isEmpty()){
						break;
					}
					lines.add(line);
				}
				solve(lines);
			}
		}
	}

	private static void solve(ArrayList<String> lines) {
		String[] tokens;
		int [] lengder = {3,5,5,3,5,4,3,4,3};
		boolean key;
		String keyLine = null;
		char[] alpha = new char[26];
		
		for(int i=0; i<lines.size(); i++){
			key = true;
			tokens = lines.get(i).split(" ");
			if(tokens.length==9){
				for(int j=0; j<9; j++){
					if(tokens[j].length() != lengder[j]){
						key = false;
					}
				}
			}
			else {
				key = false;
			}
			if(key){
				if(lines.get(i).charAt(17) != lines.get(i).charAt(12) && 
						lines.get(i).charAt(17) != lines.get(i).charAt(26)&&
						lines.get(i).charAt(17) != lines.get(i).charAt(41)){
					key = false;
				}
				if(lines.get(i).charAt(5) != lines.get(i).charAt(21)){
					key = false;
				}
				if(lines.get(i).charAt(2) != lines.get(i).charAt(28) && 
						lines.get(i).charAt(2) != lines.get(i).charAt(32)){
					key = false;
				}
				if(lines.get(i).charAt(11) != lines.get(i).charAt(29)){
					key = false;
				}
				if(lines.get(i).charAt(0) != lines.get(i).charAt(31)){
					key = false;
				}
				if(lines.get(i).charAt(1) != lines.get(i).charAt(32)){
					key = false;
				}
			}
			if(key){
				keyLine = lines.get(i);
				break;
			}
		}
		HashMap<Character, Character> keymap = new HashMap<Character, Character>();
		if(keyLine!=null){
			keymap.put(keyLine.charAt(36), 'a' );
			keymap.put(keyLine.charAt(10), 'b' );
			keymap.put(keyLine.charAt(7), 'c' );
			keymap.put(keyLine.charAt(40), 'd' );
			keymap.put(keyLine.charAt(2), 'e' );
			keymap.put(keyLine.charAt(16), 'f' );
			keymap.put(keyLine.charAt(42), 'g' );
			keymap.put(keyLine.charAt(1), 'h' );
			keymap.put(keyLine.charAt(6), 'i' );
			keymap.put(keyLine.charAt(20), 'j' );
			keymap.put(keyLine.charAt(8), 'k' );
			keymap.put(keyLine.charAt(35), 'l' );
			keymap.put(keyLine.charAt(22), 'm' );
			keymap.put(keyLine.charAt(14), 'n' );
			keymap.put(keyLine.charAt(12), 'o' );
			keymap.put(keyLine.charAt(23), 'p' );
			keymap.put(keyLine.charAt(4), 'q' );
			keymap.put(keyLine.charAt(11), 'r' );
			keymap.put(keyLine.charAt(24), 's' );
			keymap.put(keyLine.charAt(0), 't' );
			keymap.put(keyLine.charAt(5), 'u' );
			keymap.put(keyLine.charAt(27), 'v' );
			keymap.put(keyLine.charAt(13), 'w' );
			keymap.put(keyLine.charAt(18), 'x' );
			keymap.put(keyLine.charAt(38), 'y' );
			keymap.put(keyLine.charAt(37), 'z' );
			

			//xnm ceuob lrtzv ita hegfd tsmr xnm ypwq ktj
			String alphaline = "the quick brown fox jumps over the lazy dog";
			for(int i=0; i<lines.size(); i++){
				for(int j=0; j<lines.get(i).length(); j++){
					char c = lines.get(i).charAt(j);
					if(!(c==' ')){
						System.out.print(keymap.get(c));
					}
					else{
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
		else{
			System.out.println("No solution.");
			System.out.println();
		}
	}
}
