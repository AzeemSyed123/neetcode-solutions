class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){

            freq.putIfAbsent(num, 0);
            freq.put(num, freq.getOrDefault(num,0)+ 1);
        }
        List<Integer> keys = new ArrayList<>(freq.keySet());
        keys.sort((a,b) -> freq.get(b) - freq.get(a));

        int [] result = new int[k];

        for (int i = 0; i<k ; i++){
            result[i]= keys.get(i);
        }
        return result;
    }
}
