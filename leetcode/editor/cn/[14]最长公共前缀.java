//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 3045 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution2024011805 {
    /**
     * create by: djz
     * description:  解题思路：公共前缀最长的长度是数组中最短的元素的长度。
     *              1.先找到最短元素
     *              2.按最短元素的长度进行反向遍历，依次切割该元素来获取字符串与数组中的其他元素进行比较。（startwith方法）
     *              3.首次遍历玩整个数组的字符串为最长共前缀
     * create time: 14:57 2021/11/5
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs==null||strs.length==0){
            return "";
        };
        String shortStr =strs[0];
//        for (String str : strs) {
//            if ( str.length()<shortStr.length()){
//                shortStr=str;
//            }
//        }
        for (int length = shortStr.length(); length > 0; length--) {
            String str = shortStr.substring(0, length);
            for (int i = 1; i < strs.length; i++) {
                boolean contains = strs[i].startsWith(str);
                if (!contains){
                    break;
                }
                if (i==strs.length-1){
                    return str;
                }
            }
            if (strs.length==1){
                return str;
            }
        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
