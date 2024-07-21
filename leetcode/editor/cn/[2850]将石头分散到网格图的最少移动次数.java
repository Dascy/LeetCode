//给你一个大小为 3 * 3 ，下标从 0 开始的二维整数矩阵 grid ，分别表示每一个格子里石头的数目。网格图中总共恰好有 9 个石头，一个格子里可能会有
// 多个 石头。 
//
// 每一次操作中，你可以将一个石头从它当前所在格子移动到一个至少有一条公共边的相邻格子。 
//
// 请你返回每个格子恰好有一个石头的 最少移动次数 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,0],[1,1,1],[1,2,1]]
//输出：3
//解释：让每个格子都有一个石头的一个操作序列为：
//1 - 将一个石头从格子 (2,1) 移动到 (2,2) 。
//2 - 将一个石头从格子 (2,2) 移动到 (1,2) 。
//3 - 将一个石头从格子 (1,2) 移动到 (0,2) 。
//总共需要 3 次操作让每个格子都有一个石头。
//让每个格子都有一个石头的最少操作次数为 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[1,3,0],[1,0,0],[1,0,3]]
//输出：4
//解释：让每个格子都有一个石头的一个操作序列为：
//1 - 将一个石头从格子 (0,1) 移动到 (0,2) 。
//2 - 将一个石头从格子 (0,1) 移动到 (1,1) 。
//3 - 将一个石头从格子 (2,2) 移动到 (1,2) 。
//4 - 将一个石头从格子 (2,2) 移动到 (2,1) 。
//总共需要 4 次操作让每个格子都有一个石头。
//让每个格子都有一个石头的最少操作次数为 4 。
// 
//
// 
//
// 提示： 
//
// 
// grid.length == grid[i].length == 3 
// 0 <= grid[i][j] <= 9 
// grid 中元素之和为 9 。 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 35 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MinimumMovesToSpreadStonesOverGrid{
      public static void main(String[] args) {
           Solution solution = new MinimumMovesToSpreadStonesOverGrid().new Solution();
           solution.minimumMoves(new int[][]{{3,2,0},{0,1,0},{0,3,0}});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int minimumMoves(int[][] grid) {
              List<int[]> more = new ArrayList<int[]>();
              List<int[]> less = new ArrayList<int[]>();
              for (int i = 0; i < 3; ++i) {
                  for (int j = 0; j < 3; ++j) {
                      if (grid[i][j] > 1) {
                          for (int k = 2; k <= grid[i][j]; ++k) {
                              more.add(new int[]{i, j});
                          }
                      } else if (grid[i][j] == 0) {
                          less.add(new int[]{i, j});
                      }
                  }
              }

              int ans = Integer.MAX_VALUE;
              do {
                  int steps = 0;
                  for (int i = 0; i < more.size(); i++) {
                      steps += Math.abs(less.get(i)[0] - more.get(i)[0]) + Math.abs(less.get(i)[1] - more.get(i)[1]);
                  }
                  ans = Math.min(ans, steps);
              } while (nextPermutation(more));
              return ans;
          }

          public boolean nextPermutation(List<int[]> more) {
              int p = -1;
              for (int i = 0; i < more.size() - 1; i++) {
                  if (isLess(more.get(i), more.get(i + 1))) {
                      p = i;
                  }
              }
              if (p == -1) {
                  return false;
              }
              int q = -1;
              for (int j = p + 1; j < more.size(); j++) {
                  if (isLess(more.get(p), more.get(j))) {
                      q = j;
                  }
              }
              Collections.swap(more, p, q);
              int i = p + 1, j = more.size() - 1;
              while (i < j) {
                  Collections.swap(more, i, j);
                  i++;
                  j--;
              }
              return true;
          }

          public boolean isLess(int[] pair1, int[] pair2) {
              return pair1[0] < pair2[0] || (pair1[0] == pair2[0] && pair1[1] < pair2[1]);
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
