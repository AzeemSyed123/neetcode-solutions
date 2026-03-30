class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Found the target
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Target is within the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // search left
                } else {
                    left = mid + 1; // target must be in the right half
                }
            }
            // Else the right half is sorted
            else {
                // Target is within the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // search right
                } else {
                    right = mid - 1; // target must be in the left half
                }
            }
        }

        return -1; // target not found
    }
}
// Time:  O(log n) — binary search
// Space: O(1)