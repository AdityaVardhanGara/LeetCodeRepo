class Solution {
    public String reverseWords(String s) {
        String[] arr=s.split(" ");
        String ans="";
        for(int i=arr.length-1;i>=0;i--) {
            if(arr[i].length()!=0) ans+=arr[i]+" ";
            // System.out.println(arr[i]);
        } 
        return ans.substring(0,ans.length()-1);

    }
}
