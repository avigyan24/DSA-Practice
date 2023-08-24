//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        int n1=s1.length(),n2=s2.length();
        int[] arr = new int[n1+n2];
        int start1 = 0,start2=0;
        if(s1.charAt(0)=='-')
            start1=1;
        if(s2.charAt(0)=='-')
            start2=1;
            
        for(int i=n1-1;i>=start1;i--){
            for(int j=n2-1;j>=start2;j--){
                arr[i+j+1]+= (s1.charAt(i)-'0')*(s2.charAt(j)-'0');
                arr[i+j]+= arr[i+j+1]/10;
                arr[i+j+1] = arr[i+j+1]%10;
            }
        }
        
        String res="";
        int i=0;
        while(i<n1+n2 && arr[i]==0){
            i++;
        }
        while(i<n1+n2){
            res+=arr[i];
            i++;
        }
        if((s1.charAt(0)=='-' && s2.charAt(0)!='-') || (s2.charAt(0)=='-' && s1.charAt(0)!='-'))
            res = "-"+res;
        return res;
    }
}