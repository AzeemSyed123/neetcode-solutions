class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.putIfAbsent(num, 0);           // initialize to 0 if first time seeing this number
            freq.put(num, freq.getOrDefault(num, 0) + 1); // increment count
        }

        // Step 2: Get all unique numbers and sort by frequency (highest first)
        List<Integer> keys = new ArrayList<>(freq.keySet());
        keys.sort((a, b) -> freq.get(b) - freq.get(a)); // descending order: b - a

        // Step 3: Pick the first k elements (the most frequent ones)
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = keys.get(i);
        }

        return result;
    }
}
// Time:  O(n log n) — sorting dominates
// Space: O(n) — for the frequency map and keys list