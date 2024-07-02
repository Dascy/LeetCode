//给你一个整数数组 nums。 
//
// 返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [4,2,9,5,3] 
// 
//
// 输出： 3 
//
// 解释： nums[1]、nums[3] 和 nums[4] 是质数。因此答案是 |4 - 1| = 3。 
//
// 示例 2： 
//
// 
// 输入： nums = [4,8,2,8] 
// 
//
// 输出： 0 
//
// 解释： nums[2] 是质数。因为只有一个质数，所以答案是 |2 - 2| = 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁵ 
// 1 <= nums[i] <= 100 
// 输入保证 nums 中至少有一个质数。 
// 
//
// Related Topics 数组 数学 数论 👍 18 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionDaily20240702 {

    public int maximumPrimeDifference(int[] nums){
        Set<Integer> set =new HashSet<>(Arrays.asList( 2, 3, 5, 7, 11,
                13, 17, 19, 23, 29,
                31, 37, 41, 43, 47,
                53, 59, 61, 67, 71,
                73, 79, 83, 89, 97));
        int first=-1;
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                if (first==-1){
                    first=i;
                }else {
                    max=Math.max(max,i-first);
                }
            }
        }

       return max;
    }

//    public int maximumPrimeDifference(int[] nums) {
//        int n = nums.length;
//        int[] arr= new int[n];
//        for (int i = 0; i < nums.length; i++) {
//            if (isPrimeNumber(nums[i])){
//                arr[i]=1;
//            }else {
//                arr[i]=0;
//            }
//        }
//        int i=0; int j=n-1;
//        int max=0;
//        while (i<=j){
//            if (arr[i]!=1){
//                i++;
//            }
//            if (arr[j]!=1){
//                j--;
//            }
//            if (arr[i]==arr[j]&&arr[i]==1){
//                max=j-i;
//                break;
//            }
//        }
//        return max;
//    }
//    public boolean isPrimeNumber(int num){
//        if (num<3){
//            return num>1;
//        }
//        for (int i = 2; i <num; i++) {
//            if (num%i==0){
//                return false;
//            }
//        }
//        return true;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
