/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode dummy = result;

        while (l1!= null || l2 != null) {

            if (l1 == null) {
                dummy.next = new ListNode(l2.val);
                dummy = dummy.next;
                l2 = l2.next;
                continue;
            }

            if (l2 == null) {
                dummy.next = new ListNode(l1.val);
                dummy = dummy.next;
                l1 = l1.next;
                continue;
            }

            if (l1.val < l2.val) {
                dummy.next = new ListNode(l1.val);
                dummy = dummy.next;
                l1 = l1.next;
            }else{
                dummy.next = new ListNode(l2.val);
                dummy = dummy.next;
                l2 = l2.next;
            }

        }

        return result.next;
    }
}