package com.fovoy.Algorithms;

import com.fovoy.Algorithms.model.ListNode;

import java.util.*;

/**
 * Created by zxz.zhang on 2017/3/4.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int s = target - nums[i];
            if (map.containsKey(s)) {
                return new int[]{map.get(s), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum");
    }

    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            int sum = l1.getValue() + l2.getValue() + add;
            cur.setNext(new ListNode(sum % 10));
            cur = cur.getNext();
            add = sum / 10;
            l1 = l1.getNext();
            l2 = l2.getNext();
        }
        if (add != 0) {
            cur.setNext(new ListNode(add));
        }
        return head.getNext();
    }

    public ListNode helper(ListNode l1, ListNode l2, int add) {
        if (l1 == null && l2 == null) {
            return add == 0 ? null : new ListNode(add);
        }
        if (l1 == null && l2 != null) {
            l1 = new ListNode(0);

        }
        if (l2 == null && l1 != null) {
            l2 = new ListNode(0);
        }
        int sum = l1.getValue() + l1.getValue() + add;
        ListNode cur = new ListNode(sum % 10);
        cur.setNext(helper(l1.getNext(), l2.getNext(), sum / 10));
        return cur;
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i++));
                ans = Math.max(ans, i - j);
            } else {
                set.remove(s.charAt(j++));
            }
        }
        return ans;
    }

    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int total = m+n;
        if (total%2 != 0)
            return (double) findKth(A, 0, m-1, B, 0, n-1, total/2+1);//k传得是第k个，index实则k-1
        else {
            double x = findKth(A, 0, m-1, B, 0, n-1, total/2);//k传得是第k个，index实则k-1
            double y = findKth(A, 0, m-1, B, 0, n-1, total/2+1);//k传得是第k个，index实则k-1
            return (double)(x+y)/2;
        }
    }

    public static int findKth(int[] A, int astart, int aend, int[] B, int bstart, int bend, int k) {
        int m = aend - astart + 1;
        int n = bend - bstart + 1;

        if(m>n)
            return findKth(B,bstart,bend,A,astart,aend,k);
        if(m==0)
            return B[k-1];
        if(k==1)
            return Math.min(A[astart],B[bstart]);

        int partA = Math.min(k/2,m);
        int partB = k - partA;
        if(A[astart+partA-1] < B[bstart+partB-1])
            return findKth(A,astart+partA,aend,B,bstart,bend,k-partA);
        else if(A[astart+partA-1] > B[bstart+partB-1])
            return findKth(A,astart,aend,B,bstart+partB,bend,k-partB);
        else
            return A[astart+partA-1];
    }

    public static void main(String[] args) {
        System.out.println(Solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    }

}
