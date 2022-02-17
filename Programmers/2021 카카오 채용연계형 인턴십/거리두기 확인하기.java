import java.util.*;

class Solution {
    
    int[] dc = new int[]{-1, 1, 0, 0};
    int[] dr = new int[]{0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[5];
        for(int i=0; i<5; i++) {
            answer[i] = isPass(places[i]);
        }
        return answer;
    }
    
    public int isPass(String[] board) {
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(board[i].charAt(j)=='P') {
                    if(!bfs(board, i, j)){
                        return 0;
                    }   
                }
            }
        }
        return 1;
    }
    
    public boolean bfs(String[] board, int r, int c) {
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            for(int i=0; i<4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr<0 || nc<0 || nr>=5 || nc>=5 || visited[nr][nc]) continue;
                
                int d = Math.abs(nr - r) + Math.abs(nc -c);
                visited[nr][nc]= true;
                
                if(d<=2 && board[nr].charAt(nc)=='P') {
                    return false;
                }
                if(d<2 && board[nr].charAt(nc)=='O') {
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return true;
    }
}