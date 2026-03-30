class Solution {
    public int longestConsecutive(int[] nums) {
        // Edge case: empty or null array has no sequence
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 1: Add all numbers to a HashSet for O(1) lookups
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Step 2: Loop through each number in the set
        for (int num : set) {
            // Only start counting if this number is the START of a sequence
            // i.e. no number exists before it (num-1 not in set)
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Keep extending the streak as long as the next number exists
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update longest if this streak is the new max
                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }
}
// Time:  O(n) — each number is visited at most twice (once in loop, once in a while chain)
// Space: O(n) — for the HashSet