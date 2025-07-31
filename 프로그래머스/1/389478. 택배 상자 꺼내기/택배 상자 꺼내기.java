class Solution {
     public int solution(int n, int w, int num) {
        
        int h;
        if(n%w==0){
            h = n/w;
        }else{
            h = n/w+1;
        }
        
        int[][] arr = new int[h][w];
        int x =0;
        int y =0;
        
       for(int i=0; i<n; i++){

            int cur_h = i/w;
            if(cur_h%2==0){
                if(num == i+1){
                    x = cur_h;
                    y = i%w;
                }
                arr[cur_h][i%w] = i+1;
            }else{
                if(num == i+1){
                    x = cur_h;
                    y = w-i%w-1;
                }
                arr[cur_h][w-i%w-1]=i+1;
            }
        }
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){

                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
        System.out.println(arr[x][y]);

        int count = 0;
        for(int i=x; i<arr.length; i++){
            
           if(arr[i][y] != 0){
               System.out.println(arr[i][y] + " ");
               count++;
           }
        }

        return count;
    }
}
