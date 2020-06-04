package LinkedList;

/*

题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta
/coding-interviews/question-ranking&from=cyc_github

 思路：添加一个虚拟头结点


}
*/
public class DeleteDuplicationLink {

    private class ListNode {
        int      val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode deleteDuplication(ListNode pHead) {
            ListNode head = new ListNode(-1);
            head.next = pHead;

            ListNode pre = head, cur = pHead;
            while (cur != null) {
                if (cur.next != null && cur.val == cur.next.val) {
                    while (cur.next != null && cur.val == cur.next.val) {
                        cur = cur.next;
                    }
                    pre.next = cur.next;
                    cur = cur.next;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
            return head.next;
        }
    }
}