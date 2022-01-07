package text;

import java.util.ArrayList;
import java.util.List;

public class PictureArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] num = {{1,1,1,0},{1,2,2,0},{1,1,0,1},{0,1,0,1},{0,1,1,3},{0,0,1,3},{1,1,1,3},{1,1,0,3},{1,1,0,3}};
		int[] result = solution(9,4,num);
		System.out.println(result[0]+","+ result[1]);
	}

	public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        int[][] pic = new int[m][n];
        int[][] visit = new int[m][n];
        String[][] eq = new String[m][n];
        List<Position> lists = new ArrayList<Position>();
                
        for(int i=0;i<m;i++) {
        	for(int ii=0;ii<n;ii++) {
        		int now = picture[i][ii];
        		int top = 0;
        		int left = 0;
        		int right = 0;
        		int bottom = 0;
        		eq[i][ii] = "";
        		if(now>0) {
	        		if(i-1>=0) {top=picture[i-1][ii];}
	        		if(ii-1>=0) {left=picture[i][ii-1];}
	        		if(i+1<m) {bottom=picture[i+1][ii];}
	        		if(ii+1<n) {right=picture[i][ii+1];}	        		
	        		if(now==top) {
	        			eq[i][ii] += "t"; 
	        		}
	        		if(now==bottom) {
	        			eq[i][ii] += "b";
	        		}
	        		if(now==left) {
	        			eq[i][ii] += "l";
	        		}
	        		if(now==right) {
	        			eq[i][ii] += "r";
	        		}
        		}
        	}
        }
        for(int i=0;i<m;i++) {
        	for(int ii=0;ii<n;ii++) {
        		int now = picture[i][ii];
        		if(now>0) {
	        		if(visit[i][ii]==0) {
	        			numberOfArea++;
	        			if("".contentEquals(eq[i][ii])) {	        				
	        				visit[i][ii] = 1;
	        				pic[i][ii] = numberOfArea;
	        				continue;
	        			}
	        			
	        			if(eq[i][ii].indexOf("t")>-1) {
	        				Position p = new Position();
	        				p.setH(i-1);
	        				p.setW(ii);
	        				lists.add(p);
	        			}
	        			if(eq[i][ii].indexOf("b")>-1) {
	        				Position p = new Position();
	        				p.setH(i+1);
	        				p.setW(ii);
	        				lists.add(p);
	        			}
	        			if(eq[i][ii].indexOf("l")>-1) {
	        				Position p = new Position();
	        				p.setH(i);
	        				p.setW(ii-1);
	        				lists.add(p);
	        			}
	        			if(eq[i][ii].indexOf("r")>-1) {
	        				Position p = new Position();
	        				p.setH(i);
	        				p.setW(ii+1);
	        				lists.add(p);
	        			}
	        			while(lists.size()>0) {
	        				for(Position p2 : lists) {
	        					int a=p2.getH();
	        					int b=p2.getW();
	        					if(visit[a][b]==1) {
	        						lists.remove(lists.indexOf(p2));
	        						break;
	        					}
		        				String text = eq[a][b];
		        				pic[a][b] = numberOfArea;
		        				if(text.indexOf("t")>-1) {
			        				Position p = new Position();
			        				p.setH(a-1);
			        				p.setW(b);
			        				lists.add(p);
			        			}
			        			if(text.indexOf("b")>-1) {
			        				Position p = new Position();
			        				p.setH(a+1);
			        				p.setW(b);
			        				lists.add(p);
			        			}
			        			if(text.indexOf("l")>-1) {
			        				Position p = new Position();
			        				p.setH(a);
			        				p.setW(b-1);
			        				lists.add(p);
			        			}
			        			if(text.indexOf("r")>-1) {
			        				Position p = new Position();
			        				p.setH(a);
			        				p.setW(b+1);
			        				lists.add(p);
			        			}	
			        			visit[a][b] = 1;
			        			lists.remove(lists.indexOf(p2));
			        			break;
	        				}
	        			}
	        		}else{
	        			continue;
	        		}
        		}
        	}
        }
        
        for(int i=0;i<m;i++) {
        	for(int ii=0;ii<n;ii++) {
        		int now=pic[i][ii];
                int cntArea=0;
                if(now>0) {
	        		for(int[] a:pic) {
	        			for(int b:a) {
	        				if(b==now) {
	        					cntArea++;
	        				}
	        			}
	        		}
                }
        		if(cntArea>maxSizeOfOneArea) {
        			maxSizeOfOneArea = cntArea;
        		}        
        	}
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	
	public static class Position{
		int w;
		int h;
		public int getW() {
			return w;
		}
		public void setW(int w) {
			this.w = w;
		}
		public int getH() {
			return h;
		}
		public void setH(int h) {
			this.h = h;
		}
		
	}
}
