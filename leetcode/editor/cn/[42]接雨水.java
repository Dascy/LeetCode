//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4972 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution2024011804 {

    public int trap1(int[] height){
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMax=new int[n];
        int[] rightMax =new int[n];
        leftMax[0]=height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i]= Math.max(rightMax[i+1],height[i]);
        }
        int sum =0;
        for (int i = 0; i < n; i++) {
            sum+= Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
