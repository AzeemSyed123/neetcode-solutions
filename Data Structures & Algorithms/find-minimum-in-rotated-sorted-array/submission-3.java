class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // avoids integer overflow vs (left+right)/2

            if (nums[mid] > nums[right]) {
                left = mid + 1; // min must be in the right half (rotation point is there)
            } else {
                right = mid; // min is at mid or somewhere to the left
            }
        }

        return nums[left]; // left == right, both pointing at the minimum
    }
}
// Time:  O(log n) — binary search
// Space: O(1)