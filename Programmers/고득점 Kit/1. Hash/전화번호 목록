import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String,String> hm = new HashMap<>();
        for(String phoneNumber: phone_book){
            hm.put(phoneNumber,phoneNumber);
        }
        for(String phoneNumber: phone_book){
            for(int i=1;i<phoneNumber.length();i++){
                if(hm.containsKey(phoneNumber.substring(0,i))){
                    return false;
                }
            }
        }
        return true;
    }
}