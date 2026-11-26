
class Solution {
    public boolean canAliceWin(int n) {

        int stones = 10;
        int turns = 0;

        while (stones > 0 && n >= stones) {

            n = n - stones;

            stones--;

            turns++;
        }

        return turns % 2 == 1;
    }
}
