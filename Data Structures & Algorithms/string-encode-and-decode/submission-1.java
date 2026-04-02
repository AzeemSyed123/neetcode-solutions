class Solution {
    // Encode: turn a list of strings into a single string
    // Format: "length#string" for each string
    // e.g. ["hello", "world"] → "5#hello5#world"
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s); // "length#string"
        }
        return res.toString();
    }

    // Decode: turn the encoded string back into a list of strings
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            // Find the '#' delimiter — everything before it is the length
            while (str.charAt(j) != '#') {
                j++;
            }

            // Extract the length number from between i and j
            int length = Integer.parseInt(str.substring(i, j));

            i = j + 1;          // move past the '#'
            j = i + length;     // jump ahead by the length to get the full string

            res.add(str.substring(i, j)); // extract the actual string
            i = j;              // move to the next encoded segment
        }

        return res;
    }
}
// Time:  O(n) for both encode and decode — n is total characters across all strings
// Space: O(n) — storing the encoded/decoded result