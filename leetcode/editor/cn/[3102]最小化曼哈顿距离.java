//给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。 
//
// 两点之间的距离定义为它们的曼哈顿距离。 
//
// 请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[3,10],[5,15],[10,2],[4,4]]
//输出：12
//解释：移除每个点后的最大距离如下所示：
//- 移除第 0 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间，为 |5 - 10| + |15 - 2| = 18 。
//- 移除第 1 个点后，最大距离在点 (3, 10) 和 (10, 2) 之间，为 |3 - 10| + |10 - 2| = 15 。
//- 移除第 2 个点后，最大距离在点 (5, 15) 和 (4, 4) 之间，为 |5 - 4| + |15 - 4| = 12 。
//- 移除第 3 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间的，为 |5 - 10| + |15 - 2| = 18 。
//在恰好移除一个点后，任意两点之间的最大距离可能的最小值是 12 。
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[1,1],[1,1]]
//输出：0
//解释：移除任一点后，任意两点之间的最大距离都是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= points.length <= 10⁵ 
// points[i].length == 2 
// 1 <= points[i][0], points[i][1] <= 10⁸ 
// 
//
// Related Topics 几何 数组 数学 有序集合 排序 👍 17 👎 0


import java.util.TreeMap;

class MinimizeManhattanDistances{
      public static void main(String[] args) {
           Solution solution = new MinimizeManhattanDistances().new Solution();
           solution.minimumDistance(new int[][]{{3,10},{5,15},{10,2},{4,4}});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDistance(int[][] points) {
        //提示 曼哈顿距离 可以转换为切比雪夫距离
        //  d(a,b) = max(|x1-y1-(x2-y2)|,|(x1+y1)-(x2+y2)|);

        TreeMap<Integer,Integer> sx =new TreeMap<>();
        TreeMap<Integer,Integer> sy =new TreeMap<>();

        for (int[] p : points) {
            sx.put(p[0]-p[1],sx.getOrDefault(p[0]-p[1],0)+1);
            sy.put(p[0]+p[1],sy.getOrDefault(p[0]+p[1],0)+1);
        }

        int res =Integer.MAX_VALUE;

        for (int[] p : points) {
            //为0移除该点
            sx.put(p[0] - p[1], sx.get(p[0] - p[1]) - 1);
            if (sx.get(p[0]-p[1])==0){
                sx.remove(p[0]-p[1]);
            }
            sy.put(p[0] + p[1], sy.get(p[0] + p[1]) - 1);
            if (sy.get(p[0] + p[1]) == 0) {
                sy.remove(p[0] + p[1]);
            }
            //公式  max(|x1-y1-(x2-y2)|,|(x1+y1)-(x2+y2)|);
            res = Math.min(res, Math.max(sx.lastKey() - sx.firstKey(), sy.lastKey() - sy.firstKey()));
            System.out.println(sx.lastKey()+"\n"+sx.firstKey());
            sx.put(p[0] - p[1], sx.getOrDefault(p[0] - p[1], 0) + 1);
            sy.put(p[0] + p[1], sy.getOrDefault(p[0] + p[1], 0) + 1);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
