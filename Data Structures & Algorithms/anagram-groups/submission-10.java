class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for(String s : strs){
            int [] freq = new int [26];
            for(char c : s.toCharArray()){
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(s);
        }
        return new ArrayList<>(result.values());
    }
}
// Time:  O(n * k) where n = number of strings, k = max string length
// Space: O(n * k) to store all strings in the map