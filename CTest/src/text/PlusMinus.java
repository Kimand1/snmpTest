package text;

public class PlusMinus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(8, 12));		
	}

	static long solution(int w, int h) {
	
		long answer=0;
		int min = (w<h) ? w:h;
		long gcd = 0;
		for(int i=1;i<=min;i++) {
			if(w%i==0 && h%i==0) {
				gcd = i;
			}
		}
		answer = (long)w*h-(w+h-gcd);
		return answer;
	}
}
