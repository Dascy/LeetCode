//给你一个下标从 1 开始、大小为 m x n 的整数矩阵 mat，你可以选择任一单元格作为 起始单元格 。 
//
// 从起始单元格出发，你可以移动到 同一行或同一列 中的任何其他单元格，但前提是目标单元格的值 严格大于 当前单元格的值。 
//
// 你可以多次重复这一过程，从一个单元格移动到另一个单元格，直到无法再进行任何移动。 
//
// 请你找出从某个单元开始访问矩阵所能访问的 单元格的最大数量 。 
//
// 返回一个表示可访问单元格最大数量的整数。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：mat = [[3,1],[3,4]]
//输出：2
//解释：上图展示了从第 1 行、第 2 列的单元格开始，可以访问 2 个单元格。可以证明，无论从哪个单元格开始，最多只能访问 2 个单元格，因此答案是 2 。
// 
// 
//
// 示例 2： 
//
// 
//
// 输入：mat = [[1,1],[1,1]]
//输出：1
//解释：由于目标单元格必须严格大于当前单元格，在本示例中只能访问 1 个单元格。 
// 
//
// 示例 3： 
//
// 
//
// 输入：mat = [[3,1,6],[-9,5,7]]
//输出：4
//解释：上图展示了从第 2 行、第 1 列的单元格开始，可以访问 4 个单元格。可以证明，无论从哪个单元格开始，最多只能访问 4 个单元格，因此答案是 4 。
//  
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 10⁵ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
//
// Related Topics 记忆化搜索 数组 哈希表 二分查找 动态规划 矩阵 有序集合 排序 👍 66 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionDaily2024061901 {


    //动态规划法解决。 dp[i][j] 表示（i，j）为起点可以移动到最大步数。
    //以i,j为目标点，可以从行 或者列上来移动。 可以得到 mat[i][j`]<mat[i][j] 或者 mat[i`][j]<mat[i][j]
    //  dp[i][j] = max(dp[i][j`]+1)  dp[i][j] = max(dp[i`][j]+1)
    //所以使用 row[]  col[] 分别记录 行与列可以移动到最大步数
    public int maxIncreasingCells(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        //row 表示每一行能递增到最大数
        //col 表示每一列能递增到最大数
        int[] row =new int[n];
        int[] col =new int[m];
        //存放每个数值对应到坐标
        HashMap<Integer, List<int[]>> map =new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.putIfAbsent(mat[i][j],new ArrayList<>());
                map.get(mat[i][j]).add(new int[]{i,j});
            }
        }
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (Integer key : keys) {
            List<int[]> pos = map.get(key);
            ArrayList<Integer> res = new ArrayList<>();
            for (int[] index : pos) {
               res.add(Math.max(row[index[0]],col[index[1]])+1);
            }

            for (int i = 0; i < pos.size(); i++) {
                int[] arr = pos.get(i);
                int d = res.get(i);
                row[arr[0]] = Math.max(row[arr[0]], d);
                col[arr[1]] = Math.max(col[arr[1]], d);
            }

        }
        return Arrays.stream(row).max().getAsInt();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
