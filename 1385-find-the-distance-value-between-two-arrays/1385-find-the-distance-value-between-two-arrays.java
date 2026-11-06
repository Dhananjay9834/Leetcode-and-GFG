class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt = 0;
        for(int i : arr1){
            boolean flag = true;
            for(int j : arr2){
                if(Math.abs(i - j) <= d){
                    flag = false;
                    break;
                }
            }
            cnt += flag ? 1 : 0;
        }
        return cnt;
    }
}