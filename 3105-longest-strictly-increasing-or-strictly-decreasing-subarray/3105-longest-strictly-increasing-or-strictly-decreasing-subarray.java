class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incrLen = 1;
        int decrLen = 1;
        int maxLen = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                incrLen++;
                decrLen = 1;
            }
            else if(nums[i] < nums[i-1]){
                decrLen++;
                incrLen = 1;
            }
            else{
                incrLen = 1;
                decrLen = 1;
            }
            maxLen = Math.max(maxLen, Math.max(incrLen, decrLen));
        }
        return maxLen;
    }
}