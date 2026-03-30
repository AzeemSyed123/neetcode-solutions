class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26]; // frequency of each letter in the current window
        int left = 0;
        int maxFreq = 0;  // count of the most frequent character in the window
        int maxSize = 0;  // our answer: longest valid window found

        for (int right = 0; right < s.length(); right++) {
            // Add the new character to the window and update its frequency
            freq[s.charAt(right) - 'A']++;

            // Track the highest frequency of any single character in the window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // Window is valid if: characters we need to replace <= k
            // Characters to replace = window size - most frequent character count
            int windowLength = right - left + 1;

            // If we need more than k replacements, window is invalid → shrink from left
            if (windowLength - maxFreq > k) {
                freq[s.charAt(left) - 'A']--; // remove left char from frequency
                left++;                        // shrink window
            }

            // Update max with current window size
            windowLength = right - left + 1;
            maxSize = Math.max(maxSize, windowLength);
        }

        return maxSize;
    }
}
//
// Time:  O(n) — single pass
// Space: O(1) — fixed array of 26