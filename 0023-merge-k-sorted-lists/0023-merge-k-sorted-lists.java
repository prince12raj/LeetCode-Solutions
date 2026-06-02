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

class Heap {
    int[] heap;
    int size;
    int capacity;
    Heap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }
    int parent(int i) {
        return (i - 1) / 2;
    }
    void insert(int x) {
        if (size == capacity) return;

        heap[size] = x;
        int i = size;
        size++;
        while (i > 0 && heap[i] < heap[parent(i)]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }
    void heapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            heapify(smallest);
        }
    }
    int getMin() {
        return heap[0];
    }
    void deleteRoot() {
        if (size == 0) return;

        heap[0] = heap[size - 1];
        size--;
        heapify(0);
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int totalNodes = 0;
        for (ListNode head : lists) {
            while (head != null) {
                totalNodes++;
                head = head.next;
            }
        }
        Heap heap = new Heap(totalNodes);
        for (ListNode head : lists) {
            while (head != null) {
                heap.insert(head.val);
                head = head.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (heap.size > 0) {

            int minVal = heap.getMin();

            curr.next = new ListNode(minVal);
            curr = curr.next;

            heap.deleteRoot();
        }
        return dummy.next;
    }
}