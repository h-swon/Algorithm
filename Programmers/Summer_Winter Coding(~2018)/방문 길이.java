import java.util.*;

class Solution {
    
    // U D R L
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, 1, -1};
    
    public int solution(String dirs) {
        HashSet<String> hs = new HashSet<>();
        int[] curPos = {0, 0};
        for(char dir : dirs.toCharArray()) {
            int d = findDir(dir);    
            int ny = curPos[0] + dy[d];
            int nx = curPos[1] + dx[d];
            if(ny<-5 || nx<-5 || ny>5 || nx>5) continue;
            
            hs.add(curPos[0] +""+ curPos[1] +"" + ny + "" + nx);
            hs.add(ny +""+ nx +""+ curPos[0] + "" + curPos[1]);
            curPos[0] = ny;
            curPos[1] = nx;
        }
        return hs.size() / 2;
    }
    
    public int findDir(char dir) {
        switch(dir) {
            case 'U': return 0;
            case 'D': return 1;
            case 'R': return 2;
            default: return 3;
        }
    }
}