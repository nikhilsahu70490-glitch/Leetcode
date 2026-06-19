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
    public ListNode sortList(ListNode head) {
        // Base case: if the list is empty or has only one node, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Split the list into two halves
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null; // Break the list into two distinct parts
        
        // Step 2: Recursively sort both halves
        left = sortList(left);
        right = sortList(right);
        
        // Step 3: Merge the sorted halves
        return merge(left, right);
    }
    
    // Helper function to find the middle node using fast & slow pointers
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // fast starts ahead so slow stops at the exact mid-point
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // Helper function to merge two sorted lists
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        
        // Append remaining nodes
        tail.next = (list1 != null) ? list1 : list2;
        
        return dummyHead.next;
    }
}