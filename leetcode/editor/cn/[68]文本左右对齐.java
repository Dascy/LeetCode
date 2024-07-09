//给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
// 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 注意: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: words = ["This", "is", "an", "example", "of", "text", "justification."], 
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 
//输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 
//输入:words = ["Science","is","what","we","understand","well","enough","to",
//"explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 2
//0
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= words.length <= 300 
// 1 <= words[i].length <= 20 
// words[i] 由小写英文字母和符号组成 
// 1 <= maxWidth <= 100 
// words[i].length <= maxWidth 
// 
//
// Related Topics 数组 字符串 模拟 👍 428 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TextJustification{
      public static void main(String[] args) {
           Solution solution = new TextJustification().new Solution();
           solution.fullJustify(new String[]{"This","is", "an", "example", "of", "text", "justification."},16);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public List<String> fullJustify(String[] words, int maxWidth) {
              List<String> ans = new ArrayList<String>();
              int right = 0, n = words.length;
              while (true) {
                  int left =right; //标记当前在 word中的位置
                  int subL =0;
                  while (right<n&&subL+words[right].length()+right-left<=maxWidth){
                       subL+=words[right++].length();
                  }
                  if (right==n){
                      //最后一行。
                      StringBuffer sb = join(words,left,right," ");
                      sb.append(blank(maxWidth-sb.length()));
                      ans.add(sb.toString());
                      return ans;
                  }
                  int numWord= right-left;
                  int numSpace= maxWidth-subL;
                  if (numWord==1){
                      StringBuffer sb =  new StringBuffer(words[left]);
                      sb.append(blank(numSpace));
                      ans.add(sb.toString());
                      continue;
                  }
                  int avgSpace = numSpace/(numWord-1);
                  int extSpace = numSpace%(numWord-1);
                  StringBuffer sb = new StringBuffer();
                  sb.append(join(words,left,left+extSpace+1,blank(avgSpace+1)));
                  sb.append(blank(avgSpace));
                  sb.append(join(words, left + extSpace + 1, right, blank(avgSpace))); // 拼接其余单词
                  ans.add(sb.toString());


              }
          }

          // blank 返回长度为 n 的由空格组成的字符串
          public String blank(int n) {
              StringBuffer sb = new StringBuffer();
              for (int i = 0; i < n; ++i) {
                  sb.append(' ');
              }
              return sb.toString();
          }

          // join 返回用 sep 拼接 [left, right) 范围内的 words 组成的字符串
          public StringBuffer join(String[] words, int left, int right, String sep) {
              StringBuffer sb = new StringBuffer(words[left]);
              for (int i = left + 1; i < right; ++i) {
                  sb.append(sep);
                  sb.append(words[i]);
              }
              return sb;
          }
      }


//leetcode submit region end(Prohibit modification and deletion)

  }
