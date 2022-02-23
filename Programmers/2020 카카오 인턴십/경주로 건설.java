import java.util.*;

class Solution {
    
    int[] dy = new int[]{-1, 1, 0, 0};
    int[] dx = new int[]{0, 0, -1, 1};
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        boolean[][][] visited = new boolean[4][n][n];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,0,-1));
        visited[0][0][0] = visited[1][0][0] 
            = visited[2][0][0] = visited[1][0][0] = true;
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.x==n-1 && cur.y==n-1) {
                answer = Math.min(answer, cur.cost);
            }
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                if(board[ny][nx]==1) continue;
                int cost = cur.cost;
                if(cur.dir == i || cur.dir == -1) {
                    cost += 100;
                } else {
                    cost += 600;
                }
                if(!visited[i][ny][nx] || board[ny][nx] >= cost) {
                    board[ny][nx] = cost;
                    visited[i][ny][nx] = true;
                    queue.offer(new Node(nx, ny, cost, i));
                }
                
                
            }
        }
        return answer;
    }
    
    class Node {
        int x;
        int y;
        int cost;
        int dir;
        public Node(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
}