/* 375. Guess Number Higher or Lower II
 * 动态规划
 * 从长度为2开始计算，直到长度为n
 * cost[1,n] = k + max{cost[1,k - 1] + cost[k+1,n]}
 * cost[1,n]最小值：k 在 [1,n] 遍历，取上式最小值
 */
public class Solution {
    public int getMoneyAmount(int n) {
    	
    	int dp[][] = new int[n+2][n+2];
    	for (int l = 2; l<=n ;l++){
    		for(int i=1; i<=n-l+1;i++){
    			int right = i+l-1;
    			dp[i][right] = Integer.MAX_VALUE;  
    			
    			for(int k = i; k<=right;k++){			
    				int temp = k+Math.max(dp[i][k-1], dp[k+1][right]);
    				if (dp[i][right]>temp){
    					dp[i][right]=temp;					
    				}				
    			}		
    		}
    	}
    	return dp[1][n];
    }
}