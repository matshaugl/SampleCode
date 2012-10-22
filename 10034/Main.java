import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
//prim/minspan

public class Main {
	public static void main(String args[]) throws Exception {
		//final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedReader in = new BufferedReader(new FileReader("sampleinput"));
		String line;
		String[] tokens;
		line = in.readLine();
		int c=Integer.parseInt(line);
		for (int i=0;i<c;i++) {
			in.readLine();
			int n=parseInt(in.readLine());
			double a[][]=new double[n][];
			for(int j=0;j<n;j++){
				line = in.readLine();
				tokens = line.split(" ");
				double[] dLine = new double[tokens.length];
				for(int k=0; k<tokens.length; k++){
					dLine[k] = parseDouble(tokens[k]);
				}
				a[j]=dLine;
			}
			double[][] d=new double[n][n];
			for(int j=0;j<n;j++){
				for(int k=j+1;k<n;k++){
					d[j][k]=d[k][j]=sqrt((a[j][0]-a[k][0])*(a[j][0]-a[k][0])+(a[j][1]-a[k][1])*(a[j][1]-a[k][1]));
				}
			}
			//Local.Us ellers kan det bli tull med double comma (, .)
		
			System.out.printf(Locale.US,"%.2f\n",prim(d));
			if(i<c-1){
				System.out.println();
			}
			
		}
	}

	static double prim(double d[][]){
		PriorityQueue<double[]> cola = new PriorityQueue<double[]>(d.length, new C());
		boolean visited[]=new boolean[d.length];
		double mem[]=new double[d.length];
		double r=0;
		for(int i=0; i<mem.length; i++){
			mem[i] = POSITIVE_INFINITY;
		}
		mem[0]=0;
		cola.add(new double[]{0,0});
		while(!cola.isEmpty()){
			int v=(int)cola.poll()[0];
			visited[v]=true;
			for(int i=0;i<d.length;i++){
				if(!visited[i]&&mem[i]>d[v][i])cola.add(new double[]{i,mem[i]=d[v][i]});
			}
		}
		
		for(int i=0;i<d.length;i++){
			r+=mem[i];
		}
		return r;
	}
	static class C implements Comparator<double[]>{
		public int compare(double[] d1, double[] d2) {
			if(d1[1]!=d2[1]){
				if(d1[1]<d2[1]){
					return -1;
				}
				return 1;
			}
			if(d1[0]<d2[0]){
				return -1;
			}
			return 1;
		}
	}
}
