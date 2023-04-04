//时间:2023/4/4 18:42

package org.example;
import java.util.Stack;

/*给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。

        数据范围： 0\leq n\leq10000≤n≤1000
        要求：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n) 。

        如当输入链表{1,2,3}时，
        经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。*/
public class Solution {

    //递归解法
    public static ListNode ReverseList1(ListNode head){

        //寻找递归中止条件
        //1.head指向的结点为null
        //2.head指向的下一个结点为null
        //在这两种情况下，反转之后的结果还是他自己本身
        if (head==null||head.next==null) return head;


        //不断的通过递归调用，知道无法递归下去，递归的最小粒度是在最后一个结点
        //应为到最后一个结点的时候，由于当前结点head的next节点是空，所以会直接返回head
        ListNode cur=ReverseList1(head.next);

        //比如原链表为1-->2-->3-->4-->5-->null
        //5-->4
        //第一次执行下面的代码的时候，head为4，那么head.next=5
        //那么head.next.next就是5.next，意思就是去设置5的下一个结点
        //等号右侧为head，意思就是设置5的下一个结点4
        head.next.next=head;

        //head原来的下一节点只想自己，所以head自己本身就不能在指向原来的下一节点了
        //否则会发生无限循环
        head.next=null;
        return cur;
    }

    //使用栈解决
    public static ListNode ReverseList2(ListNode head) {
        Stack<ListNode> stack= new Stack<>();
        //把链表节点全部摘掉放到栈中
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty())
            return null;
        ListNode node = stack.pop();
        ListNode dummy = node;
        //栈中的结点全部出栈，然后重新连成一个新的链表
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        //最后一个结点就是反转前的头结点，一定要让他的next
        //等于空，否则会构成环
        node.next = null;
        return dummy;
    }


    //双链表求解
    public static ListNode ReverseList3(ListNode head) {
        //新链表
        ListNode newHead = null;
        while (head != null) {
            //先保存访问的节点的下一个节点，保存起来
            //留着下一步访问的
            ListNode temp = head.next;
            //每次访问的原链表节点都会成为新链表的头结点，
            //其实就是把新链表挂到访问的原链表节点的
            //后面就行了
            head.next = newHead;
            //更新新链表
            newHead = head;
            //重新赋值，继续访问
            head = temp;
        }
        //返回新链表
        return newHead;
    }


    public static void main(String[] args) {
        ListNode node1=new ListNode(5);
        ListNode node2=new ListNode(4);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;
        ListNode head=node1;

        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println("------------------");
        head=ReverseList3(head);
        System.out.println(head.val);
        System.out.println(head.next.val);

    }
}
