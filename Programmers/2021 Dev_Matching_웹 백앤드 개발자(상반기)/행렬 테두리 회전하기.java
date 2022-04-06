class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        int[] answer = new int[queries.length];
        int num = 1;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++)
                map[i][j] = num++;
        }
        
        for(int idx=0; idx<queries.length; idx++) {
            int[] query = queries[idx];
            int y1 = query[0]-1;
            int x1 = query[1]-1;
            int y2 = query[2]-1;
            int x2 = query[3]-1;
            int tmp = map[y1][x1];
            int min = tmp;
            
            for(int i=y1; i<y2; i++) {
                map[i][x1] = map[i+1][x1];
                min = Math.min(min, map[i][x1]);
            }  
            
            for(int j=x1; j<x2; j++) {
                map[y2][j] = map[y2][j+1];
                min = Math.min(min, map[y2][j]);
            }
            
            for(int i=y2; i>y1; i--) {
                map[i][x2] = map[i-1][x2];
                min = Math.min(min, map[i][x2]);
            }  
            
            for(int j=x2; j>x1; j--) {
                map[y1][j] = map[y1][j-1];
                min = Math.min(min, map[y1][j]);
            }  
            map[y1][x1+1] = tmp;
            answer[idx] = min;
        }
        
        return answer;
    }
}