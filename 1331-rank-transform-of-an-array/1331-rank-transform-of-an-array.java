class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        Arrays.sort(temp);

        int rank = 1;

        for(int i = 0; i<arr.length;i++){
            if(!map.containsKey(temp[i])){
                map.put(temp[i], rank);
                rank++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
  

// 5, 9, 12, 12, 28, 37, 56, 80, 100

// 1,  2,  3, 3,  4,  5,  6,  7,  8

