class Solution {
     public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        String color = board[h][w];
        
        for(int i=0; i<4; i++){
            
            int x = w + dx[i];
            int y = h + dy[i];
            
            if(x<0 || y<0 || x>=board.length || y>=board[h].length){
                //System.out.println("i");
                continue;
            }

            String value = board[y][x];

            if(value.equals(color)) {
                answer++;
            }

        }

        return answer;
    }
}