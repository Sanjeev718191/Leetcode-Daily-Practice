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
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        while(l1 != null){
            curr.next = l1;
            curr = curr.next;
            l1 = l1.next;
        }
        while(l2 != null){
            curr.next = l2;
            curr = curr.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
    private ListNode mergeListSort(ListNode[] lists, int s, int e){
        if(s == e) return lists[s];
        int m = (e+s)/2;
        ListNode l1 = mergeListSort(lists, s, m);
        ListNode l2 = mergeListSort(lists, m+1, e);
        return merge(l1, l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergeListSort(lists, 0, lists.length-1);
    }
}