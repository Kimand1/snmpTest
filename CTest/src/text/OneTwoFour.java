package text;

import java.util.ArrayList;
import java.util.Collections;

public class OneTwoFour {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums =16;
		System.out.println(solution(nums));		
	}
	static ArrayList<String> lists = new ArrayList<String>();
	
	static public String solution(int n) {
        String answer = "";
        String t = "";
        for(int i=0;i<n;i++) {
        	if("".equals(t)) {
        		t = "1";
        	}else if("1".equals(t)) {
        		t = "2";        		
        	}else if("2".equals(t)) {
        		t = "4";
        	}else if("4".equals(t)) {
        		t = "1";
        		addTen(0);
        	}
        }
        Collections.reverse(lists);
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(String s:lists) {
        	sb.insert(i++, s);
        	//answer += s;
        }
        answer = sb.toString();
        answer += t;
        return answer;
    }
	
	static void addTen(int i) {
		if(lists.size()>i) {
			String a = lists.get(i);
			if("1".equals(a)) {
	    		a = "2";
	    		lists.set(i, a);
	    		return;
	    	}else if("2".equals(a)) {
	    		a = "4";
	    		lists.set(i, a);
	    		return;
	    	}else if("4".equals(a)) {
	    		a = "1";
	    		lists.set(i, a);
	    		System.out.println("vv "+a+" "+i);
	    		addTen(i+1);
	    		return;
	    	}
		}else {
			lists.add("1");
		}

		return;
	
	}
}
