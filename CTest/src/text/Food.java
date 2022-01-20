package text;

import java.util.PriorityQueue;

public class Food {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}

	static public int solution(int[] scoville, int K) {
        int answer = 0;
        
        //Arrays.sort(scoville);
        //ArrayList<Integer> lists = new ArrayList<Integer>();
        PriorityQueue<Integer> lists = new PriorityQueue<>();
        
        for(int a : scoville) {
        	lists.add(a);
        }
        
        boolean loop = true;
        while(loop) {
        	//Collections.sort(lists);
        	int scov = lists.peek(); 
        	if(scov>=K) {
        		break;
        	}
        	lists.remove(scov);
        	if(lists.isEmpty()) {
        		return -1;
        	}
        	int scov2 = lists.peek();
        	lists.remove(scov2);
        	answer++;
        	lists.add(scov+(scov2*2));	        
        	//System.out.println(scov+" "+scov2+" "+(scov+(scov2*2)));
        }
        
        return answer;
    }
}
/*
 * int answer = 0;
        
        //Arrays.sort(scoville);
        ArrayList<Integer> lists = new ArrayList<Integer>();
        
        for(int a : scoville) {
        	lists.add(a);
        }
        
        boolean loop = true;
        while(loop) {
        	Collections.sort(lists);
        	if(lists.get(0)>=K) {
        		break;
        	}
	        for(int i=0;i<lists.size();i++) {
	        	int scov = lists.get(i);
	        	if(scov<K) {
	        		if(i+1<lists.size()) {
	        			lists.set(i, lists.get(i)+(lists.get(i+1)*2));
	        			lists.remove(i+1);
	        			answer++;
	        			break;
	        		}else {
	        			return -1;
	        		}
	        	}else {
	        		break;
	        	}
	        }
        }
        
        if(lists.get(0)<K) {
        	return -1;
        }
        
        return answer;
 */
