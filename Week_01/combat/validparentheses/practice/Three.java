//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2119 👎 0


package combat.validparentheses.practice;

import java.util.Stack;

//java:有效的括号
public class Three {
    public static void main(String[] args) {
        Solution solution = new Three().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 方法一： 使用栈去解决
         * 判断栈顶括号是否和集合中的括号满足对称关系
         *
         * @param s
         * @return
         */
        public boolean isValid1(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') stack.push(')');
                else if (c == '{') stack.push('}');
                else if (c == '[') stack.push(']');
                else if (stack.isEmpty() || stack.pop() != c) return false;
            }
            return stack.isEmpty();
        }

        /**
         * @param s
         * @return
         */
        public boolean isValid2(String s) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                int q = "(){}[]".indexOf(s.substring(i, i + 1));
                if (q % 2 == 1) {
                    if (stack.isEmpty() || stack.pop() != q-1) return false;
                } else stack.push(q);
            }
            return stack.isEmpty();
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
    