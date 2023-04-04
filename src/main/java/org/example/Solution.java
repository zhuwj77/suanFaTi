//时间:2023/4/4 18:42

package org.example;

import javax.swing.*;

/*给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。

        数据范围： 0\leq n\leq10000≤n≤1000
        要求：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n) 。

        如当输入链表{1,2,3}时，
        经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。*/
public class Solution {
    public ListNode ReverseList(ListNode head){

        //寻找递归中止条件
        //1.head指向的结点为null
        //2.head指向的下一个结点为null
        //在这两种情况下，反转之后的结果还是他自己本身

        //不断的通过递归调用，知道无法递归下去，递归的最小粒度是在最后一个结点
        //应为到最后一个结点的时候，由于当前结点head的next节点是空，所以会直接返回head


        //比如原链表为1-->2-->3-->4-->5-->null
        //5-->4
        //第一次执行下面的代码的时候，head为4，那么head.next=5
        //那么head.next.next就是5.next，意思就是去设置5的下一个结点
        //等号右侧为head，意思就是设置5的下一个结点4

        //head原来的下一节点只想自己，所以head自己本身就不能在指向原来的下一节点了
        return head;
    }
}
