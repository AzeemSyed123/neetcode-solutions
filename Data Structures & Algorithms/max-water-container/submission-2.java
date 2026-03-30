class Solution {
    public int maxArea(int[] heights) {
        int left = 0;                    // pointer at the start
        int right = heights.length - 1;  // pointer at the end
        int maxArea = 0;

        while (left < right) {
            // Area = shorter wall × distance between walls
            int area = Math.min(heights[left], heights[right]) * (right - left);

            // Update max if this area is bigger
            maxArea = Math.max(area, maxArea);

            // Move the shorter wall inward — keeping the taller one
            // because moving the taller one can only make area smaller
            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
// Time:  O(n) — single pass with two pointers
// Space: O(1) — just three variables