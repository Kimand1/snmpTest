package text;

public class StringEng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "2three45sixseven";
		System.out.println(sol(s));
	}
	
	public static int sol(String s) {
		String[][] numToString = new String[10][2];
		numToString[0][0] = "zero";
		numToString[1][0] = "one";
		numToString[2][0] = "two";
		numToString[3][0] = "three";
		numToString[4][0] = "four";
		numToString[5][0] = "five";
		numToString[6][0] = "six";
		numToString[7][0] = "seven";
		numToString[8][0] = "eight";
		numToString[9][0] = "nine";
		numToString[0][1] = "0";
		numToString[1][1] = "1";
		numToString[2][1] = "2";
		numToString[3][1] = "3";
		numToString[4][1] = "4";
		numToString[5][1] = "5";
		numToString[6][1] = "6";
		numToString[7][1] = "7";
		numToString[8][1] = "8";
		numToString[9][1] = "9";
		for(String[] nSA : numToString) {			
			s = s.replaceAll(nSA[0], nSA[1]);
		}
		int answer = 0;
		try {
			answer = Integer.parseInt(s);
		} catch (Exception e) {
		}
        return answer;
	}
}
