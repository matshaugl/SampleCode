import java.io.BufferedReader;
import java.io.FileReader;


public class Main {
	public static void main(String[] args) throws Exception {
		//final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));

		String line;
		int c,n,p,numbWorking;
		int parties[] = new int[101];
		
		line = in.readLine();

		while ((line = in.readLine()) != null) {
			n = Integer.parseInt(line);
			line = in.readLine();
			p = Integer.parseInt(line);
			for(int i=0; i<p; i++){
				line = in.readLine();
				parties[i] = Integer.parseInt(line);
			}
			numbWorking = 0;
			for(int i=1; i<=n; i++){
				if ((i%7)!=6 && (i%7)!=0) {
					for (int j=0 ; j<p ; j++) {
						if ((i%parties[j])==0) {
							numbWorking++;
							break;
						}
					}
				}
			}
			System.out.println(numbWorking);
		}
	}
}