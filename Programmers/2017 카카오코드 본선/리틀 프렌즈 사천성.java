import java.util.*;

class Solution {
    
    char[][] map;
    List<Character> list = new ArrayList<>();
    HashMap<Character, int[][]> hm = new HashMap<>();
    
    public String solution(int m, int n, String[] board) {
        String answer = "";
        int idx = 0;
        map = new char[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                
                char ch = board[i].charAt(j);
                map[i][j] = ch;
                if(ch >= 'A' && ch <='Z') {
                    if(!list.contains(ch)) {
                        list.add(ch);
                        hm.put(ch, new int[2][2]);
                        hm.get(ch)[0][0] = i;
                        hm.get(ch)[0][1] = j;
                    } else {
                        hm.get(ch)[1][0] = i;
                        hm.get(ch)[1][1] = j;
                    }                   
                }
            }
        }
        
        Collections.sort(list);
        while(list.size() != 0) {
            if(canDelete(list.get(idx), m, n)) {
                char ch = list.remove(idx);
                int[][] pos = hm.get(ch);
                map[pos[0][0]][pos[0][1]] = '.';
                map[pos[1][0]][pos[1][1]] = '.';
                idx=0;
                answer += ch;
            } else {
                idx++;
                if(idx == list.size()) {
                    return "IMPOSSIBLE";
                }
            }
        }
        
        return answer;
    }
    
    
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    
    public boolean canDelete(char ch, int m, int n) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[4][m][n];
        int[][] pos = hm.get(ch);
        
        queue.offer(new Node(pos[0][0], pos[0][1], -1, 0));
        visited[0][pos[0][0]][pos[0][1]] = true;
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
                         
            if(cur.r == pos[1][0] && cur.c == pos[1][1]) {
                return true;
            }


            for(int i=0; i<4; i++) {
                int ny = cur.r + dy[i];
                int nx = cur.c + dx[i];
                int nCnt = cur.cnt;

                if(ny<0 || nx<0 || ny>=m || nx>=n || visited[i][ny][nx]) continue;
                if(map[ny][nx] != ch && map[ny][nx] !='.') continue;
                if(cur.d != -1 && cur.d != i) nCnt++;
                if(nCnt == 2) continue;
                
                visited[i][ny][nx] = true;
                queue.offer(new Node(ny, nx, i, nCnt));
                
            }
        }
        return false;
    }
    
    class Node {
        int r;
        int c;
        int d;
        int cnt;
        public Node(int r, int c, int d, int cnt) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.cnt = cnt;
        }
    }
}