package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B2745 {
	
	static int convertToDecimal (String givenNum, int arithmetic) {	
		HashMap<String, Integer> table = new HashMap<>();
		table.put("0", 0);table.put("1", 1);table.put("2", 2);table.put("3", 3);
		table.put("4", 4);table.put("5", 5);table.put("6", 6);table.put("7", 7);
		table.put("8", 8);table.put("9", 9);table.put("A", 10);table.put("B", 11);
		table.put("C", 12);table.put("D", 13);table.put("E", 14);table.put("F", 15);
		table.put("G", 16);table.put("H", 17);table.put("I", 18);table.put("J", 19);
		table.put("K", 20);table.put("L", 21);table.put("M", 22);table.put("N", 23);
		table.put("O", 24);table.put("P", 25);table.put("Q", 26);table.put("R", 27);
		table.put("S", 28);table.put("T", 29);table.put("U", 30);table.put("V", 31);
		table.put("W", 32);table.put("X", 33);table.put("Y", 34);table.put("Z", 35);
		
		int decimalNum = 0;
		String[] numChar = givenNum.split("");
		for (int i = 0; i < numChar.length; i++) {
			int powerOfN = numChar.length - 1 - i;
			decimalNum += (Math.pow(arithmetic, powerOfN)) * table.get(numChar[i]);;
		}
		
		return decimalNum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String givenNum = st.nextToken();
		int arithmetic = Integer.parseInt(st.nextToken());
		int answer = convertToDecimal(givenNum, arithmetic);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(answer));
		bw.flush();
		br.close();
		bw.close();
	}
}
