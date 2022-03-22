class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skill_tree : skill_trees) {
            String tmp = skill_tree;
            
            for(int i=0; i<skill_tree.length(); i++) {
                String s = String.valueOf(skill_tree.charAt(i));
                if(!skill.contains(s)) {
                    tmp = tmp.replace(s, "");
                }
            }
            
            if(skill.indexOf(tmp) == 0){
                answer++;
            }
        }
        return answer;
    }
}