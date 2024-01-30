package com.lc.boxuegu.circularDeque;

/**
 * @author zhai
 * @date 2024/1/30 6:34 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class MyCircularDeque {

    int capacity;
    int[] elementData;
    int front;
    int rear;

    public MyCircularDeque(int k) {
        this.capacity = k + 1;
        this.elementData = new int[capacity];
        front = rear = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        this.elementData[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        elementData[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return elementData[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return elementData[(rear - 1 + capacity) % capacity];
    }


    public boolean isFull() {
        return front == (rear + 1) % capacity;
    }

    public boolean isEmpty() {
        return front == rear;
    }

}
