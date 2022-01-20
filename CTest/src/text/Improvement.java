package text;

import java.util.ArrayList;

public class Improvement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] progresses = {93, 30, 55}; 
		int[] speeds = {1,30,5};
		
		int[] result = solution(progresses, speeds);
		for(int i:result) {
			System.out.println(i);
		}
	}

	static public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> lists = new ArrayList<Integer>();
        int cnt=1;
        for(int i=0;i<progresses.length-1;i++) {
        	int days = (100-progresses[i])/speeds[i];
        	if((100-progresses[i])%speeds[i]>0) {
        		days++;        	
        	}
        	for(int ii=i+1;ii<progresses.length;ii++) {
	        	int dplus = (100-progresses[ii])/speeds[ii];
	        	if((100-progresses[ii])%speeds[ii]>0) {
	        		dplus++;
	        	}
	        	if(dplus<=days) {
	        		if(ii==progresses.length-1) {
	        			lists.add(cnt+1);
	        			break;
	        		}
	        		cnt++;
	        		i++;
	        	}else {
	        		if(ii==progresses.length-1) {
	        			lists.add(cnt);
	        			lists.add(1);
	        			break;
	        		}
	        		lists.add(cnt);
	        		cnt=1;	        		
	        		break;
	        	}
        	}        	 	
        }
        int i=0;        
        int[] answer = new int[lists.size()];
        for(int a:lists) {
        	answer[i++] = a;
        }
        return answer;
    }
}
