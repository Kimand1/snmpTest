package text;

public class Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3,4,5,6,7};
		System.out.println(solution(num));		
	}
	static int solution(int[] num) {
		
		int sum=0;
		for(int i=0;i<10;i++) {
			boolean chk = true;
			for(int s:num) {
				if(i==s) {
					chk = false;
				}
			}
			if(chk) {
				sum += i;
			}
		}
		
		return sum;
	}

}
