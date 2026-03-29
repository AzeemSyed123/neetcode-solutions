class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int [] rightarr = new int[N];
        int [] leftarr = new int[N];

        int[] outputarr = new int[N];

        leftarr[0] = 1;
        rightarr[N-1]= 1;
        for (int i=1 ; i< N ; i++){
            leftarr[i] = nums[i -1] * leftarr[i-1]; 
        }
        for ( int i = N-2 ; i > -1  ; i --){
            rightarr[i] = nums[i+1] * rightarr[i+1];
        }
        for ( int i = 0 ; i < N ; i++){
            outputarr[i] = leftarr[i] * rightarr[i];
        }
        return outputarr;

    
    }
}  
