class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank = 1;
        for(int i=0; i<temp.length; i++){
            if(i > 0 && temp[i] == temp[i-1]){
                continue;
            }
            map.put(temp[i] , rank);
            rank++;
        }
        int[] res = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}