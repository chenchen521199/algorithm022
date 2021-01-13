package work.removeduplicatesfromsortedarray;//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针 
// 👍 1757 👎 0

//java:删除排序数组中的重复项
public class P26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new P26RemoveDuplicatesFromSortedArray().new Solution();
        /**
         * 测试用例
         * new int[]{1, 1, 2, 2, 3, 3}
         */
        solution.removeDuplicates(new int[]{1, 1, 2, 2, 3, 3});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一
     * 思路: 1. 双指针法
     * 2. 定义两个指针,让当前指针q的值num[q]和下一个指针p的值num[p]做比较
     * 3. 将满足两个指针的值做比较,如果相同 num[q] = num[p], 则指针p向后移动一个位置 p++.
     * 4. 如果不同,num[q] != num[p], 则将指针p位置上的值 num[p] 赋值到指针p向后移动一步的位置上 num[p+1],
     *      并且指针q向后移动一个位置 q++,指针p向后移动一个位置 p++.
     * 5. 将不考虑重复的元素的数组进行返回 reture q+1
     * 时间复杂度分析: O(n)
     * 空间复杂度分析: O(1)
     */
/*class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int q = 0;
        int p = 1;
        while (p<nums.length){
            if (nums[q]!=nums[p]){
                nums[q+1] = nums[p];
                q++;
            }
            p++;
        }
        return q+1;
    }
}*/

    /**
     * 方法二
     * 思路: 1. 双指针法
     * 2. 定义两个指针,让当前指针q的值num[q]和下一个指针p的值num[p]做比较
     * 3. 将满足两个指针的值做比较,如果相同 num[q] = num[p], 则指针p向后移动一个位置 p++.
     * 4. 如果不同,num[q] != num[p], 则将指针p位置上的值 num[p] 赋值到指针p向后移动一步的位置上 num[p+1],
     *      并且指针q向后移动一个位置 q++,指针p向后移动一个位置 p++.
     *      4.1 如果 p - q > 1 表示 p 与 q的位置是不相邻的. 位置相邻的两个不同的元素
     * 5. 将不考虑重复的元素的数组进行返回 reture q+1
     * 时间复杂度分析: O(n)
     * 空间复杂度分析: O(1)
     */
    /*class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int q = 0;
            for (int p = 1; p < nums.length; p++) {
                if (nums[q] != nums[p]) {
                    if (p - q > 1) {
                        nums[q + 1] = nums[p];
                    }
                     q++;
                }
            }
            return q + 1;
        }
    }*/

    /**
     * 方法三
     * 思路:1 双指针法
     * 2. 定义两个指针 count / i
     * 3. 判断 如果 count < 1 , 将i位置的元素nums[i] 赋值给count位置的元素 nums[count]. count位置向后移动一个位置 count ++;
     * 4. 判断 如果 当前i位置的元素nums[i] 大于count-1位置的元素(count位置向前一个位置) nums[count-1]. 也将i位置的元素nums[i] 赋值给count位置的元素 nums[count]. count的位置向后移动一个位置, count ++;
     * 5. 返回count结构
     */
   /* class Solution {
        public int removeDuplicates(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (count < 1 || nums[i] > nums[count - 1]) {
                    nums[count++] = nums[i];
                }
            }
            return count;
        }
    }*/
    /*class Solution {
        public int removeDuplicates(int[] nums) {
            int count = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > nums[count - 1]) {
                    if (nums[count] != nums[i]) {
                        nums[count] = nums[i];
                    }
                    count++;
                }
            }
            return count;
        }
    }*/
    // ----------------------------------五毒神掌 第一遍--------------------------------------------
    /*class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int i = 0;
            int j = 1;
            while (j < nums.length) {
                if (nums[i] != nums[j]) {
                    nums[i + 1] = nums[j];
                    i++;
                }
                j++;
            }
            return i + 1;
        }
    }*/
    /*class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int j = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[j] != nums[i]) {
                    if(i-j>1){
                        nums[j + 1] = nums[i];
                    }
                    j++;
                }
            }
            return j + 1;
        }
    }*/

    // ----------------------------------五毒神掌 第三遍--------------------------------------------
   /* class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int i = 0;
            int j = 1;
            while (j < nums.length) {
                if (nums[i] != nums[j]) {
                    nums[i+1] = nums[j];
                    i++;
                }
                j++;
            }
            return i + 1;
        }
    }*/
    /*class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int j = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i]!=nums[j]){
                    if (i-j>1){
                        nums[j+1]=nums[i];
                    }
                    j++;
                }
            }
            return j+1;
        }
    }*/
    // ----------------------------------五毒神掌 第四遍--------------------------------------------
    /*class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int j = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[j] != nums[i]) {
                    if (i - j > 1) {
                        nums[j + 1] = nums[i];
                    }
                     j++;
                }
            }
            return j + 1;
        }
    }*/

    /*class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int j = 0;
            int i = 1;
            while (i < nums.length) {
                if (nums[j] != nums[i]) {
                    if (i - j > 1) {
                        nums[j + 1] = nums[i];
                    }
                    j++;
                }
                i++;
            }
            return j+1;
        }
    }*/
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[count - 1]) {
                    if (nums[i]!=nums[count]) nums[count] = nums[i];
                    count++;
                }
            }
            return count;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
