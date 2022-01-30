class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        long[] video = new long[convertTime(play_time)+1];
        int advTime = convertTime(adv_time);
        
        for(String log : logs){
            String[] l = log.split("-");
            int startTime = convertTime(l[0]);
            int endTime = convertTime(l[1]);
            
            video[startTime]++;
            video[endTime]--;
        }
        
        for(int i=1; i<video.length; i++){  // i초에 영상을 시청하고 있는 사람 수
            video[i] += video[i-1];
        }
        for(int i=1; i<video.length; i++){  // i초까지 시청한 총 재생 시간
            video[i] += video[i-1];
        }
        
        Long max = video[advTime-1];
        int answer= 0;
        for(int i=0; i+advTime < video.length; i++){
            if(max < video[i+advTime] - video[i]){
                max = video[i+advTime] - video[i];
                answer = i + 1;
            }
        }
        
        long hours = answer / 3600;
        long minutes = (answer / 60) % 60;
        long seconds = answer % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    
    
    int convertTime(String time){ // HH:MM:SS
        String[] timeArr = time.split(":");
        return 3600 * Integer.parseInt(timeArr[0]) 
            + 60 * Integer.parseInt(timeArr[1])
            + Integer.parseInt(timeArr[2]);
    }
}