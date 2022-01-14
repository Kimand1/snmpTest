package text;

import java.util.ArrayList;
import java.util.HashSet;

public class Decimal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,7,6,4};
		System.out.println(solution(nums));		
	}
	static HashSet<int[]> ilists = new HashSet<int[]>();
	
	static public int solution(int[] nums) {
        int answer = -1;

        int length = nums.length;
        int[] output = new int[length];
        boolean[] isVisit = new boolean[length];
        
        combination(output, nums, 0, 0, 0, 3, nums.length);
        ArrayList<Integer> lists = new ArrayList<Integer>();
        for(int[] a:ilists) {
        	int sum = 0;
        	System.out.println("-------------------------------------------------------");
        	for(int i=0;i<3;i++) {
        		sum += a[i];
        		System.out.print(a[i]);
        	}
        	System.out.println();
        	int cnt = 0;
        	for(int i=sum-1;i>1;i--) {        		
        		if(sum%i==0) {
        			cnt++;
        		}
        	}
        	if(cnt==0) {
        		System.out.println(sum);
        		lists.add(sum);        		
        	}       
        }

        answer = lists.size();
        return answer;
    }
	
	
	public static void combination(int[] now, int[] arr, int depth, int index, int target, int r, int n) { 
		if (depth == r) { 
			int[] temp  = new int[now.length];
			for (int i = 0; i < now.length; i++) {
				temp[i] = arr[now[i]]; 
				System.out.print(temp[i]);
			} 
			System.out.println();
			ilists.add(temp); 
			return; 
		} 
		
		if (target == n) 
			return; 
		
		now[index] = target; 
		combination(now, arr, depth + 1, index + 1, target + 1, r, n); 
		combination(now, arr, depth, index, target + 1, r, n); 
	}
	
}
