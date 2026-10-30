class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int formed = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) {
                    formed++;
                }
            }
            while (formed == t.length()) {
                int len = right - left + 1;
                if (len < minLength) {
                    minLength = len;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        formed--;
                    }
                }
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minLength);
    }
}