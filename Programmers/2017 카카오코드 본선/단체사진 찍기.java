class Solution {
    int answer =0;
    boolean[] visited = new boolean[8];
    String[] datas;
    String[] friends ={"A","C","F","J","M","N","R","T"};
    
    public int solution(int n, String[] data) {
        datas = data;
        perm(0, "");
        return answer;
    }
    
    public void perm(int cnt, String s) {
        if(cnt == 8) {
            if(check(s))
                answer++;
            return;
        } 
        for(int i=0; i<8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                perm(cnt+1, s+friends[i]);
                visited[i] = false;
            } 
        }
    }
    
    public boolean check(String s) {
        for(String data : datas) {
                int firstIdx= s.indexOf(data.charAt(0));
                int secondIdx = s.indexOf(data.charAt(2));
                char op = data.charAt(3);
                int n = data.charAt(4) -'0' + 1;
                int diff = Math.abs(firstIdx - secondIdx);
      
                switch(op) {
                    case '=': 
                        if(n!=diff) return false;
                        break;
                    case '>':
                        if(!(diff > n)) return false;
                        break;
                    case '<': 
                        if(!(diff < n)) return false;
                        break;
                } 
        }
        return true;
    }
}