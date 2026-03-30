class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map: frequency signature → list of anagrams sharing that signature
        Map<String, List<String>> result = new HashMap<>();

        for (String s : strs) {
            // Count frequency of each letter (a-z) in the current string
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++; // 'c' - 'a' maps char to index 0-25
            }

            // Convert frequency array to string → anagrams produce the same key
            // e.g. "eat" and "tea" both → "[0, 0, 0, 0, 1, 0, ..., 1, ..., 0]"
            String key = Arrays.toString(count);

            // If key doesn't exist yet, create a new list for this anagram group
            result.putIfAbsent(key, new ArrayList<>());

            // Add current string to its anagram group
            result.get(key).add(s);
        }

        // Return all anagram groups as a list of lists
        return new ArrayList<>(result.values());
    }
}
// Time:  O(n * k) where n = number of strings, k = max string length
// Space: O(n * k) to store all strings in the map