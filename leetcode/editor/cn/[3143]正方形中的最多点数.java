//给你一个二维数组 points 和一个字符串 s ，其中 points[i] 表示第 i 个点的坐标，s[i] 表示第 i 个点的 标签 。 
//
// 如果一个正方形的中心在 (0, 0) ，所有边都平行于坐标轴，且正方形内 不 存在标签相同的两个点，那么我们称这个正方形是 合法 的。 
//
// 请你返回 合法 正方形中可以包含的 最多 点数。 
//
// 注意： 
//
// 
// 如果一个点位于正方形的边上或者在边以内，则认为该点位于正方形内。 
// 正方形的边长可以为零。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
// 输入：points = [[2,2],[-1,-2],[-4,4],[-3,1],[3,-3]], s = "abdca" 
// 
//
// 输出：2 
//
// 解释： 
//
// 边长为 4 的正方形包含两个点 points[0] 和 points[1] 。 
//
// 示例 2： 
//
// 
//
// 
// 输入：points = [[1,1],[-2,-2],[-2,2]], s = "abb" 
// 
//
// 输出：1 
//
// 解释： 
//
// 边长为 2 的正方形包含 1 个点 points[0] 。 
//
// 示例 3： 
//
// 
// 输入：points = [[1,1],[-1,-1],[2,-2]], s = "ccd" 
// 
//
// 输出：0 
//
// 解释： 
//
// 任何正方形都无法只包含 points[0] 和 points[1] 中的一个点，所以合法正方形中都不包含任何点。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, points.length <= 10⁵ 
// points[i].length == 2 
// -10⁹ <= points[i][0], points[i][1] <= 10⁹ 
// s.length == points.length 
// points 中的点坐标互不相同。 
// s 只包含小写英文字母。 
// 
//
// Related Topics 数组 哈希表 字符串 二分查找 排序 👍 20 👎 0


import java.util.*;

class MaximumPointsInsideTheSquare{
      public static void main(String[] args) {
           Solution solution = new MaximumPointsInsideTheSquare().new Solution();
           String str="[[-21,-85],[41,-98],[16,39],[-78,74],[44,-77],[8,74],[16,41],[-3,-7],[-10,29],[-28,-53]]";
          String replace = str.replace("[", "{").replace("]", "}");
          System.out.println(replace);
          solution.maxPointsInsideSquare(new int[][]{{-21,-85},{41,-98},{16,39},{-78,74},{44,-77},{8,74},{16,41},{-3,-7},{-10,29},{-28,-53}},"feifjididf");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = s.length();
        int[] cnt = new int[26];
        Arrays.fill(cnt,1000000001);
        int min =1000000001;
        //求出最大半径
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            int x = points[i][0];
            int y = points[i][1];
            int j = c - 'a';
            int r = Math.max(Math.abs(x), Math.abs(y));
            if (r<cnt[j]){
                min=Math.min(min,cnt[j]);
                cnt[j]=r;
            }else if (r<min){
                min=r;
            }
        }
        int count=0;
        for (int i = 0; i < cnt.length; i++) {
            int r = cnt[i];
            if (min>r){
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
