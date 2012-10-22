import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

class Main{

	public static void main(String[] args) throws Exception {
		int[][] s = new int [10][100];
		int k,n;
		
		for(int i=0; i<10; i++){
			for(int j=0; j<100; j++){
				s[i][j] = 0;
			}
		}
		//Tabell med alle løsninger, men ikkje løsning=0
		s[1][0]=1;
		s[1][1]=1;
		s[2][0]=1;
		s[2][1]=4;
		s[2][2]=4;
		s[3][0]=1;
		s[3][1]=9;
		s[3][2]=26;
		s[3][3]=26;
		s[3][4]=8;
		s[4][0]=1;
		s[4][1]=16;
		s[4][2]=92;
		s[4][3]=232;
		s[4][4]=260;
		s[4][5]=112;
		s[4][6]=16;
		s[5][0]=1;
		s[5][1]=25;
		s[5][2]=240;
		s[5][3]=1124;
		s[5][4]=2728;
		s[5][5]=3368;
		s[5][6]=1960;
		s[5][7]=440;
		s[5][8]=32;
		s[6][0]=1;
		s[6][1]=36;
		s[6][2]=520;
		s[6][3]=3896;
		s[6][4]=16428;
		s[6][5]=39680;
		s[6][6]=53744;
		s[6][7]=38368;
		s[6][8]=12944;
		s[6][9]=1600;
		s[6][10]=64;
		s[7][0]=1;
		s[7][1]=49;
		s[7][2]=994;
		s[7][3]=10894;
		s[7][4]=70792;
		s[7][5]=282248;
		s[7][6]=692320;
		s[7][7]=1022320;
		s[7][8]=867328;
		s[7][9]=389312;
		s[7][10]=81184;
		s[7][11]=5792;
		s[7][12]=128;
		s[8][0]=1;
		s[8][1]=64;
		s[8][2]=1736;
		s[8][3]=26192;
		s[8][4]=242856;
		s[8][5]=1444928;
		s[8][6]=5599888;
		s[8][7]=14082528;
		s[8][8]=22522960;
		s[8][9]=22057472;
		s[8][10]=12448832;
		s[8][11]=3672448;
		s[8][12]=489536;
		s[8][13]=20224;
		s[8][14]=256;

		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader in = new BufferedReader(new FileReader(new File("sampleinput")));
		String line = "";
		String[] tokens;

		while(true){
			line = in.readLine();
			tokens = line.split(" ");
			n = Integer.parseInt(tokens[0]);
			k = Integer.parseInt(tokens[1]);
			if(k == 0 && n == 0){
				break;
			}
			System.out.println(s[n][k]);
		}
	}
}