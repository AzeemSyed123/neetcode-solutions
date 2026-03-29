class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, target, 0, new ArrayList<>(), result);
        return result;

    }


    private void backTrack(int[] nums , int remaining , int start , List<Integer>path , List<List<Integer>>result){

        //Base Case 1 - We hit the target exactly
        if(remaining == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //Base case 2: we overshot (remaining went negative)
        if(remaining  < 0){
            return;
        }

        //Try each candidate from the start onward
        for (int i = start ; i < nums.length ; i++){
            path.add(nums[i]);
            backTrack(nums, remaining - nums[i], i , path , result);
            path.remove(path.size() - 1);

        }
    }
}
