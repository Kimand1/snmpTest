package text;

public class TClos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		System.out.println(solution(n,lost,reserve));
	}

	static public int solution(int n, int[] lost, int[] reserve) {
        int[] man = new int[n];
        for(int a=0;a<n;a++) {
        	man[a]=1;
        }
        for(int a:lost) {
        	man[a-1] = 0;        	
        }
        for(int a:reserve) {
        	man[a-1] += 1; 
        }
        int index=0;
        for(int a:man) {
        	//System.out.println(a);
        	if(a==0) {
        		if(index>0) {
        			if(man[index-1]>1) {
        				man[index-1] -= 1;
        				man[index] +=1;
        			}else if(index<n-1) {
        				if(man[index+1]>1) {
        					man[index] += 1;
        					man[index+1] -= 1;
        				}        				
        			}
        		}else {
        			if(index<n-1) {
        				if(man[index+1]>1) {
        					man[index] += 1;
        					man[index+1] -= 1;
        				}        				
        			}
        		}
        	}
        	index++;
        }
        int answer = 0;
		for(int a:man) {
			if(a>0) {
				answer++;
			}
		}		        
        return answer;
    }
}
