class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        int sum = 0;
        while(low<high){
            sum = numbers[low] + numbers[high];
            if(sum < target){
                low++;
            }
            else if(sum > target){
                high--;
            }
            else{
                return new int[]{low+1,high+1};
            }
        }
        return null;       
    }
}