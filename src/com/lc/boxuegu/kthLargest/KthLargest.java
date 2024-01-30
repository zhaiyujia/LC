package com.lc.boxuegu.kthLargest;

import java.util.PriorityQueue;

/**
 * @author zhai
 * @date 2024/1/30 6:47 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class KthLargest {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,5,2,5,6,0,10,123,12,687};
        KthLargest largest = new KthLargest(nums, 5);
        int kth = largest.getKth();
        System.out.println(kth);
    }

    int k;
    PriorityQueue<Integer> queue;

    public KthLargest(int[] nums, int k){
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val){
        if (queue.size() < k) {
            queue.offer(val);
        }else if(val > queue.peek()){
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

    public int getKth(){
        return queue.peek();
    }

}
