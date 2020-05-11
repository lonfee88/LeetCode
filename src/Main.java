public class Main {

    public class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode newHeadPre = null;
        ListNode newHead = null;
        ListNode newTailNext = null;
        ListNode newTail = null;

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            if (i > m && i <= n) {
                // 保存next
                ListNode next = cur.next;

                // 反转
                cur.next = pre;

                // 前进
                pre = cur;
                cur = next;
            } else {
                // 记录反转前的节点
                if (i + 1 == m) {
                    newHeadPre = cur;
                    newTail = cur.next;
                }
                if (i - 1 == n) {
                    newTailNext = cur;
                    newHead = pre;
                }

                // 前进
                pre = cur;
                cur = cur.next;
            }
            i++;
        }
        if (newHeadPre != null) {
            newHeadPre.next = newHead;
        }
        if (newTail != null) {
            newTail.next = newTailNext;
        }
        return head;
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);

    }
}