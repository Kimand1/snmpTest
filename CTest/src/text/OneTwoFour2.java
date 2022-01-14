package text;

public class OneTwoFour2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums =17;
		System.out.println(solution(nums));	
	}
	static public String solution(int n) {
        String answer = "";

        int na = 0;

        StringBuilder sb = new StringBuilder();
        int index=0;
        while(n != 0){

            na = n%3; 
             n = n/3; 

            if(na==0){
                n=n-1;
                na = 4;
            }
            sb.insert(index++, na);

        }
        answer = sb.reverse().toString();
        return answer;
    }
}
