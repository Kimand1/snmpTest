package text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String[] record = {
			"Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo",
			"Change uid4567 Ryan",
			"Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo","Enter uid1234 Muzi", 
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Change uid4567 Michin",
			"Enter uid1234 Prodo",
		};
		
		String[] result = solution2(record);
		/*for(String sr:result) {
			System.out.println(sr);
		}*/
		String[] lines = {
				//"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"
				"2016-09-15 00:00:00.000 3s"
		};
		System.out.println(sol(lines));
		
	}	
	
	public static int sol(String[] lines) {
		Date d1 = null;
		int answer = 0;
		for(String sb:lines) {
			int tempCnt = 0;
			int tempCnt2 = 0;
			String[] sbs = sb.split(" ");
			String times = sbs[0]+" "+sbs[1];
			String mils = sbs[2];
			mils = mils.replace("s", "");
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.KOREA);
			try {
				int milss = -(int)(Float.parseFloat(mils)*1000);				
				Date d = f.parse(times);
				Calendar cal = Calendar.getInstance();
		        cal.setTime(d);
		        cal.add(Calendar.MILLISECOND, milss);
		        cal.add(Calendar.SECOND, -1);
				d1 = cal.getTime();
				cal.add(Calendar.MILLISECOND, 999);
				Date d2 = cal.getTime();
				
				cal.setTime(d);
				Date dd1 = cal.getTime();				
				cal.add(Calendar.MILLISECOND, 999);
				Date dd2 = cal.getTime();
				
				for(String sb2:lines) {
					String[] sbs2 = sb2.split(" ");
					String times2 = sbs2[0]+" "+sbs2[1];
					String mils2 = sbs2[2];
					mils2 = mils2.replace("s", "");
					int milss2 = -(int)(Float.parseFloat(mils2)*1000);				
					Date d3 = f.parse(times2);
					Calendar cal2 = Calendar.getInstance();
			        cal2.setTime(d3);
					cal2.add(Calendar.MILLISECOND, milss2);
					Date d4 = cal2.getTime();
					if(d4.before(d2) && (d1.before(d3) || d1.equals(d3))) {
						tempCnt++;
					}							
					
					if(d4.before(dd2) && (dd1.before(d3) || dd1.equals(d3))) {
						tempCnt2++;				
					}	
				}
				if(tempCnt>answer) {
					answer = tempCnt;					
				}	
				if(tempCnt2>answer) {
					answer = tempCnt2;
				}
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		return answer;
	}
	
	public static String[] solution2(String[] record) {
		HashMap<String, String> nick = new HashMap<String, String>();
		int cnt = record.length;
		for(int i=0;i<record.length;i++) {
			String[] sp = record[i].split(" ");
			if("Enter".equals(sp[0])){
				nick.put(sp[1], sp[2]);				
			}else if("Change".equals(sp[0])){
				nick.put(sp[1], sp[2]);
				cnt--;
			}
		}
		String[] answer = new String[cnt];
		cnt=0;
		for(int i=0;i<record.length;i++) {		
			String[] sp = record[i].split(" ");
			//Enter, Leave, Change
			if("Enter".equals(sp[0])) {
				String nn = nick.get(sp[1]);
				answer[cnt++] = nn+"님이 들어왔습니다.";
			}else if("Leave".equals(sp[0])) {
				String nn = nick.get(sp[1]);				
				answer[cnt++] = nn+"님이 나갔습니다.";
			}
		}
		
        return answer;
    }
	
	public static String[] solution(String[] record) {
		String[][] ids = new String[record.length][3];
		int cnt = record.length;
		for(int i=0;i<record.length;i++) {
			String[] sp = record[i].split(" ");
			ids[i][0] = sp[0];			
			ids[i][1] = sp[1];
			if("Leave".equals(sp[0])) {
				for(int index=0;index<i; index++){
					if(ids[i][1].equals(ids[index][1])) {
						ids[i][2] = ids[index][2];
						break;
					}		
				}
			}else if("Enter".equals(sp[0])){
				ids[i][2] = sp[2];
				for(int index=0;index<i; index++){// String[] st:ids) {
					if(ids[i][1].equals(ids[index][1])) {
						ids[index][2] = sp[2];
					}
				}
			}else {
				for(int index=0;index<i; index++){
					if(ids[i][1].equals(ids[index][1])) {
						ids[index][2] = sp[2];
					}
				}
				cnt--;
			}
		}
		record = null;
		String[] answer = new String[cnt];
		cnt=0;
		for(int i=0;i<ids.length;i++) {			
			//Enter, Leave, Change
			if("Enter".equals(ids[i][0])) {
				answer[cnt++] = ids[i][2]+"님이 들어왔습니다.";
			}else if("Leave".equals(ids[i][0])) { 
				answer[cnt++] = ids[i][2]+"님이 나갔습니다.";
			}
		}
		
        return answer;
    }
}
