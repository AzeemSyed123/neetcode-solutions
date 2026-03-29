class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, target, 0, new ArrayList<>(), result);
        return result ;
        
    }

    private void backTrack(int[] nums , int remaining , int start, List<Integer>path, List<List<Integer>> result){
        //Base case 1 : we hit the target exactly 
        if(remaining == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        //Base case 2: we overshot(remaining went negative)
        if(remaining < 0){
            return;
        }
        //try each candidate from 'start' onward
        for(int i = start ; i<nums.length ; i++){
            path.add(nums[i]);
            backTrack(nums, remaining - nums[i], i , path, result); // explore recurse(stay at i , not i+1)

            path.remove(path.size() - 1); // undo remove it before trying next option
        }
    }
}
