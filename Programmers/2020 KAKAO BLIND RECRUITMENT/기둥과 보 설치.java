class Solution {
    
    boolean[][] pillars, beams;
    int count;
    int N;
    
    public int[][] solution(int n, int[][] build_frame) {
        
        pillars = new boolean[n+3][n+3];
        beams = new boolean[n+3][n+3];
        N = n;
        
        for(int[] frame : build_frame){
            int x = frame[0] + 1;
            int y = frame[1] + 1;
            int type = frame[2];
            int action = frame[3];
            
            setFrame(x, y, type, action);            
        }

        int[][] answer = new int[count][3];
        int idx=0;

        for(int i=1; i<=n+1; i++){
            for(int j=1; j<=n+1; j++){
                if(pillars[j][i]){
                    answer[idx++] = new int[]{i-1, j-1, 0};
                }
                if(beams[j][i]){
                    answer[idx++] = new int[]{i-1, j-1, 1};
                }
            }
        }
        return answer;
    }
    
    public void setFrame(int x, int y, int type, int action){
        if(type == 0){  // 기둥
            if(action == 0){    // 삭제
                pillars[y][x] = false;
                count--;
                if(!canDelete(x, y)){
                    pillars[y][x] = true;
                    count++;
                }
            } else{             // 설치
                if(canBuildPillar(x, y)){
                    pillars[y][x] = true;
                    count++;
                }
            }
        } else{ // 보
            if(action == 0){    // 삭제
                beams[y][x] = false;
                count--;
                if(!canDelete(x, y)){
                    beams[y][x] = true;
                    count++;
                }
            } else{             // 설치
                if(canBuildBeam(x, y)){
                    beams[y][x] = true;
                    count++;
                }
            }
        }
    }
    
    public boolean canBuildPillar(int x, int y){
        return y==1 || pillars[y-1][x] || beams[y][x-1] || beams[y][x];
    }
    
    public boolean canBuildBeam(int x, int y){
        return pillars[y-1][x] || pillars[y-1][x+1] ||
            (beams[y][x-1] && beams[y][x+1]);
    }
    
    public boolean canDelete(int x, int y){
        for(int i=1; i<=N+1; i++){
            for(int j=1; j<=N+1; j++){
                if(pillars[j][i] && !canBuildPillar(i, j)) return false;
                if(beams[j][i] && !canBuildBeam(i, j)) return false;
            }
        }
        return true;
    }

}