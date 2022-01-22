class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
        int[][] sum = new int[r + 1][c + 1];
        
        for(int[] s : skill){
            int degree = s[5] * (s[0]==1? -1 : 1);
            int x1 = s[1];
            int y1 = s[2];
            int x2 = s[3];
            int y2 = s[4];
            sum[x1][y1] += degree;
            sum[x1][y2+1] += -degree;
            sum[x2+1][y1] += -degree;
            sum[x2+1][y2+1] += degree;
        }
        
        for(int i=0; i<r; i++){
            for(int j=1; j<c; j++){
                sum[i][j] += sum[i][j-1];
            }
        }
        
        for(int j=0; j<c; j++){
            for(int i=1; i<r; i++){
                sum[i][j] += sum[i-1][j];
            }    
        }
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] + sum[i][j] > 0){
                    answer++;
                }
            }
        }
        return answer;
    }
}