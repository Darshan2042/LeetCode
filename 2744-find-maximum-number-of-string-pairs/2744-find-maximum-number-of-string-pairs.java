class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> set = new HashSet<>();
        int count = 0;

        for(String word : words){
            String latest = reverse(word);
            if(set.contains(latest)){
                count++;
            }else{
                set.add(word);
            }
        }
        return count;
    }

    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}