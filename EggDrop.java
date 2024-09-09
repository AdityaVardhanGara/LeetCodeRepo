class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    int[] ans=new int[n+1];
	    int m=0;
	    while(ans[n]<k){
	        for(int j=n;j>0;j--){
	            ans[j]+=1+ans[j-1];
	        }
	        m++;
	    }
	    return m;
	}
}
