public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int head = 0;
        int tail = 0;
        int result = 0;
        Map<Character, Integer> char2index = new HashMap<Character, Integer>();
        while(tail < s.length()) {
            char tailChar = s.charAt(tail);
            if (char2index.containsKey(tailChar)) {
                int oldHead = head;
                head = char2index.get(tailChar) + 1;
                for (int i = oldHead; i < head; i++) {
                    char2index.remove(s.charAt(i));
                }
                
                char2index.put(tailChar, tail);
                
                tail++;
                
            } else {
                char2index.put(tailChar, tail);
                tail++;
                result = (tail - head) > result ? tail - head : result;
            }
        }
        return result;
    }
}