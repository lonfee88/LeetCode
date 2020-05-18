/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package LinkedList;

/**
 *
 *
 * ��ת�������£�
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
     * ��ת��λ�� m �� n ��������ʹ��һ��ɨ����ɷ�ת��

     ˵��:
     1 ��?m?��?n?�� �����ȡ�

     ʾ��:

     ����: 1->2->3->4->5->NULL, m = 2, n = 4
     ���: 1->4->3->2->5->NULL

     ��Դ�����ۣ�LeetCode��
     ���ӣ�https://leetcode-cn.com/problems/reverse-linked-list-ii
     ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
     */

    /**
     *
     * ����1 ���ݹ�ⷨ
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
        // �µ�head
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
        // �µ�head
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
     * ����2 ��ѭ���ⷨ
     *
     */

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // ���� next
            ListNode next = cur.next;
            // ��ת
            cur.next = pre;
            // ǰ��
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseListN(ListNode head, int n) {
        ListNode pre = null;
        ListNode cur = head;
        while (n-- > 0) {
            // ���� next
            ListNode tmp = cur.next;
            // ��ת
            cur.next = pre;
            // ǰ��
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