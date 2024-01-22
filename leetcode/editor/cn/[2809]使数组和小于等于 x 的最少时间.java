//给你两个长度相等下标从 0 开始的整数数组 nums1 和 nums2 。每一秒，对于所有下标 0 <= i < nums1.length ，nums1[
//i] 的值都增加 nums2[i] 。操作 完成后 ，你可以进行如下操作： 
//
// 
// 选择任一满足 0 <= i < nums1.length 的下标 i ，并使 nums1[i] = 0 。 
// 
//
// 同时给你一个整数 x 。 
//
// 请你返回使 nums1 中所有元素之和 小于等于 x 所需要的 最少 时间，如果无法实现，那么返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3], nums2 = [1,2,3], x = 4
//输出：3
//解释：
//第 1 秒，我们对 i = 0 进行操作，得到 nums1 = [0,2+2,3+3] = [0,4,6] 。
//第 2 秒，我们对 i = 1 进行操作，得到 nums1 = [0+1,0,6+3] = [1,0,9] 。
//第 3 秒，我们对 i = 2 进行操作，得到 nums1 = [1+1,0+2,0] = [2,2,0] 。
//现在 nums1 的和为 4 。不存在更少次数的操作，所以我们返回 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2,3], nums2 = [3,3,3], x = 4
//输出：-1
//解释：不管如何操作，nums1 的和总是会超过 x 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10³ 
// 1 <= nums1[i] <= 10³ 
// 0 <= nums2[i] <= 10³ 
// nums1.length == nums2.length 
// 0 <= x <= 10⁶ 
// 
//
// Related Topics 数组 动态规划 排序 👍 50 👎 0


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution20240119daily {
    public int minimumTime01(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        // fn 表示 对前 i 个 数进行j次 操作后 数组元素总和减少对量.
        int[][] fn =new int[n+1][n+1];
        // 这里定义nums进行排序。将nums1中对元素按照  nums2 进行排序升序排序
        int[][] nums =new int[n][0];
        for (int i = 0; i < n; i++) {
           nums[i] = new int[]{nums1.get(i),nums2.get(i)};
        }
        //排序
        Arrays.sort(nums,Comparator.comparingInt(a -> a[1]));
        //本题对难点主要在于状态方程对推到.
        // 每操作一次， 减少的元素和为 d=nums1[i]+nums2[i]*j
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                fn[i][j] =fn[i-1][j];
                if (j>0){
                    int a = nums[i - 1][0], b = nums[i - 1][1];
                    fn[i][j] = Math.max(fn[i][j], fn[i - 1][j - 1] + a + b * j);
                }
            }
        }
        int s1 = 0, s2 = 0;
        for (int v : nums1) {
            s1 += v;
        }
        for (int v : nums2) {
            s2 += v;
        }

        for (int j = 0; j <= n; ++j) {
            if (s1 + s2 * j - fn[n][j] <= x) {
                return j;
            }
        }
        return -1;
    }

    public int minimumTime02(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        // fn 表示 对前 i 个 数进行j次 操作后 数组元素总和减少对量.
        int[] fn =new int[n+1];
        // 这里定义nums进行排序。将nums1中对元素按照  nums2 进行排序升序排序
        int[][] nums =new int[n][0];
        for (int i = 0; i < n; i++) {
            nums[i] = new int[]{nums1.get(i),nums2.get(i)};
        }
        //排序
        Arrays.sort(nums,Comparator.comparingInt(a -> a[1]));
        //本题对难点主要在于状态方程对推到.
        // 每操作一次， 减少的元素和为 d=nums1[i]+nums2[i]*j
        for (int[] e : nums) {
            int a = e[0], b = e[1];
            for (int j = n; j > 0; --j) {
                fn[j] = Math.max(fn[j], fn[j - 1] + a + b * j);
            }
        }
        int s1 = 0, s2 = 0;
        for (int v : nums1) {
            s1 += v;
        }
        for (int v : nums2) {
            s2 += v;
        }

        for (int j = 0; j <= n; ++j) {
            if (s1 + s2 * j - fn[j] <= x) {
                return j;
            }
        }

        return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
