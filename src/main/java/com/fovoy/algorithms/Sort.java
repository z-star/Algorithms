package com.fovoy.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by zxz.zhang on 2017/3/7.
 */
public class Sort {

    public void quickSort(int[] nums, int low, int hight) {
        if (hight > low) {
            int middle = getMiddle(nums, low, hight);
            quickSort(nums, low, middle - 1);
            quickSort(nums, middle + 1, hight);
        }
    }

    private int getMiddle(int[] nums, int left, int right) {
        int temp = nums[left];
        while (right > left) {
            while (right > left && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
            while (right > left && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }

    public void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    public void choseSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }

    public void insertSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len - 1; i++) {
            int min = nums[i];
            int j = 0;
            for (j = i; j > 0 && nums[j - 1] > min; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j - 1] = min;
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1000), r -> {
            Thread thread = new Thread(r, "name");
            thread.setDaemon(true);
            return thread;
        });

        ThreadPoolExecutor cacheThread = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), r -> {
            Thread thread = new Thread(r, "name");
            thread.setDaemon(true);
            return thread;
        });

    }
}
