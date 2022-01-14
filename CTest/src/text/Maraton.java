package text;

import java.util.Arrays;

public class Maraton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = {"leo", "kiki", "eden"}; 
		String[] completion = {"eden", "kiki"};
		System.out.println(solution(participant, completion));
	}

	static public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.parallelSort(participant);
        Arrays.parallelSort(completion);
        int i=0;
        for(String s : participant) {        	
        	if(!s.equals(completion[i])) {
        		answer = s;
        		break;
        	}
        	i++;
        }
        return answer;
    }
}
