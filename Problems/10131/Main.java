import java.util.*;
import java.io.*;
public class Main {

	
	public static void main(String[] args) throws Exception {
		
		ArrayList<Elefant> elefanter = new ArrayList<Elefant>();
		//final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));
		String line = null;
		int id = 1;


		while ((line = in.readLine()) != null) {
			String[] split = line.split(" ");
			Elefant e = new Elefant(id, Integer.parseInt(split[0]), Integer.parseInt(split[1]));
			elefanter.add(e);
			id++;
		}
		
		Collections.sort(elefanter);
		for (int i=0; i<elefanter.size(); i++){
			Elefant e = elefanter.get(i);
			System.out.println(e.id + " " + e.vekt + " " + e.iq);
		}

		// lds = Longest Decreasing Subsequence (kan bruke Increasing om du sortera andre veien)
		int[] lds = new int[elefanter.size()];
		int[] printid = new int[elefanter.size()];
		
		for (int i=0; i<elefanter.size(); i++) {
			printid[i] = -1;
			lds[i] = 1;
		}
		
		for (int i=1; i<elefanter.size(); i++) {
			Elefant current = elefanter.get(i);
			int max = 0, index = -1;
			for (int j=0; j<i; j++) {
				Elefant e = elefanter.get(j);
				if ((e.iq > current.iq) && (e.vekt < current.vekt) && (lds[j] > max)) {
					max = lds[j];
					index = j;
				}
			}
			
			lds[i] = max + 1;
			printid[i] = index;
		}
		
		int max = 0, index = -1;
		for (int i=0;i<elefanter.size(); i++) {
			if (lds[i] > max) {
				max = lds[i];
				index = i;
			}
		}
		
		// output data
		System.out.println(max);
		
		ArrayList<Integer> ider = new ArrayList<Integer>();
		
		while (index != -1) {
			ider.add(elefanter.get(index).id);
			index = printid[index];
		} 
		
		for (int i=ider.size() - 1; i>=0; i--) {
			System.out.println(ider.get(i));
		}
	}
	
	static int incSub(int[]seq){
		int[]L=new int[seq.length];
		L[0]=1;
		for(int i=1;i<L.length;i++){
			int maxn=0;
			for(int j=0;j<i;j++){
				if(seq[j]<seq[i]&&L[j]>maxn){
					maxn=L[j];
				}
			}
			L[i]=maxn+1;
		}
		int maxi=0;
		for(int i=0;i<L.length;i++){
			if(L[i]>maxi){
				maxi=L[i];
				//System.out.println(i);
			}
		}
		return(maxi);
	}
	
}



class Elefant implements Comparable<Elefant>{
	int id;
	int vekt;
	int iq;

	public Elefant(int id, int vekt, int iq) {
		this.id = id;
		this.vekt = vekt;
		this.iq = iq;
	}

	public int compareTo(Elefant e) {
		if (this.vekt == e.vekt){
			if (this.iq == e.iq)
				return 0;
			if(this.iq<e.iq)
				return 1;
			else 
				return-1;
		}
		if(this.vekt>e.vekt)
			return 1;
		else 
			return-1;
	}
}