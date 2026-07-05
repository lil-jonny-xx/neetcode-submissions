class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int l=0,r=1;
        int maxP = 0;
        while(r<prices.length)
        {
            int profit;
            if(prices[r]<prices[l])
                l=r;
            else
            {
                profit=prices[r]-prices[l];
                maxP=Math.max(maxP,profit);
            }
            r++;
        }
        return maxP;
    }
}
