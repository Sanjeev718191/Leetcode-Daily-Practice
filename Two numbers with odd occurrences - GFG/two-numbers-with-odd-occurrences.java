//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int arr[], int n)
    {
        // code here
        int XOR = 0;
        for(int num : arr) XOR ^= num;
        XOR = XOR & (~(XOR-1));
        int xor1 = 0, xor2 = 0;
        for(int num : arr) {
            if((XOR & num) != 0) xor1 ^= num;
            else xor2 ^= num;
        }
        return xor1 > xor2 ? new int[] {xor1, xor2} : new int[] {xor2, xor1};
    }
}