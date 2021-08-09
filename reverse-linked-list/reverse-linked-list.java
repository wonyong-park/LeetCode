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
    public ListNode reverseList(ListNode head) {
        
        if(head == null){
            return null;
        }
        
        Stack<ListNode> st = new Stack<>();
        
        while (head != null) {
            st.add(head);
            head = head.next;
        }

        ListNode result = st.peek();

        while (!st.isEmpty()) {
            ListNode pop = st.pop();
            
            if(st.isEmpty()){
                pop.next = null;
            }else{
                pop.next = st.peek();
            }
        }

        return result;
    }
}