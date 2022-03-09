import java.util.*;

class Solution {
    public long[] solution(long k, long[] room_number) {
        HashMap<Long, Long> next = new HashMap<>();
        long[] answer = new long[room_number.length];
        
        for(int i=0; i<room_number.length; i++) {
            answer[i] = findRoomNumber(room_number[i], next);
        }
        
        return answer;
    }
    
    public long findRoomNumber(long room, HashMap<Long, Long> next) {
        if(!next.containsKey(room)) {
            next.put(room, room+1);
            return room;
        }
        long nextRoom = next.get(room);
        long assignedRoom = findRoomNumber(nextRoom, next);
        next.put(room, assignedRoom);
        
        return assignedRoom;
    }
}