//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1685 👎 0


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2024011303 {
    public  int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ret =new int[101];
        int[] tmp =new int[n];
        Arrays.fill(ret,Integer.MAX_VALUE);
        for (int i = n-1; i >= 0; i--) {
            int warmIndex = Integer.MAX_VALUE;
            for (int t = temperatures[i]+1; t <= 100; t++) {
                if (ret[t]<warmIndex){
                    warmIndex=ret[t];
                }
            }
            if (warmIndex<Integer.MAX_VALUE){
                tmp[i]=warmIndex-i;
            }
            ret[temperatures[i]]=i;
        }
        return tmp;
    }

    public static void main(String[] args) {
        boolean[][] dp = new boolean[3][3];
        System.out.println(Arrays.toString(dp[0]));
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack);
        System.out.println(stack.peek());
    }

}
//leetcode submit region end(Prohibit modification and deletion)
