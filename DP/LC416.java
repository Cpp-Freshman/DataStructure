package DSandAL.DP;


/*
 * 测试求方案,只能找到一种
 */

public class LC416 {
    public static void main(String[] args) {
        int[] a = {1, 5,3,7};
        System.out.println(canPartition(a));
        int[] res = new int[]{1,2};

    }

    public static boolean canPartition(int[] nums) {
        if(nums.length < 2) return false;
        int sum = 0;
        for(int i:nums)  sum += i;
        if((sum&1) != 0) return false;
        sum = sum/2;

        return mycanP(nums,sum);
    }
    private static boolean mycanP(int[] nums,int sum){
        System.out.println(sum);
        boolean[][] dp = new boolean[nums.length][sum + 1];
        int[][] memo = new int[nums.length][sum+1];
        for(int j = 0;j < dp[0].length;j++)
        {
            if(nums[0] == j){
                dp[0][j] = true;
                memo[0][j] = 1;
            }

        }

        for(int i = 1;i < dp.length;i++){
            for(int j = 0;j <= sum;j++){
                if(j < nums[i])
                    dp[i][j] = dp[i - 1][j];
                else {
                    if(dp[i - 1][j - nums[i]]){
                        dp[i][j] = dp[i - 1][j - nums[i]];
                        memo[i][j] = 1;
                    }
                    if(dp[i - 1][j])
                      dp[i][j] = dp[i - 1][j];
                }
            }
        }
       int p1 = memo.length - 1,p2 = memo[0].length - 1;
      for(int i = 0; i < memo.length;i++){
            for(int j = 0;j < memo[0].length;j++)
                System.out.print(memo[i][j] + "     ");
            System.out.println();
        }

        while(p1 >= 0 && p2 >= 0) {
            if (memo[p1][p2] == 1) {
                System.out.println(nums[p1]);

                p2 -= nums[p1];
            }
            p1--;
        }


        return dp[nums.length - 1][sum];
    }
}
