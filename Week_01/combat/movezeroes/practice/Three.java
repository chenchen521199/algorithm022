//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 913 👎 0


package combat.movezeroes.practice;

//java:移动零
public class Three {
    public static void main(String[] args) {
        Solution solution = new Three().new Solution();
        solution.moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
    //==========================五毒神掌 第三遍================================================

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法一: 交换法
         */
       /* public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j++;
                }
            }
        }*/
        /**
         * 方法三:
         */
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0;i<nums.length;++i){
                if (nums[i]!=0){
                    nums[j] = nums[i];
                    if (i!=j){
                        nums[j] = 0;
                    }
                    j++;
                }
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
    