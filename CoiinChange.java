class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] ans=new int[amount+1];
        for(int i=1;i<amount+1;i++){
            ans[i]=Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]&&ans[i-coins[j]]!=Integer.MAX_VALUE) ans[i]=Math.min(ans[i],1+ans[i-coins[j]]);
            }
        }
        if(ans[amount]!=Integer.MAX_VALUE) return ans[amount];
        else return -1;
    }
}
