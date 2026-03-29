class Solution {
    public int[] productExceptSelf(int[] nums) {

        int [] leftarr = new int[nums.length];
        int [] rightarr = new int[nums.length];
        
        int [] outputarr = new int [nums.length];
        leftarr[0] = 1;
        rightarr[nums.length -1] = 1;
    for(int i=1; i< nums.length; i++){
        leftarr [i] = nums[i-1] * leftarr[i-1];
    }
    for (int i= nums.length-2; i >=0 ; i--){
        // rightarr [i] = nums[i+1] * rightarr[i+1];
        rightarr[i] = nums[i + 1] * rightarr[i + 1];
    }
    for ( int i= 0 ; i<nums.length ; i++){
        outputarr[i] = leftarr[i] * rightarr[i];
    }
    return outputarr;

    
    }
}  
