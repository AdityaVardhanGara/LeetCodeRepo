class Solution {
public:
    int countSubstrings(string s) {
        int n=s.length();int cnt=0;
        vector<vector<bool>> dp (n,vector<bool> (n,0));
        for(int i=0;i<n;i++) dp[i][0]=1,cnt++;
        for(int i=0;i<n-1;i++) {
            if(s[i]==s[i+1]) dp[i][1]=1,cnt++;
            // cout<<dp[i][1]<<" ";
        }
        cout<<cnt<<endl;
        for(int i=2;i<n;i++){
            for(int j=0;j+i<n;j++){
                if(s[j]==s[j+i] && dp[j+1][i-2]) {
                dp[j][i]=1,cnt++; 
                // cout<<dp[i][j]<<" ";
                }
            }
            // cout<<cnt<<endl;
        }
        return cnt;
    }
};
