package text;

import java.util.ArrayList;
import java.util.HashSet;

public class Photo {

	static ArrayList<String[]> lists2 = new ArrayList();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sol ={"N~F>5", "C~J<1"};  
		System.out.println(solution(2,sol));
	}
	
	static public int solution(int n, String[] data) {    	
    	String[] t = {"A", "C", "F", "J", "M", "N", "R", "T"};
    	ArrayList<String[]> lists = pu(t);
    	HashSet<Integer> ilists = new HashSet<Integer>();
    	for(int chk=0;chk<n;chk++) {
    		String dt = data[chk];
    		String f = dt.substring(0,1);
    		String e = dt.substring(2,3);
    		String m = dt.substring(3,4);
    		String cc = dt.substring(4,5);
    		int c = Integer.parseInt(cc);
    		int ctype = 0;
    		if(m.equals("=")) {
				ctype=1;
			}else if(m.equals("<")) {
				ctype=2;
			}else if(m.equals(">")) {
				ctype=3;
			}
    		
    		for(String[] ss : lists) {
    			int fi = 0;
    			int ei = 0;
    			int si = 0;
    			for(String s : ss) {
    				if(f.equals(s)) {
    					fi = si;
    				}
    				if(e.equals(s)) {
    					ei = si;
    				}
    				si++;
    			}
    			
    			if(ctype==1) {
    				if(Math.abs(fi-ei)!=c+1) {
    					ilists.add(lists.indexOf(ss));
    				}
    			}else if(ctype==2) {
    				if(Math.abs(fi-ei)>=c+1) {
    					ilists.add(lists.indexOf(ss));
    				}
    			}else if(ctype==3) {
    				if(Math.abs(fi-ei)<=c+1) {
    					ilists.add(lists.indexOf(ss));
    				}
    			}
    		}
    		
    	}
    	int answer=lists.size()-ilists.size();
        return answer;
    }
	
	static public ArrayList<String[]> pu(String[] t){
		int length = t.length;
		String[] output = new String[length];
		boolean[] isVisit = new boolean[length];
		for(int cnt=1; cnt<=length; cnt++) {
			st(t, output, isVisit, 0, length, cnt);						
		}			
		ArrayList<String[]> lists = lists2; 
		lists2 = null;
		return lists;
	}
	static public void st(String[] t, String[] output, boolean[] isVisit, int depth, int length, int count) {		
		if(count==0) {
			//System.out.println(Arrays.toString(Arrays.stream(output).filter(i -> !"".equals(i)).toArray()));
			if(output[length-1]!=null) {
				String[] temp = new String[length];
				for(int i=0;i<length;i++) {
					temp[i] = output[i];
				}				
				lists2.add(temp);
				return;
			}
		}else {
			for(int i=0; i<length; i++) {
				if(isVisit[i]!=true) {
					isVisit[i] = true;
					output[depth] = t[i];
					st(t, output, isVisit, depth+1, length, count-1);
					isVisit[i] = false;
				}
			}
		}
	}
}	
