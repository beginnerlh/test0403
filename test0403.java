/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/
package lianxi0403;

public class test0403 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int count = 0;//每位之和
        int s = 0;//进位

        while(cur1.next != null && cur2.next != null){//加到其中有一个链表剩一位，或者两个链表都只剩一位
            count = cur1.val + cur2.val + s;
            if(count > 9){
                cur1.val = count % 10 ;
                cur2.val = count % 10 ;
                s = 1;
            }else{
                cur1.val = count;
                cur2.val = count;
                s = 0;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;

        }

        if(cur1.next == null && cur2.next == null){ //当两个链表都只剩一位时
            count = cur1.val + cur2.val +s;
            if(count > 9)
            {
                cur1.val = count % 10;
                cur2.val = count % 10;
                s = 1;
            }else{
                cur1.val = count ;
                cur2.val = count ;
                s = 0;
            }
            if(s == 1){  //说明最后两个数产生了进位，需要扩充链表。
                ListNode tmp = new ListNode(1);
                cur1.next = tmp;
                return l1;
            }
            return l1;
        }

        if(cur1.next == null){  //cur1链表剩一位
            count = cur1.val + cur2.val + s ;
            cur2.val = cur1.val + cur2.val;
            if(count < 10){  //cur1的最后一位加cur2的一位 没产生进位，直接返回
                cur2.val = count;
                return l2;
            }
            while(cur2.next != null){  //因为有进位，需要再把cur2的剩余数计算 直到最后一位
                count =  cur2.val + s;
                if(count > 9){
                    cur2.val = count % 10 ;
                    s = 1;
                } else{
                    cur2.val = count;
                    s = 0;
                }
                cur2 = cur2.next;
            }
            if(cur2.val + s > 9){  //判断cur2 最后一位是否产生进位
                cur2.val = (cur2.val + s) % 10;
                s = 1;
            }else{
                cur2.val = cur2.val +s;
                s = 0;
            }
            if(s == 1){  //产生进位，扩充链表
                ListNode tmp = new ListNode(1);
                cur2.next = tmp;
                return l2;
            }
            return l2;
        }else{  //cur2链表剩一位
            count = cur1.val + cur2.val + s;
            cur1.val = cur2.val + cur1.val;
            if(count < 10){ //cur2的最后一位加cur1的一位 没产生进位，直接返回
                cur1.val = count;
                return l1;
            }
            while(cur1.next != null){ //因为有进位，需要再把cur1的剩余数计算 直到最后一位
                count =  cur1.val + s;
                if(count > 9){
                    cur1.val = count % 10 ;
                    s = 1;
                } else{
                    cur1.val = count;
                    s = 0;
                }
                cur1 = cur1.next;
            }
            if(cur1.val + s > 9){  //判断cur1 最后一位是否产生进位
                cur1.val = (cur1.val + s) % 10;
                s = 1;
            }else{
                cur1.val = cur1.val +s;
                s = 0;
            }
            if(s == 1){  //产生进位，扩充链表
                ListNode tmp = new ListNode(1);
                cur1.next = tmp;
                return l1;
            }
        }
        return l1;
    }



}
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
