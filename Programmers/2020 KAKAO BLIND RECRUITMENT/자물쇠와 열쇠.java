import java.util.*;

class Solution {
    
    public boolean solution(int[][] key, int[][] lock) {

        int offset = key.length - 1;
        int size = (offset) * 2 + lock.length;
        
        for(int r=0; r<lock.length + offset; r++){
            for(int c=0; c<lock.length + offset; c++){
                for(int rotate=0; rotate<4 ;rotate++){
                    int[][] board = new int[size][size];
                    
                    for(int i=0; i<lock.length; i++){
                        for(int j=0; j<lock.length; j++){
                            board[offset+i][offset+j]= lock[i][j];                            
                        }
                    }
                    
                    setKey(r, c, rotate, key, board);
                    if(canUnlock(lock.length, offset, board)){
                        return true;
                    }
                }   
            }
        }
        
        return false;
    }
    
    public void setKey(int r, int c, int rotate, int[][] key, int[][] board){
        
        int len = key.length;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(rotate==0) {
                    board[r+i][c+j] += key[i][j];
                } else if(rotate == 2) {
                    board[r+i][c+j] += key[j][len-i-1];
                } else if(rotate == 3) {
                    board[r+i][c+j] += key[len-i-1][len-j-1];
                } else {
                    board[r+i][c+j] += key[len-j-1][i];
                }
            }
        }
    }
    
    public boolean canUnlock(int len, int offset, int[][] board){
        for(int i=0; i<len ; i++){
            for(int j=0; j<len ; j++){
                if(board[offset+i][offset+j] != 1)
                    return false;
            }
        }
        return true;
    }
}