import java.util.*;
class Solution {
    
    boolean[][][] visited;
    char[][] map;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, -1, 0, 1};
    int R, C;
    List<Integer> list = new ArrayList<>();
    
    public int[] solution(String[] grid) {
        
        R = grid.length;
        C = grid[0].length();
        map = new char[R][C];
        visited = new boolean[4][R][C];
        
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                map[i][j] = grid[i].charAt(j);
            }
        }
        
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++){
                for(int d=0; d<4; d++) {
                    if(!visited[d][i][j]) {
                        simulation(i, j, d);                    
                    }
                }
            }
        }
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public void simulation(int r, int c, int dir) {
        int res = 0;     
        
        while(true) {
            if(visited[dir][r][c]) break;
            visited[dir][r][c] = true;
            res++;
            
            switch(map[r][c]) {
                case 'L': {
                    dir = (dir+3)%4;
                    break;
                }
                case 'R': {
                    dir = (dir+1)%4;
                    break;
                }
            }
            
            r = (r+ dy[dir] + R) % R;
            c = (c+ dx[dir] + C) % C;
        }
        
        if(res != 0)
            list.add(res);
    }
    
}