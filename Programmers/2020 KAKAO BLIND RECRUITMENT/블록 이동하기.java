import java.util.*;

class Solution {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    
    int[] dx2 = new int[]{1, 1, -1, -1};
    int[] dy2 = new int[]{-1, 1, -1, 1};
    int[] dx3 = new int[]{-1, 1, -1, 1};
    int[] dy3 = new int[]{1, 1, -1, -1};
    
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        boolean[][][] visited = new boolean[2][n][n];
        Queue<Point> queue = new LinkedList<>();
        
        queue.offer(new Point(0, 0, 1, 0, 0, 0));
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            if((cur.x1 == n-1 && cur.y1 ==n-1) 
               || (cur.x2 == n-1 && cur.y2==n-1)){
                answer = cur.time;
                break;
            }
            for(int i=0; i<4 ;i++){
                int nx1 = cur.x1 + dx[i];
                int ny1 = cur.y1 + dy[i];
                int nx2 = cur.x2 + dx[i];
                int ny2 = cur.y2 + dy[i];
                if(nx1<0 || nx2<0 || ny1<0 || ny2<0 ||
                  nx1>=n || nx2>=n || ny1>=n || ny2>=n) continue;
                if(board[ny1][nx1]==1 || board[ny2][nx2]==1) continue;
                
                if(!visited[cur.type][ny1][nx1] || !visited[cur.type][ny2][nx2]){
                    visited[cur.type][ny1][nx1] = true;
                    visited[cur.type][ny2][nx2] = true;
                    queue.offer(new Point(nx1, ny1, nx2, ny2, cur.type, cur.time+1));
                }
            }
            if(cur.type==0){ // 가로
                for(int i=0; i<4; i++){
                    int nx1 = cur.x1;
                    int ny1 = cur.y1;
                    int nx2 = cur.x2;
                    int ny2 = cur.y2;
                    if(i<2) {
                        nx1 = cur.x1 + dx2[i];
                        ny1 = cur.y1 + dy2[i];
                    } else {
                        nx2 = cur.x2 + dx2[i];
                        ny2 = cur.y2 + dy2[i];
                    }
                    if(nx1<0 || nx2<0 || ny1<0 || ny2<0 ||
                  nx1>=n || nx2>=n || ny1>=n || ny2>=n) continue;
                    if(board[ny1][nx1]==1 || board[ny2][nx2]==1) continue;

                    if(i==0 && board[ny1][cur.x1]==1) continue;
                    else if(i==1 && board[ny1][cur.x1]==1) continue;
                    else if(i==2 && board[ny2][cur.x2]==1) continue;
                    else if(i==3 && board[ny2][cur.x2]==1) continue;
                    
                    if(!visited[1][ny1][nx1] || !visited[1][ny2][nx2]){
                        visited[1][ny1][nx1] = true;
                        visited[1][ny2][nx2] = true;
                        
                        if(i==0 || i==3){
                            queue.offer(new Point(nx1, ny1, nx2, ny2, 1, cur.time+1));
                        } else{
                            queue.offer(new Point(nx2, ny2, nx1, ny1, 1, cur.time+1));
                        }
                    }
                }
                
            } else{
                  for(int i=0; i<4; i++){
                    int nx1 = cur.x1;
                    int ny1 = cur.y1;
                    int nx2 = cur.x2;
                    int ny2 = cur.y2;
                    if(i<2) {
                        nx1 = cur.x1 + dx3[i];
                        ny1 = cur.y1 + dy3[i];
                        
                    } else {
                        nx2 = cur.x2 + dx3[i];
                        ny2 = cur.y2 + dy3[i];
                    }
                      
                    if(nx1<0 || nx2<0 || ny1<0 || ny2<0 ||
                        nx1>=n || nx2>=n || ny1>=n || ny2>=n) continue;
                    if(board[ny1][nx1]==1 || board[ny2][nx2]==1) continue;

                    if(i==0 && board[cur.y1][nx1]==1) continue;
                    else if(i==1 && board[cur.y1][nx1]==1) continue;
                    else if(i==2 && board[cur.y2][nx2]==1) continue;
                    else if(i==3 && board[cur.y2][nx2]==1) continue;
                    
                    if(!visited[0][ny1][nx1] || !visited[0][ny2][nx2]){
                        visited[0][ny1][nx1] = true;
                        visited[0][ny2][nx2] = true;
                        if(i==0 || i==3){
                            queue.offer(new Point(nx1, ny1, nx2, ny2, 0, cur.time+1));
                        } else{
                            queue.offer(new Point(nx2, ny2, nx1, ny1, 0, cur.time+1));
                        }
                    }
                }
            }
        }
        return answer;
    }
  
}

class Point{
    int x1;
    int y1;
    int x2;
    int y2;
    int type;   // 0이면 가로, 1이면 세로방향
    int time;
    
    Point(int x1, int y1, int x2, int y2, int type, int time){
        this.x1= x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.type = type;
        this.time = time;
    }
}