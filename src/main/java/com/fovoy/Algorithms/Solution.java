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
        int total = m + n;
        if (total % 2 != 0)
            return (double) findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);
        else {
            double x = findKth(A, 0, m - 1, B, 0, n - 1, total / 2);
            double y = findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);
            return (double) (x + y) / 2;
        }
    }

    public static int findKth(int[] A, int astart, int aend, int[] B, int bstart, int bend, int k) {
        int m = aend - astart + 1;
        int n = bend - bstart + 1;

        if (m > n)
            return findKth(B, bstart, bend, A, astart, aend, k);
        if (m == 0)
            return B[k - 1];
        if (k == 1)
            return Math.min(A[astart], B[bstart]);

        int partA = Math.min(k / 2, m);
        int partB = k - partA;
        if (A[astart + partA - 1] < B[bstart + partB - 1])
            return findKth(A, astart + partA, aend, B, bstart, bend, k - partA);
        else if (A[astart + partA - 1] > B[bstart + partB - 1])
            return findKth(A, astart, aend, B, bstart + partB, bend, k - partB);
        else
            return A[astart + partA - 1];
    }

    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len2 = expandAroundCenter(s, i, i);
            int len1 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static String convert(String s, int nRows) {
        int len = s.length();
        if (len == 0 || nRows < 2) return s;
        int lag = 2 * nRows - 2;
        String ret = "";
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < len; j += lag) {
                ret += s.charAt(j);
                if (i > 0 && i < nRows - 1) {
                    int t = j + lag - 2 * i;
                    if (t < len) {
                        ret += s.charAt(t);
                    }
                }
            }
        }
        return ret;
    }

    public static int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        long sum = 0;

        while (x != 0) {
            int temp = x % 10;
            sum = sum * 10 + temp;
            if (sum > max || sum < min) {
                return 0;
            }
            x = x / 10;
        }
        return (int) sum;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int len = 1;
        while (x / len > 10) {
            len *= 10;
        }
        while (x > 0) {
            int left = x / len;
            int right = x % 10;
            if (left != right) {
                return false;
            } else {
                x = (x % len) / 10;
                len /= 100;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 1221;
        int len = 1000;
        x = (x % len) / 10;
        System.out.println(x);
    }
}
