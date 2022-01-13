package text;

import java.util.ArrayList;
import java.util.HashSet;

public class Photo2 {

	static HashSet<String> lists2 = new HashSet();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sol ={"N~F=0", "R~T>2"};  
		System.out.println(solution(2,sol));
	}
	
	static public int solution(int n, String[] data) {    	
    	String t = "ACFJMNRT";
    	pu("", t, data);
    	int answer=lists2.size();
        return answer;
    }
	
	static public void pu(String t, String s, String[] data){
		int length = s.length();
		if(length==0) {
			int pp = 0;
			for(int chk=0;chk<data.length;chk++) {
	    		String dt = data[chk];
	    		String f = dt.substring(0,1);
	    		String e = dt.substring(2,3);
	    		String m = dt.substring(3,4);
	    		String cc = dt.substring(4,5);
	    		int c = Integer.parseInt(cc);
	    		int fi = t.indexOf(f);
    			int ei = t.indexOf(e);
    			int ctype = 0;
        		if(m.equals("=")) {
    				ctype=1;
    			}else if(m.equals("<")) {
    				ctype=2;
    			}else if(m.equals(">")) {
    				ctype=3;
    			}    
    			if(ctype==1) {
    				if(Math.abs(fi-ei)!=c+1) {
    					pp++;
    					break;
    				}
    			}else if(ctype==2) {
    				if(Math.abs(fi-ei)>=c+1) {
    					pp++;
    					break;
    				}
    			}else if(ctype==3) {
    				if(Math.abs(fi-ei)<=c+1) {
    					pp++;
    					break;
    				}
    			}
			}
			if(pp==0) {
				lists2.add(t);
			}
		}else {
			for(int i=0;i<length;i++) {
				pu(t+s.charAt(i),s.substring(0,i)+s.substring(i+1), data);
			}
		}		
	}
}	
