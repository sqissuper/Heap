package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MyHeap {
    public int[] val;
    public int size;

    public MyHeap() {
        this.val = new int[10];
    }

    //创建堆
    public void create(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.val[i] = arr[i];
            this.size++;
        }
        for (int i = (this.size - 1 - 1) / 2; i >= 0 ; i--) {
            adjust(i,this.size);
        }
    }

    //调整
    public void adjust(int p,int len) {
        int c = p * 2 + 1;
        while(c < len) {
            //c + 1 < len 判断是否有右孩子
            if(c + 1 < len && this.val[c] < this.val[c + 1]) {
                c++;
            }
            if(this.val[p] < this.val[c]) {
                int tmp = this.val[c];
                this.val[c] = this.val[p];
                this.val[p] = tmp;
                p = c;
                c = 2 * p + 1;
            } else {
                break;
            }
        }
    }

//    //显示
    public void show() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.val[i] + " ");
        }
    }
//
//    //添加元素
//    public void push(int val) {
//        if(isFull()) {
//            this.val = Arrays.copyOf(this.val,this.val.length * 2);
//        }
//        this.val[this.size] = val;
//        this.size++;
//        adjustUp(this.size - 1);
//    }
//    public void adjustUp(int c) {
//        int p = (c - 1) / 2;
//        while(c > 0) {
//            if(this.val[c] > this.val[p]) {
//                int tmp = this.val[c];
//                this.val[c] = this.val[p];
//                this.val[p] = tmp;
//                c = p;
//                p = (c - 1) / 2;
//            } else {
//                break;
//            }
//        }
//    }
//
//    //拿到堆头元素
//    public int peek() {
//        if(isEmpty()) return -1;
//        return this.val[0];
//
//    }
//
//    //删除堆头元素
//    public int poll() {
//        if(isEmpty()) return -1;
//        int ret = this.val[0];
//        int tmp = this.val[0];
//        this.val[0] = this.val[this.size - 1];
//        this.val[this.size - 1] = tmp;
//        this.size--;
//        adjust(0,this.size);
//        return ret;
//    }
//    public boolean isFull() {
//        return this.size == this.val.length;
//    }
//
//    public boolean isEmpty() {
//        return this.size == 0;
//    }
//
//    //前k个最大/最小元素
//    public static void minHeap(int[] arr,int k) {
//        PriorityQueue<Integer> qu = new PriorityQueue<>(k,new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        for (int i = 0; i < arr.length; i++) {
//            if(qu.size() < k) {
//                qu.add(arr[i]);
//            } else {
//                int tmp = qu.peek();
//                if(arr[i] < tmp) {
//                    qu.poll();
//                    qu.add(arr[i]);
//                }
//            }
//        }
//        System.out.println(qu.peek());
//    }
//
    public static void create2(int[] arr) {
        for (int i = (arr.length - 1 - 1) / 2; i >= 0 ; i--) {
            adjust2(arr,i,arr.length);
        }
    }

    //调整
    public static void adjust2(int[] arr,int p,int len) {
        int c = p * 2 + 1;
        while(c < len) {
            //c + 1 < len 判断是否有右孩子
            if(c + 1 < len && arr[c] < arr[c + 1]) {
                c++;
            }
            if(arr[p] < arr[c]) {
                int tmp = arr[p];
                arr[p] = arr[c];
                arr[c] = tmp;
                p = c;
                c = 2 * p + 1;
            } else {
                break;
            }
        }
    }
    public static void heapSort(int[] arr) {
        create2(arr);
        int end = arr.length - 1;
        while(end > 0) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            adjust2(arr,0,end);
            end--;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        MyHeap heap = new MyHeap();
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        heap.create(arr);
        heap.show();
        heapSort(arr);
//        System.out.println(Arrays.toString(arr));
//        minHeap(arr,3);
//        heap.create(arr);
//        heap.show();
//        System.out.println();
//        heap.push(100);
//        heap.show();
//        System.out.println();
//        System.out.println(heap.peek());
//        System.out.println(heap.poll());
//        heap.show();

//        qu.add(27);
//        qu.add(15);
//        qu.add(19);
//        qu.add(18);
//        qu.add(28);
//        qu.add(34);
//        qu.add(65);
//        System.out.println(qu);
//        System.out.println(qu.peek());


    }

}
