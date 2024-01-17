//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。） 
//
// Related Topics 数组 前缀和 👍 1680 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2024011703 {
    public int[] productExceptSelf01(int[] nums) {
        int n = nums.length;
        int[] pre =new int[n];
        int[] behind =new int[n];
        int[] ret =new int[n];
        pre[0]=1; behind[n-1]=1;
        for (int i = 1; i < n; i++) {
            pre[i]=nums[i-1]*pre[i-1];
        }
        for (int i = n-2; i >= 0; i--) {
            behind[i]=behind[i+1]*nums[i+1];
        }
        for (int i = 0; i < n; i++) {
          ret[i] = behind[i]*pre[i];
        }
        return ret;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ret =new int[n];
        ret[0]=1;
        for (int i = 1; i < n; i++) {
            ret[i]=nums[i-1]*ret[i-1];
        }
        int R=1;
        for (int i = n-1; i >= 0; i--) {
            ret [i] =ret[i]*R;
            R*=nums[i];
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
