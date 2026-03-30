class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>(); // tracks characters in current window
        int maxCount = 0;
        int left = 0; // left edge of the sliding window

        // right pointer expands the window one character at a time
        for (int right = 0; right < s.length(); right++) {

            // If current char already in window, shrink from the left
            // until the duplicate is removed
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left)); // remove leftmost char
                left++;                       // shrink window
            }

            // Add current char to the window
            seen.add(s.charAt(right));

            // Update max: window size = right - left + 1
            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
    }
}
//
// Time:  O(n) — each character is added and removed from the set at most once
// Space: O(min(n, 26)) — set holds at most 26 lowercase letters