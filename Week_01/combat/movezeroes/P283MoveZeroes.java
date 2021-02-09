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


package combat.movezeroes;

//java:移动零
public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        solution.moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法一: 交换法
         * 解题思路:
         * 1. 定义j指针,去存储不为0的元素
         * 2. loop整个数组
         * 3. 判断当前i指针位置的元素如果不为 0时,进行位置交换.
         * 3.1 将j指针位置的元素移动到temp中, 将i指针位置的元素移动到j指针位置上, 将temp中的元素移动到i指针的位置上
         * 3.2 j++
         * 复杂度分析:
         * 时间复杂度: O(n)
         * 空间复杂度: O(1)
         *
         * @param nums
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
         * 解题思路:
         * 1. 定义j指针,去存储不为0的元素
         * 2. loop整个数组
         * 3. 判断当前i指针位置的元素如果不为 0, 就将当前元素, 放到j指针对应的位置上.
         * 3.1 如果 i != j 就将下标 i指针对应位置的元素设置为 0
         * 3.2 j++
         * 复杂度分析:
         * 时间复杂度: O(n)
         * 空间复杂度: O(1)
         *
         * @param nums
         */
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != 0) {
                    nums[j] = nums[i];
                    if (i != j) {
                        nums[i] = 0;
                    }
                    j++;
                }
            }
        }

        /**
         * 方法二:滚雪球
         *
         * @param nums
         */
        /*public void moveZeroes(int[] nums) {
            int snowBallSize = 0;
            for (int i = 0; i<nums.length;i++){
                if (nums[i]==0){
                    snowBallSize++;
                }else if (snowBallSize>0){
                    int t = nums[i];
                    nums[i] = 0;
                    nums[i-snowBallSize] =t;
                }
            }
        }*/
    }

//leetcode submit region end(Prohibit modification and deletion)

}
    