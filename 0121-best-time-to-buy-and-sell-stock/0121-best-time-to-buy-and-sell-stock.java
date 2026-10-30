class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE,profit=0;
        /*for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                max=Math.max(max,prices[j]-prices[i]);
            }
        }*/
        for(int i : prices){
            if(min>i){
                min=i;
            }
            if(profit<i-min)
                profit=i-min;
            //profit = Math.max(profit, i - min);
        }
        return profit;
    }
}