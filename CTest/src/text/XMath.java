package text;

public class XMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answers = {1,3,2,4,2,1,3,2,4,2,1,3,2,4,2,1,3,2,4,2,1,3,2,4,2,1,3,2,4,2,1,3,2,4,2,1,3,2,4,2,1,3,2,4,2,1,3,2,4,2,1,3,2,4,2,1,3,2,4,2,1,3,2,4,2};
		int[] sol = solution(answers);
		for(int a : sol) {
			System.out.println(a);
		}
	}

	static public int[] solution(int[] answers) {
        int a = 0;
        int b = 0;
        int c = 0;
        int[] bb = {2,1,2,3,2,4,2,5};
        int[] cc = {3,3,1,1,2,2,4,4,5,5};
		for(int i=0;i<answers.length;i++) {
			int aw = (i+1)%5;
			if(aw==0) {
				aw=5;
			}		
			//System.out.println(i+" "+aw);
			if(answers[i]==aw) {
				a++;
			}
			int bw = 0;
			int tempb = i%8;
			bw = bb[tempb];
			if(answers[i]==bw) {
				b++;
			}
			//System.out.println(i+" "+bw);
			int cw = 0;
			int tempc = i%10;
			cw = cc[tempc];
			if(answers[i]==cw) {
				c++;
			}
			//System.out.println(i+" "+cw);
		}
		if(a>b&&a>c) {
			int[] answer = {1};
	        return answer;
		}else if(b>a&&b>c){
			int[] answer = {2};
	        return answer;
		}else if(c>a&&c>b){
			int[] answer = {3};
	        return answer;
		}else if(a==b&&a>c) {
			int[] answer = {1,2};
	        return answer;
		}else if(a==c&&a>b) {
			int[] answer = {1,3};
	        return answer;
		}else if(b==c&&b>a) {
			int[] answer = {2,3};
	        return answer;
		}else{
			int[] answer = {1,2,3};
	        return answer;
		}
    }
}

