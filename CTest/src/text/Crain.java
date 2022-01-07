package text;

import java.util.ArrayList;
import java.util.Collections;

public class Crain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] num = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] mov = {1,5,3,5,1,2,1,4};
		System.out.println(solution(num,mov));
	}
	
	public static int solution(int[][] board, int[] moves) {
		ArrayList<Integer> basket = new ArrayList<Integer>();
		int before = 0;
		int answer = 0;
		for(int m : moves) {
			for(int i=0;i<board.length;i++) {
				if(board[i][m-1]>0) {
					if(before == board[i][m-1]) {
						basket.remove(basket.size()-1);
						answer += 2;
						try {
							before = basket.get(basket.size()-1);
						}catch (Exception e) {
							before = 0;
						}
					}else {
						basket.add(board[i][m-1]);							
						before = board[i][m-1];						
					}
					board[i][m-1] = 0;		
					break;
				}
			}
		}		
        
        return answer;
    }
}
