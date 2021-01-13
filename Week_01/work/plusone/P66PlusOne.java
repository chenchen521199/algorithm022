//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 597 👎 0


package work.plusone;

//java:加一
public class P66PlusOne {
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一
     * 思路: 1. 考虑最后一个数组元素 +1 后为0的情况,和 +1 后不为0的情况.
     *       2. 如果 +1 后数组最后一个元素不为0时,则直接将 +1 后的元素赋值 return.
     *       3. 如果 +1 后数组最后一个元素为0时, 则进行倒数第二个元素+1操作.
     *       4. 如果数组第一个元素为0,则扩充数组并设置数组第一个元素为1，并返回结果.
     *  时间复杂度分析:
     *  空间复杂度分析:
     */
/*    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length -1; i>=0 ; i--){
                digits[i]++;
                digits[i] = digits[i]%10;
                if (digits[i] != 0) return digits;
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }*/

    /**
     * 方法二
     * 思路: 1.考虑最后一个数组元素 +1 后为0的情况,和 +1 后不为0的情况.
     * 2.如果当前数组最后一个元素为9，则将数组最后一个元素设置为0。否则当前数组元素+1，并返回结果.
     * 3.如果数组第一个元素为0,则扩充数组并设置数组第一个元素为1，并返回结果.
     */
    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    return digits;
                }
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}