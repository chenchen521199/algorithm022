//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 782 👎 0


package combat.minstack.practice;

import java.util.Stack;

//java:最小栈
public class One {
    public static void main(String[] args) {
        Solution solution = new One().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

    }

    class MinStackCase2{
        private NodeCase2 head;

        public MinStackCase2(){}

        public void push(int x){
            if (head == null){
                head = new NodeCase2(x,x);
            }else {
                head = new NodeCase2(x,Math.min(x,head.min),head);
            }
        }
        //pop操作时, 删除链表的头节点
        public void pop(){ head = head.next;}
        //top 操作时, 返回节点中存储最小值
        public int top(){ return head.val;}
        //getMin操作时, 返回节点中存储最小值;
        public int getMin(){return head.min;}
    }

    class NodeCase2{
        int val;
        int min;
        NodeCase2 next;

        public NodeCase2(int val, int min) {
            this.val = val;
            this.min = min;
        }

        public NodeCase2(int val, int min, NodeCase2 next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }



    /**
     * 方法二:使用Stack<Node>
     */
    class MinStackCase{
        private Stack<NodeCase> stack;
        public MinStackCase(){
            stack = new Stack<>();
        }
        public void push(int x){
            if (stack.isEmpty()){
                stack.push(new NodeCase(x,x));
            }else {
                stack.push(new NodeCase(x,Math.min(x,stack.peek().min)));
            }
        }
        public void pop(){
            stack.pop();
        }
        public int top(){
            return stack.peek().val;
        }
        public int getMin(){return stack.peek().min;}
    }

    class NodeCase{
        int val;
        int min;
        public NodeCase(int val, int min){
            this.val = val;
            this.min = min;
        }
    }


    /**
     * 方法一 使用辅助栈
     */
    class MinStack{
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MinStack(){
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x){
            dataStack.push(x);
            if (minStack.isEmpty() || x<=minStack.peek()){
                minStack.push(x);
            }
        }

        public void pop(){
            int x = dataStack.pop();
            if(x==minStack.peek()){
                minStack.pop();
            }
        }

        public int top(){
            return dataStack.peek();
        }
        public int getMin(){
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
    