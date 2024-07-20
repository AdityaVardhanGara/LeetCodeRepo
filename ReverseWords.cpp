class Solution {
public:
    string reverseWords(string s) {
        int n=s.size()-1;
        int i=n;string ans="";
        vector<string> v;
        while(i>=0){
            if(s[i]==' '){
                if(i==n) i--,n--;
                else {v.push_back(s.substr(i+1,n-i));n=--i;}
            }
            else if (i==0) v.push_back(s.substr(i--,n+1));
            else i--;
        }
        for(int i=0;i<v.size();i++) ans+=v[i]+' ';
        ans.pop_back();
        return ans;
    }
};
