class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] rightArr = new int[nums.length];  // product of everything RIGHT of index i
        int[] leftArr = new int[nums.length];   // product of everything LEFT of index i
        int[] outputArr = new int[nums.length]; // final answer: left * right

        // Step 1: Build left products
        leftArr[0] = 1; // nothing to the left of index 0
        for (int i = 1; i < nums.length; i++) {
            leftArr[i] = leftArr[i - 1] * nums[i - 1]; // previous left product * previous element
        }

        // Step 2: Build right products
        rightArr[nums.length - 1] = 1; // nothing to the right of last index
        for (int i = nums.length - 2; i >= 0; i--) {
            rightArr[i] = rightArr[i + 1] * nums[i + 1]; // next right product * next element
        }

        // Step 3: Multiply left * right to get product of everything except self
        for (int i = 0; i < nums.length; i++) {
            outputArr[i] = leftArr[i] * rightArr[i];
        }

        return outputArr;
    }
}
// Time:  O(n) — three separate passes
// Space: O(n) — three arrays