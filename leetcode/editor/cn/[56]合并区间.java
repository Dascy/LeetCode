//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2354 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solutiondaily2024061801 {

    public static void main(String[] args) {
        merge(new int[][]{{2,6},{1,3},{8,10},{15,18}});
    }
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n==0){
            return new int[0][0];
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> list =new ArrayList<>();
        for (int i = 0; i < n;i++ ) {
            int[] interval = intervals[i];
            int r = interval[1];
            int l = interval[0];
            if (list.size()==0||list.get(list.size()-1)[1]<l){
               list.add(new int[]{l,r});
            }else {
                Integer a = list.get(list.size() - 1)[1];
                list.get(list.size()-1)[1]=Math.max(r,a);
            }
        }
        return list.toArray(new int[list.size()][]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
