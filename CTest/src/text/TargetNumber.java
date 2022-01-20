package text;

public class TargetNumber {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 3;
		int[] number = {1,2,3,4,5};
		System.out.println(solution(number, N));
	}
	
	static public int solution(int[] numbers, int target) {
		int answer = 0;
		int min = 0;
		int leng = numbers.length-1;
		int lengf = numbers.length;		
		for(int i=0;i<numbers.length*numbers.length;i++) {
			int result = 0;
			int z = i%numbers.length;
			int cnt = 0;
			
			for(int a:numbers) {
				if(z>=cnt && cnt>=min) {
					result += a;
					System.out.print("+"+a);
				}else {
					System.out.print("-"+a);
					result -= a;
				}				
				cnt++;
			}
			if(result == target) {
				answer++;
				System.out.print(" << ");
			}			
			System.out.println("  "+i+" "+min+" "+z);
			if(leng==0) {
				min++;
				leng = --lengf;
			}
			leng--;
			//min = (i+1)/(numbers.length-(i+1)/numbers.length)-1;
		}        
        return answer;
    }
}
