import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap <Character,Integer> map = new HashMap<>();
        int left = 0, right = 0, max = 0;
        for(right = 0; right< s.length(); right++)
        {
            char ch = s.charAt(right);
            if(map.containsKey(ch) && map.get(ch) >= left){
                left = map.get(ch) + 1;
            }

            map.put(ch, right);

            max = Math.max(max, right-left+1);
        }
        return max;
    }
}