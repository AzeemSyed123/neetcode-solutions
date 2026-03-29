class Solution {
    public int longestConsecutive(int[] nums) {

        if ( nums == null ||  nums.length == 0){
            return 0 ;
        }

        Set<Integer> count = new HashSet<>();

        for(int num : nums){
            count.add(num);
        }

        int longest = 0;
        for (int num : count){
            if(!count.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;
                while(count.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                longest = Math.max(longest, currentStreak);
 
            }
        }
        return longest;
        

}
    
}
