//给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组。 
//
// 设计一个算法使得这 k 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], k = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 
//其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], k = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], k = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁶ 
// 1 <= k <= min(50, nums.length) 
// 
//
// Related Topics 贪心 数组 二分查找 动态规划 前缀和 👍 926 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int splitArray(int[] nums, int k) {
        int left =0,right=0;
        for (int i = 0; i < nums.length; i++) {
            right+=nums[i];
            if (left<nums[i]){
                left=nums[i];
            }
        }
        while (left<right){
            int mid = (right - left) / 2 + left;
            if (check(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    public boolean check(int[] nums,int mid, int m){
        int cnt=1;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            if (sum+nums[i]>mid){
                cnt++;
                sum=nums[i];
            }else {
                sum+=nums[i];
            }
        }

        return cnt<=m;
    }
    public int splitArray01(int[] nums, int k) {
        int n = nums.length;
        int[][] fn =new int[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(fn[i],Integer.MAX_VALUE);
        }
        int[] sub =new int[n+1];
        for (int i = 0; i < nums.length; i++) {
            sub[i+1]= sub[i]+nums[i];
        }
        fn[0][0]=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                for (int m = 0; m < i; m++) {
                    fn[i][j] = Math.min(fn[i][j], Math.max(fn[m][j - 1], sub[i] - sub[m]));
                }
            }
        }
        return fn[n][k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
