import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        int len = genres.length;
        
        for(int i=0;i<len;i++){
            hm.put(genres[i],hm.getOrDefault(genres[i],0)+plays[i]);
        }
        
        ArrayList<Item> songs = new ArrayList<>();
        for(int i=0;i<len;i++){
            songs.add(new Item(genres[i],hm.get(genres[i]).intValue(),plays[i],i));
        }
        Collections.sort(songs, new Comparator<Item>(){
            @Override
            public int compare(Item s1, Item s2){
                int compareFirst = s2.total - s1.total;
                int compareSecond = s2.plays - s1.plays;
                int compareLast = s1.uniqueNumber - s2.uniqueNumber;
                return compareFirst==0?
                    (compareSecond==0?compareLast:compareSecond):compareFirst;
            }
        });

        ArrayList<Integer> tmp = new ArrayList<>();
        
        

        for(int i=0;i<len;i++){
            if(count.getOrDefault(songs.get(i).genres,0)==2)
                continue;
            count.put(songs.get(i).genres,count.getOrDefault(songs.get(i).genres,0)+1);
            tmp.add(songs.get(i).uniqueNumber);
        }
        int[] answer = new int[tmp.size()];
        for(int i=0;i<tmp.size();i++){
            answer[i] = tmp.get(i);
        }
        return answer;
    }
    
    class Item{
        String genres;
        int total;
        int plays;
        int uniqueNumber;
        public Item(String genres,int total, int plays, int uniqueNumber){
            this.genres = genres;
            this.total = total;
            this.plays = plays;
            this.uniqueNumber = uniqueNumber;
        }
    }
}