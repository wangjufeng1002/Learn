package ac;

import org.junit.Test;

import java.util.*;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/6/23
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        stack2.clear();
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
      //  return (Integer)stack2.pop();
        return  0;
    }

   /* public static void main(String[] args) {
        //System.out.println(NumberOf1_2(3));
        System.out.println(Power(2,-3));
    }*/
    public static int NumberOf1_1(int n) {
        int num = 0;
        int index = 1;
        while(index != 0){
            if( (n & index )!= 0){
                num++;
            }
            index = index << 1;
        }
        return num;
    }
    public static int NumberOf1_2(int n) {
        String str =  Integer.toBinaryString(n);
        char[] chars = str.toCharArray();
        int num = 0 ;
        for(char c : chars){
            if(c == '1'){
                num ++;
            }
        }
        return  num;
    }
    public static  double Power(double base, int exponent) {
      return Math.pow(base,exponent);
    }
    public void reOrderArray(int [] array) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for(int t : array){
            if(t%2 == 0){
                a.add(t);
            }else{
                b.add(t);
            }
        }
        for(int i = 0 ; i< b.size() ;i++){
            array[i] = b.get(i);
        }
        int length = a.size();
        for(int i = 0; i< b.size() ;i++){
            array[i+length] = b.get(i);
        }
    }

    public ListNode ReverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = new ListNode(head.val);
        ListNode tempNode = null;
        ListNode tempHeadNode = head;
        while(tempHeadNode.next != null){
            tempNode =  newHead.next;
            newHead.next = new ListNode(tempHeadNode.next.val);
            newHead.next.next = tempNode;
            tempHeadNode = tempHeadNode.next;
        }
        tempHeadNode = newHead.next;
        return tempHeadNode;
    }
    @Test
    public void testReverseList(){
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode tempHead = head;
        for(int i =2 ;i<5;i++){
            ListNode node = new ListNode(i);
            tempHead.next = node;
            tempHead = node;
        }
        ListNode listNode = solution.ReverseList(head);
        while(listNode !=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    @Test
    public void testCopy(){
        int [] a = {1,2,3,4,5,6,7};
        for(int i : Arrays.copyOfRange(a,1,3)){
            System.out.println(i);
        }
    }

    TreeNode root = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return pRootOfTree;
        }
       return  null;
    }
    public TreeNode  Convert02(TreeNode pRootOfTree){
        TreeNode node;
        if(pRootOfTree.left == null && pRootOfTree.right == null ){
            if(root == null) {
                root = pRootOfTree;
            }
            return  pRootOfTree;
        }
        node = Convert02(pRootOfTree.left);
        node.right = pRootOfTree;
        node = Convert02(pRootOfTree.right);
        node.left = pRootOfTree;
        return  node;
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length / 2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int a : array){
            Integer x = map.get(a);
            if(x == null){
                map.put(a,1);
            }else{
                x+=1;
                if(x > len){
                    return a;
                }
                map.put(a,x);
            }
        }

        return 0;

    }
    @Test
    public void testInteger(){
        Integer a = 1111;

        String x= a.toString();
        x.toCharArray();
        System.out.println(x);
    }
    @Test
    public void testPrintMinNumber(){
        int [] a  = {3,321,32};
        Solution solution = new Solution();
        System.out.println(solution.PrintMinNumber(a));
    }
    public String PrintMinNumber(int [] numbers) {
        List<Integer> list = new ArrayList();
        for(int n : numbers){
            list.add(n);
        }
        Collections.sort(list,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                String str1 = o1 + ""+ o2;
                String str2 = o2 + ""+ o1;
                return str1.compareTo(str2);
            }
        });
        String result = "";
        for(Integer s :list ){
            result +=s;
        }
        return result;
    }
    @Test
    public void testFirstNotRepeatingChar(){
        int [] a  = {3,321,32};
        Solution solution = new Solution();
        System.out.println(solution.FirstNotRepeatingChar("google"));
    }
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length()==0){
            return -1;
        }
        int i = 0;
        while(str.length() != 0){
            char index = str.charAt(0);
            int strLen = str.length();
            str = str.replaceAll(String.valueOf(index),"");
            System.out.println(str + " :" + str.length());
            if(strLen - str.length() == 1){
                return  i;
            }
            i++;
        }
        return -1;
    }
}
