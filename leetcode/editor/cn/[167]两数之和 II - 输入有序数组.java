//给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这
//两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.
//length 。 
//
// 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。 
//
// 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。 
//
// 你所设计的解决方案必须只使用常量级的额外空间。 
//
// 示例 1： 
//
// 
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。 
//
// 示例 2： 
//
// 
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
//解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。 
//
// 示例 3： 
//
// 
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
//解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= numbers.length <= 3 * 10⁴ 
// -1000 <= numbers[i] <= 1000 
// numbers 按 非递减顺序 排列 
// -1000 <= target <= 1000 
// 仅存在一个有效答案 
// 
//
// Related Topics 数组 双指针 二分查找 👍 1214 👎 0


import java.util.HashMap;

class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        solution.twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] twoSum(int[] numbers, int target) {
            int[] ans = new int[2];
            int n = numbers.length;
            int half = (n + 1) / 2;
            for (int i = 0; i < numbers.length; i++) {
                int low =i+1, high=n-1;
                while (low<=high){
                    int mid =(high-low)/2+low;
                    if (numbers[mid] == target - numbers[i]) {
                        return new int[]{i + 1, mid + 1};
                    } else if (numbers[mid] > target - numbers[i]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            return ans;
        }
        public int[] twoSumTowIndex(int[] numbers, int target) {
            int[] ans = new int[2];
            int n = numbers.length;
            int l=0,r=n-1;
            while (l<=r){
                if (numbers[l]+numbers[r]>target){
                    r--;
                }
                if (numbers[l]+numbers[r]==target){
                    ans[0]=l+1;
                    ans[1]=r+1;
                    return ans;
                }
                if (numbers[l]+numbers[r]<target){
                    l++;
                }
            }
            return ans;
        }

        public int[] twoSum1(int[] numbers, int target) {
            int[] ans = new int[2];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                map.put(numbers[i], i);
            }
            for (int i = 0; i < numbers.length; i++) {
                int number = numbers[i];
                if (map.containsKey(target - number)) {
                    ans[0] = i + 1;
                    ans[1] = map.get(target - number) + 1;
                    return ans;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
