class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        Set<Integer> list = new LinkedHashSet<>();
        for(int num : temp){
            list.add(num);
        }

        int[] u = new int[list.size()];
        int k = 0;
        for(int num : list){
            u[k++] = num;
        }
        int[] res = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<u.length; j++){
                if(arr[i] == u[j]){
                    res[i] = j+1;
                    break;
                }
            }
        }
        return res; 
    }
}