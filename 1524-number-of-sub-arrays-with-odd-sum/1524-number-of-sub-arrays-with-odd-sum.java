class Solution {
    public int numOfSubarrays(int[] arr) {

        int mod = 1000000007;
        int count = 0;
        int sum = 0;

        int evenCnt = 1;
        int oddCnt = 0;

        for(int num : arr){
            sum += num;
            if(sum % 2 == 0){
                evenCnt++;
                count += oddCnt;
            }
            else{
                oddCnt++;
                count += evenCnt;
            }
            count %= mod;
        }
        return count;
    }
}