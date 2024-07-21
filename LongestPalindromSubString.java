class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n<=1) return s;
        int[] dp=new int[2*n+1];
        int c=0;int r=0;int ml=0;
        String ms="#";
        String ans="";
        for(int i=0;i<n;i++){
            ms+=s.charAt(i)+"#";
        }
        for(int i=1;i<2*n;i++){
            if(i<r){
                dp[i]=Math.min(r-i,dp[2*c-i]);
            }
            while(i-dp[i]-1>=0&&i+dp[i]+1<2*n+1&&ms.charAt(i-dp[i]-1)==ms.charAt(i+dp[i]+1)) dp[i]++;
            System.out.println(i+" "+dp[i]);
            if (i + dp[i] > r) {
                c = i;
                r = i + dp[i];
            }
            if(ml<dp[i]){
                    ml=dp[i];
                    ans=s.substring((i-dp[i])/2,(i+dp[i]+1)/2);
                }
        }
        return ans;
    }
}
