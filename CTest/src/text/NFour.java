package text;

import java.util.ArrayList;

public class NFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int number = 12;
		System.out.println(solution(N,number));
	}

	static int temp=0; //임시 저장 값
	static ArrayList<Integer> count = new ArrayList<Integer>();//해당 숫자 사용 갯수
	static public int solution(int N, int number) {
		int[] pl = {0,1,2,3,4};
		chk(N,0,number,0,8,1,0,8);
		for(int c : count) {
			System.out.println(c);
		}
		int answer = 0;
        return answer;
    }
	
	static void chk(int N, int sum, int number, int pls, int plcnt, int plplus, int cnt, int mxcnt) {		
		System.out.println(N+" "+sum+" "+number+" "+pls+" "+plcnt+" "+cnt+" "+mxcnt);
		if(pls==5) {
			return;
		}
		if(cnt==mxcnt) {
			return;
		}
		int pl = pls;
		if(cnt>=plcnt) {
			pl = pl+plplus;
			if(pl>4) {
				pl = 0;
			}
		}
		if(plcnt==0) {
			if(plplus==4) {
				plplus = 1;
				plcnt = mxcnt;
				cnt=0;
				sum=0;
				pls++;
			}else {
				plplus++;
			}			
		}		
		switch(pl) {
			case 0: 
				sum = N*10+N;
				break;
			case 1:
				sum += N;
				break;
			case 2:
				sum -= N;
				break;
			case 3:
				sum = sum*N;
				break;
			case 4:
				sum = sum/N;
				break;
		}
		//System.out.println(sum+" " +cnt);
		if(sum==number) {
			count.add(cnt);
		}		
		chk(N,sum,number,pls,plcnt-1,plplus,cnt+1,mxcnt);
		
	}
}
