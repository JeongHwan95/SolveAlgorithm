public class DataStructure {
	Alphabet[] alphabetArr;
	int index;	//데이터를 저장하는 위치
	int size;	//배열의 크기
	
	//생성자를 통해 Alphabet 배열의 크기를 결정 지음
	public DataStructure(int size){
		this.size = size;
		this.index = 0;
		this.alphabetArr = new Alphabet[size];
	}//Constructor(size)
	
	
	// 자료구조에 데이터를 더한다
	public void add(Alphabet Alphabet) {
		alphabetArr[index++] = Alphabet;
	}//add(T item)
	
	
	// 이 자료구조의 0번 째 인덱스부터 시작하여
	// 첫번째 시작 노드를 왼쪽 방향으로 순회하면서 찾겠다. 
	// 즉 루트 노드 알파벳'을 찾자
	public int search_left_firstIndex(char start) {
		int index = 0;
		
		// while은 char start과 같은 알파벳을 찾을 때가지 순회하겠다.
		while(true) {
			
			//만약 char start과 같은 알파벳을 찾는다면
			//해당하는 index를 return하여 함수 종료
			if(this.alphabetArr[index].alphabet == start) {
	
				return index;
			}//if
			
			//원형 큐에서 영감받은 로직
			//index에다가 0을 넣어보자! => 이렇게 원형의 성질을 구현
			index = (index-1+size)%size;
			
		}//while
	}//findLeftIndex(char start)

	
	//이 자료구조의 인덱스 1부터 시작하여
	//시작 노드를 오른쪽 방향으로 순회하면서 찾아보겠다
	//즉 루트 노드 알파벳을 찾자
	public int search_right_firstIndex(char start) {
		int index = 1;
		while(true) {
			if(this.alphabetArr[index].alphabet == start) {
				
				return index;
			}//if
			
			//원형 큐에서 영감받은 로직
			//index에다가 size-1을 넣어보자 => 이렇게 원형의 성질을 구현
			index = (index+1)%size;
		}//while
	}//findRightIndex(char start)


	
	//매개변수 설명 : 
	//이 자료구조에서 출발점 : int startedIndex
	//출발점으로부터 어떤 알파벳을 찾을 것인지 : char alphabet
	public int[] search_left(int startedIndex, char alphabet) {
		int[] sumIndex = new int[2];
		while(true) {
			startedIndex = (startedIndex-1+size)%size;
			//순회하면 알파벳의 길이(시간)을 저장
			sumIndex[0] += this.alphabetArr[startedIndex].length;
			
			if(this.alphabetArr[startedIndex].alphabet == alphabet) {
				sumIndex[1] = startedIndex;
				//순회하면 더한 값들(sum)과 alphabet이 들어있는 index를 배열로 리턴
				return sumIndex;
			}//if
		}//while
	}//search_left()
	
	
	//매개변수 설명 : 
	//이 자료구조에서 출발점 : int startedIndex
	//출발점으로부터 어떤 알파벳을 찾을 것인지 : char alphabet
	public int[] search_right(int startedIndex, char alphabet) {
		int[] sumIndex = new int[2];

		while(true) {

			startedIndex = (startedIndex+1)%size;
			//순회하면서 길이(시간)의 값들을 더함
			sumIndex[0] = sumIndex[0] + this.alphabetArr[startedIndex].length;
			
			if(this.alphabetArr[startedIndex].alphabet == alphabet) {
				sumIndex[1] = startedIndex;
				//순회하면 더한 값들(sum)과 alphabet이 들어있는 index를 배열로 리턴
				return sumIndex;	
			}//if
		}//while
	}//search_right()
	
	
	//자료구조의 값들을 출력하는 함수
	//지금은 쓰이지 않음
	public void print() {
		for(int i=0; i<this.alphabetArr.length; i++) {
			System.out.printf("  %d : %c : %d ||", i, alphabetArr[i].alphabet, alphabetArr[i].length);
		}//for
	}//print()

	
	//자료구조에서 값들을 빼서 확인하기 위한 함수, 디버그를 위해 만듬
	//지금은 쓰지 않음
	public Alphabet get(int i) {
		return this.alphabetArr[i];
	}//get
}//DataStructure class end


