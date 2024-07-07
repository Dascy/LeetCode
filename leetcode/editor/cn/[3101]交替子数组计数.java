//给你一个二进制数组 nums 。 
//
// 如果一个子数组中 不存在 两个 相邻 元素的值 相同 的情况，我们称这样的子数组为 交替子数组 。 
//
// 返回数组 nums 中交替子数组的数量。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [0,1,1,1] 
// 
//
// 输出： 5 
//
// 解释： 
//
//
// 以下子数组是交替子数组：[0] 、[1] 、[1] 、[1] 以及 [0,1] 。 
//
// 示例 2： 
//
// 
// 输入： nums = [1,0,1,0] 
// 
//
// 输出： 10 
//
// 解释： 
//
//
// 数组的每个子数组都是交替子数组。可以统计在内的子数组共有 10 个。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 。 
// 
//
// Related Topics 数组 数学 👍 26 👎 0


import java.util.Arrays;

class CountAlternatingSubarrays{
      public static void main(String[] args) {
           Solution solution = new CountAlternatingSubarrays().new Solution();
           solution.numberOfAlternatingGroups(new int[]{0,1,0,1,0},3);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long sum=0;
        int cur=0;
        int pre=-1;
        for (int num : nums) {
            cur= (pre!=num)?cur+1:1;
            pre=num;
            sum+=cur;
        }
        return sum;
    }
          public int numberOfAlternatingGroups(int[] colors,int k) {
              int n = colors.length;
              int[] arr=new int[n+k-1];
              for (int i = 0; i < k+n-1 ; i++) {
                  if (i>=n){
                      arr[i]=colors[i-n];
                  }else {
                      arr[i]=colors[i];
                  }
              }
              int count=0;
              int num=0;
              int pre= colors[0];
              for (int i = 0; i < arr.length; i++) {
                  int now = arr[i];
                  if (now!=pre){
                      count++;
                  }else {
                      count=0;
                  }
                  if (count>=(k-1)){
                      num++;
                  }
                  pre=now;
              }
              return num;

          }

          public int numberOfAlternatingGroups(int[] colors) {
              int[] arr=new int[3];
              int num =0;
              for (int i = 0; i < colors.length; i++) {
                  arr[0]=colors[i];
                  if (i+1==colors.length){
                      arr[1]=colors[0];
                      arr[2]=colors[1];
                  }else if (i+2==colors.length){
                      arr[1]=colors[i+1];
                     arr[2]=colors[0];
                  }else {
                      arr[1]=colors[i+1];
                      arr[2]=colors[i+2];
                  }
                  if (arr[1]!=arr[2]&&arr[1]!=arr[0]){
                      num++;
                  }

              }
              return num;

          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
