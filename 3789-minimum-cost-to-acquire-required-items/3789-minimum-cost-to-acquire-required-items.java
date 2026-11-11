class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        
        long minCost = 0;

        // Case 1: buy ietms saperately
        long choice1 = (long) cost1 * need1 + (long) cost2 * need2;

        // Case 2: buy combined Items
        long choice2 = (long) costBoth * Math.max(need1, need2);

        //Case 3: Buy combined for commen items and saperate for required items
        int minNeed = Math.min(need1, need2);
        long choice3 = (long) costBoth * minNeed + (long) (need1 - minNeed) * cost1 + (long) (need2 - minNeed) * cost2;

        minCost = Math.min(choice1, Math.min(choice2, choice3));
        return minCost;
    }
}