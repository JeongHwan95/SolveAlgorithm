import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class SolutionAlphabet {
	
	static List<Integer> sumArrayList;
	static String alphabetArr[];
	static DataStructure ds;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//만들어 본 자료구조
		ds = new DataStructure(52);
		
		// 출력을 위한 StringBuffer 객체 생성
		StringBuffer sb = new StringBuffer();
		
			//새로 만든 자료구조에 문제에서 요구하는 값들을 넣고
		{
			for(int i = 1; i <= 26; i++) {
				int alphabetInt = 96+i;
				char alphabet = (char)alphabetInt;
				ds.add(new Alphabet( alphabet , i));
			}//for
			
			int k = 1;
			for(int i=26; i>=1; i--) {
				int alphabetInt = 96 + (k++);
				char alphabet = (char)alphabetInt;
				ds.add(new Alphabet(alphabet , i));
			}//for	
		}
//		ds.print();
		
		//원하는 수를 testCase에 입력받아
		//그 수만큼 for문을 돌리고
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine(); //버퍼 출력
		
		for(int i = 0 ; i < testCase; i++) {
				
				// 알파벳들을 입력받아
				// 알파벳을 배열로 만들어 쪼개고 (alphabetArr)
				// 모든 경우의 수(마지막 레벨의 요소들의 집합)를 담을 ArrayList를 만든다 (sumArrayList) 
			{
				String row = sc.nextLine();
				alphabetArr = row.split(" ");
				sumArrayList = new ArrayList<Integer>();
			}
			
			dfs(0, 0, 0, true);
			
			
				// DFS를 통해 나온 모든 경우의 수들을
				// sumArrayList라는 자료구조에 넣어 출력한다.
			{
//				System.out.println(sumArrayList.toString());
//				System.out.println(sumArrayList.size());
				sumArrayList.sort(Collections.reverseOrder());;
				Collections.reverse(sumArrayList);
//				System.out.println(sumArrayList.toString());
				int minimum = sumArrayList.get(0);
				sb.append(minimum + "\n");
			}
			
		}//for
		
		// 문제의 값을 출력
		System.out.println(sb.toString());
		
		sc.close();
	}//main
	
	
	//매개변수 설명 : 
	//현재 탐색하고 싶은 레벨 : int level
	//현재 윗 레벨에서 더한 값을 전해줌 : int sum
	//자료구조에서 순회를 시작해야하는 인덱스값, 시작점(DataStructureIndex) : dsIndex
	//순회가 제대로 되는지 확인하기 위해 추가한 매개변수(현재는 쓰이지 않음) : leftRight
	public static void dfs(int level, int sum, int startedDSIndex, boolean leftRight) {
		
			//dfs 탈출조건( 재귀함수임으로 탈출조건이 필요함)
			//String배열의 길이와 레벨이 같다는 뜻은 더 이상 탐색할 아래 레벨이 없다는 뜻임으로
			//dfs를 탈출하고 여지껏 더한 값을 ArrayList에 저장한다.
		{
			if(level == alphabetArr.length) {
				sumArrayList.add(sum);
				return;
			}//if
		}//탈출조건
		
		//ds.search_left와 ds.search_right함수를 통해 받을
		//순회하면서 얻은 합과 alphabetArr[level]의 index값을 받는
		//배열을 만든다.
		int[] sumIndex_fromLeft = new int[2];
		int[] sumIndex_fromRight = new int[2];
		char wantToSearch_alphabet;
			
		//level==0 일때와 그 외의 경우를 구분해야 하는 이유 :
		//level==0 일때는 순회를 하면서 더하면 안되기 때문에
		if(level == 0) {
			//alphabetArr[0] 일 때 인덱스들 구하기
			wantToSearch_alphabet = alphabetArr[level].charAt(0);
			int firstDSIndex_fromLeft = ds.search_left_firstIndex(wantToSearch_alphabet);
			int firstDSIndex_fromRight = ds.search_right_firstIndex(wantToSearch_alphabet);
		
			level++;
			
			//매개변수 설명
			//1번째 레벨과 순회하면서 더한 값들(0), 0번째 레벨의 인덱스, 디버그 차원에서 만든 매개변수
			dfs(level, 0, firstDSIndex_fromLeft, true);
			dfs(level, 0, firstDSIndex_fromRight, false);
			
		}else {
			//level != 0 일 때
			wantToSearch_alphabet = alphabetArr[level].charAt(0);
			
			//ds.search_left, ds.search_right를 탐색하여
			//sum과 alphabet에 해당하는 인덱스를 배열로 리턴받아
			sumIndex_fromLeft = ds.search_left(startedDSIndex, wantToSearch_alphabet);	//이것은 배열
			sumIndex_fromRight = ds.search_right(startedDSIndex, wantToSearch_alphabet);	//이것은 배열
			
			level++;
			
			dfs(level, sum + sumIndex_fromLeft[0], sumIndex_fromLeft[1], true);
			dfs(level, sum + sumIndex_fromRight[0], sumIndex_fromRight[1], false);
		}//else
	}//dfs
}//end SolutionAlphabet Class
