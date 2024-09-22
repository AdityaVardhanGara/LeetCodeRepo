class Solution{
    static int palindromicPartition(String s)
    {
        // code here
        int n=s.length();
        boolean [][] palindrome=new boolean[n][n];
        int [][] dp=new int[n][n];
        for(int i=0;i<n;i++) {palindrome[i][i]=true;dp[i][i]=0;}
        for(int i=0;i<n-1;i++) {
            if(s.charAt(i)==s.charAt(i+1)){palindrome[i][i+1]=true;dp[i][i+1]=0;}
            else dp[i][i+1]=1;
        }
        for(int len=3;len<=n;len++){
            for(int i=0;i+len-1<n;i++){
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                if(s.charAt(i)==s.charAt(j)&&palindrome[i+1][j-1]) {
                    palindrome[i][j]=true;dp[i][j]=0;}
                else{
                    for(int k=i+1;k<=j;k++){
                        dp[i][j]=Math.min(dp[i][j],1+dp[i][k-1]+dp[k][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
