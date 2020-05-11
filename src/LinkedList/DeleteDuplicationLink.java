package LinkedList;

/*

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