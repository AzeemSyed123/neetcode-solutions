class Solution {
    public int maxProfit(int[] prices) {

        // Assume we buy the stock on day 0 initially
        int buy_price = prices[0];

        // Stores the maximum profit found so far
        int maxProfit = 0;

        // Start from day 1 since day 0 is already considered as initial buy day
        for (int i = 1; i < prices.length; i++) {

            // If current price is lower than our previous buy price,
            // update buy_price because buying cheaper is always better
            if (prices[i] < buy_price) {
                buy_price = prices[i];
            }

            else {

                // Calculate profit if we sell today
                int currentProfit = prices[i] - buy_price;

                // Update maxProfit if currentProfit is greater
                maxProfit = Math.max(currentProfit, maxProfit);
            }
        }

        // Return the maximum profit possible
        return maxProfit;
    }
}