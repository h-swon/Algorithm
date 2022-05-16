class Solution {
    char[][] map;
    int M;
    int N;
    
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        M = m;
        N = n;
        int answer = 0;
        
        for(int i=0; i<board.length; i++) {
            map[i] = board[i].toCharArray();
        }
        
        while(true) {
            int cnt = checkMap();
            if(cnt == 0) break;
            answer += cnt;
            moveDown();
        }
        
        return answer;
    }
    
    public void moveDown() {
        for(int c=0; c<N; c++) {
            for(int r=M-1; r>0; r--) {
                if(map[r][c] == '.') {
                    for(int p=r-1; p>=0; p--) {
                        if(map[p][c] != '.') {
                            map[r][c] = map[p][c];
                            map[p][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public int checkMap() {
        int cnt = 0;
        boolean[][] deleteMap = new boolean[M][N];
        
        for(int r=0; r<M; r++) {
            for(int c=0; c<N; c++) {
                if(map[r][c]!= '.' && canDelete(map[r][c], r, c)) {
                    checkDeletePosition(deleteMap, r, c);
                }
            }
        }
        
        for(int r=0; r<M; r++) {
            for(int c=0; c<N; c++) {
                if(deleteMap[r][c]) {
                    map[r][c] = '.';
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public void checkDeletePosition(boolean[][] deleteMap, int r, int c) {
        for(int nr=r; nr<r+2; nr++) {
            for(int nc=c; nc<c+2; nc++) {
                deleteMap[nr][nc] = true;
            }
        }
    }
    
    public boolean canDelete(char type, int r, int c) {
        if(r+1 < M && c+1 < N) {
           if(type == map[r+1][c] && type == map[r][c+1] && type == map[r+1][c+1]) {
               return true;
           }
        }
        return false;
    }
}