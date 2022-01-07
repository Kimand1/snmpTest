package text;

public class KeyDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		System.out.println(solution(num,hand));
		System.out.println("LRLLRRLLLRR");
	}

	public static String solution(int[] numbers, String hand) {
		String answer = "";
		int lastLeft = 10;
		int lastRight = 12;		
		for(int n:numbers) {
			boolean chk = false;
			switch(n) {
			case 1: case 4: case 7:
				answer += "L";
				lastLeft = n;
				break;
			case 3: case 6: case 9:
				answer += "R";
				lastRight = n;
				break;
			default : 
				chk = true;
				break;
			}
			if(chk) {
				if(n==0) {
					n=11;
				}
				int l = Math.abs(lastLeft-n)%3+Math.abs(lastLeft-n)/3;
				int r = Math.abs(lastRight-n)%3+Math.abs(lastRight-n)/3;
				//System.out.println("전왼"+lastLeft+" 전오"+lastRight+" 현"+n);
				//System.out.println("L"+l+" R"+r);
				if(l<r) {
					answer += "L";
					lastLeft = n;
				}else if(l>r) {
					answer += "R";
					lastRight = n;
				}else {
					if("left".contentEquals(hand)) {
						answer += "L";
						lastLeft = n;
					}else {
						answer += "R";
						lastRight = n;
					}
				}
			}
			
		}
        
        return answer;
    }
}
