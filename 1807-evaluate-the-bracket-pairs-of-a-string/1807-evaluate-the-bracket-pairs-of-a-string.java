class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Stack<Character> stack = new Stack<>();
        StringBuilder  sb = new StringBuilder ();
        StringBuilder  res = new StringBuilder ();
        HashMap<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        char[] arr = s.toCharArray();
        int i = 0;
        while(i < arr.length){
            if(arr[i] == '('){
                i++;
                sb.setLength(0);
                while (arr[i] != ')') {
                    sb.append(arr[i]);
                    i++;
                }
                String key = sb.toString();
                if (map.containsKey(key)) {
                    res.append(map.get(key));
                } else {
                    res.append("?");
                }
                i++;
            }
            else{
                res.append(arr[i++]);
            }
        }
        return res.toString();
    }
}