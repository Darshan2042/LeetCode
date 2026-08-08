class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < chars.length){
            char ch = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == ch){
                index++;
                count++;
            }

            sb.append(ch);
            if(count > 1){
                sb.append(count);
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}