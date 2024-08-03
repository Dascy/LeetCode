//给你一个二维 boolean 矩阵 grid 。 
//
// 请你返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。 
//
// 注意： 
//
// 
// 如果 grid 中 3 个元素满足：一个元素与另一个元素在 同一行，同时与第三个元素在 同一列 ，那么这 3 个元素称为一个 直角三角形 。这 3 个元素
//互相之间不需要相邻。 
// 
//
// 
//
// 示例 1： 
//
// 
// 
// 
// 
// 0 
// 1 
// 0 
// 
// 
// 0 
// 1 
// 1 
// 
// 
// 0 
// 1 
// 0 
// 
// 
// 
// 
//
// 
// 
// 
// 0 
// 1 
// 0 
// 
// 
// 0 
// 1 
// 1 
// 
// 
// 0 
// 1 
// 0 
// 
// 
// 
//
// 
// 输入：grid = [[0,1,0],[0,1,1],[0,1,0]] 
// 
//
// 输出：2 
//
// 解释： 
//
// 有 2 个直角三角形。 
//
// 示例 2： 
//
// 
// 
// 
// 
// 1 
// 0 
// 0 
// 0 
// 
// 
// 0 
// 1 
// 0 
// 1 
// 
// 
// 1 
// 0 
// 0 
// 0 
// 
// 
// 
// 
//
// 
// 输入：grid = [[1,0,0,0],[0,1,0,1],[1,0,0,0]] 
// 
//
// 输出：0 
//
// 解释： 
//
// 没有直角三角形。 
//
// 示例 3： 
//
// 
// 
// 
// 
// 1 
// 0 
// 1 
// 
// 
// 1 
// 0 
// 0 
// 
// 
// 1 
// 0 
// 0 
// 
// 
// 
// 
//
// 
// 
// 
// 1 
// 0 
// 1 
// 
// 
// 1 
// 0 
// 0 
// 
// 
// 1 
// 0 
// 0 
// 
// 
// 
//
// 
// 输入：grid = [[1,0,1],[1,0,0],[1,0,0]] 
// 
//
// 输出：2 
//
// 解释： 
//
// 有两个直角三角形。 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 1000 
// 1 <= grid[i].length <= 1000 
// 0 <= grid[i][j] <= 1 
// 
//
// Related Topics 数组 哈希表 数学 组合数学 计数 👍 34 👎 0

  
   class RightTriangles{
      public static void main(String[] args) {
           Solution solution = new RightTriangles().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] column =new int[n];
        int[] row = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = grid[i][j];
                if (num==1){
                    column[i]++;
                    row[j]++;
                }
            }
        }
        long count =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = grid[i][j];
                if (num==1){
                    int a = column[i] - 1;
                    int b = row[j] - 1;
                   count+= a*b;
                }
            }
        }
       return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
