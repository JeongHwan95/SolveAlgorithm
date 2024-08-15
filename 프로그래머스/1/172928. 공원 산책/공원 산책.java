import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] park, String[] routes) {
		
		int x = -1;
		int y = -1;
		
		for(int i=0; i<park.length; i++) {
			
			if(park[i].contains("S")) {
				x = park[i].indexOf('S');
				y = i;
				break;
			}
		}
		
//		System.out.println(x+", "+y);
		
		for(String route : routes) {
			
			String direction = route.split(" ")[0];
			int weight = Integer.parseInt(route.split(" ")[1]);
			
			switch(direction) {
			
			case "E" : {
				boolean flag = true;
				for(int i=1; i<=weight; i++) {
					
					// 밖에 나가는 지 check
					if(x+i>park[0].length()-1) {
						flag = false;
						break;
					}
					// X와 만나는 지 check
					if(park[y].charAt(x+i) == 'X') {
						flag = false;
						break;
					}
				}
				if(flag) {
					System.out.println("update : E");
					x += weight;
				}
				break;
			}
			
			case "W" : {
				boolean flag = true;
				for(int i=1; i<=weight; i++) {
					
					// 밖에 나가는 지 check
					if(x-i<0) {
						flag = false;
						break;
					}
					// X와 만나는 지 check
					if(park[y].charAt(x-i) == 'X') {
						flag = false;
						break;
					}	
				}

				// 조건을 확인 후 업데이트
				if(flag) {
					System.out.println("update : W");
					x -= weight;
				}
				
				break;
			}
			
			case "S" : {
				boolean flag = true;
				for(int i=1; i<=weight; i++) {
					
					// 밖에 나가는 지 check
					if(y+i>park.length-1) {
						flag = false;
						break;
					}
					// X와 만나는 지 check
					if(park[y+i].charAt(x) == 'X') {
						flag = false;
						break;
					}
						
				}
				// 조건을 확인 후 업데이트
				if(flag) {
					System.out.println("update : S");
					y += weight;
				}
				
				break;
			}

			case "N" : {
				boolean flag = true;
				for(int i=1; i<=weight; i++) {
					
					// 밖에 나가는 지 check
					if(y-i<0) {
						flag = false;
						break;
					}
					// X와 만나는 지 check
					if(park[y-i].charAt(x) == 'X') {
						flag = false;
						break;
					}
				}
				// 조건을 확인 후 업데이트
				if(flag) {
					System.out.println("update : N");
					y -= weight;
				}
				break;
				}
			}
		}
		
		return new int[] {y, x};
	}
}