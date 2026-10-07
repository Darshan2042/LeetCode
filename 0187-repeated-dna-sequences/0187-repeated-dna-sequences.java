class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for(int i=0; i<=s.length()-10; i++){
            String word = s.substring(i,i+10);
            if(seen.contains(word)){
                res.add(word);
            }
            else{
                seen.add(word);
            }
        }  
        return new ArrayList<>(res);
    }
}