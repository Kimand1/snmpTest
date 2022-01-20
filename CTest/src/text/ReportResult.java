package text;

import java.util.Vector;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class ReportResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		int k = 2;
		int[] result = solution(id_list, report, k);
		for(int i:result) {
			System.out.println(i);
		}
	}
	
	static public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		TreeSet<String> repo = new TreeSet<String>(Arrays.asList(report));
		HashMap<String, Integer> reported = new HashMap();		
		Vector<String> abuse = new Vector<String>();		
		HashMap<String, Integer> abusing = new HashMap();
		for(String id:id_list) {
			reported.put(id, 0);
			abusing.put(id, 0);
		}
		for(String st : repo) {
			String[] rk = st.split(" ");
			if(reported.get(rk[1])<k-1){
				//abuse.add(st);
				abuse.add(rk[1] + " " + rk[0]);
			}else if(reported.get(rk[1])==k-1){
				int i=0;
				int ii=0;
				Collections.sort(abuse);
				while(i<k-1) {
					for(int kk=ii;kk<abuse.size();kk++) {
						String[] rks = abuse.get(kk).split(" ");
						if(rk[1].equals(rks[0])) {
							int tint = abusing.get(rks[1])+1;
							abusing.put((rks[1]), tint);							
							i++;
							abuse.remove(kk);
							break;
						}
						ii++;
					}				
				}
				int tint = abusing.get(rk[0])+1;
				abusing.put(rk[0], tint);
			}else {
				int tint = abusing.get(rk[0])+1;
				abusing.put(rk[0], tint);
			}
			int tint = reported.get(rk[1])+1;
			reported.put(rk[1],tint);
		}
        for(int i=0;i<answer.length;i++) {
        	answer[i] = abusing.get(id_list[i]);
        }
        return answer;
    }

}
