/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package LinkedList;

/**
 *
 *
 * 反转链表文章：
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
 *
 * @author longfei.wlf
 * @version $Id: ReverseLinkedList.java, v 0.1 2020-05-09 5:22 PM longfei.wlf Exp $$
 */
public class ReverseLinkedList {

    public class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

     说明:
     1 ≤?m?≤?n?≤ 链表长度。

     示例:

     输入: 1->2->3->4->5->NULL, m = 2, n = 4
     输出: 1->4->3->2->5->NULL

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     *
     * 方法1 ：递归解法
     *
     * @param head
     * @return
     */
    public ListNode reverseListRe(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        // 新的head
        ListNode cur = reverseListRe(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    private ListNode successor;

    public ListNode reverseListReN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        // 新的head
        ListNode cur = reverseListReN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return cur;
    }

    public ListNode reverseListReNBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseListReN(head, n);
        }
        head.next = reverseListBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     *
     * 方法2 ：循环解法
     *
     */

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 保存 next
            ListNode next = cur.next;
            // 反转
            cur.next = pre;
            // 前进
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseListN(ListNode head, int n) {
        ListNode pre = null;
        ListNode cur = head;
        while (n-- > 0) {
            // 保存 next
            ListNode tmp = cur.next;
            // 反转
            cur.next = pre;
            // 前进
            pre = cur;
            cur = tmp;
        }
        head.next = cur;
        return pre;
    }

    public ListNode reverseListBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseListN(head, n);
        }
        return reverseListBetween(head, m - 1, n - 1);
    }

}