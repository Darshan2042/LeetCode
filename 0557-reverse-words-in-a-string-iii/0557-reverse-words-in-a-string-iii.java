class Solution {
    public String reverseWords(String s) {
        String[] word = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String w : word){
            sb.append(reverse(w));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    private String reverse(String s){
        char[] arr = s.toCharArray();
        int low = 0;
        int high = s.length()-1;
        while(low < high){
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return new String(arr);
    }
}