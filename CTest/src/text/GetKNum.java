package text;

import java.util.PriorityQueue;

public class GetKNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4,4,1}, {1,7,3}};
		int[] sol = solution(array, commands);
		for(int a : sol) {
			System.out.println(a);
		}
	}
	
	static public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int index=0;
        for(int[] nums:commands) {
        	PriorityQueue<Integer> lists = new PriorityQueue<>();
        	for(int i=nums[0]-1;i<nums[1];i++) {
        		//System.out.println(i+" "+array[i]);
        		lists.offer(array[i]);
        	}
        	//System.out.println(lists.peek());
        	for(int i=0;i<nums[2];i++) {
        		answer[index] = lists.peek();
        		lists.remove(answer[index]);
        	}
        	index++;
        }
        
        return answer;
    }

}
