class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            cnt[c - 'a']--;
        }
        for (int i = target.length() - 1; i >= 0; i--) {
            cnt[target.charAt(i) - 'a']++;
            boolean possible = true;
            for (int x : cnt) {
                if (x < 0) {
                    possible = false;
                    break;
                }
            }
            if (!possible) {
                continue;
            }
            int cur = target.charAt(i) - 'a';
            for (int j = cur + 1; j < 26; j++) {
                if (cnt[j] > 0) {
                    cnt[j]--;
                    StringBuilder ans = new StringBuilder(target.substring(0, i));
                    ans.append((char) ('a' + j));
                    for (int k = 0; k < 26; k++) {
                        while (cnt[k] > 0) {
                            ans.append((char) ('a' + k));
                            cnt[k]--;
                        }
                    }
                    return ans.toString();
                }
            }
        }
        return "";
    }
}