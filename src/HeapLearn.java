import java.util.Comparator;
import java.util.PriorityQueue;


/*
PriorityQueue的常用方法有：poll(),offer(Object),size(),peek()等。

　　插入方法（offer()、poll()、remove() 、add() 方法）时间复杂度为O(log(n)) ；
　　remove(Object) 和 contains(Object) 时间复杂度为O(n)；
　　检索方法（peek、element 和 size）时间复杂度为常量。

 */
/*
找topK 用小顶堆, 堆大小保持k个，遍历数组，遇到a[i]>heap.top 则让a[i]进入堆里
最后容量为K的最小堆里保存的就是前K个最大数，堆顶就是我们找的第K个最大数
 */
/*
找k个最小数， 用大顶堆，a[i]比堆顶小，就让他进堆 */
public class HeapLearn {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //小顶堆，默认容量为11
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new Comparator<Integer>(){ //大顶堆，容量11
        @Override
        public int compare(Integer o1,Integer o2){
            /**以下是对比较器升序、降序的理解.
             *(1) 写成return o1.compareTo(o2) 或者 return o1-o2表示升序
             *    o1>o2 是true, 则让swap o1,o2,
             *    那么交换之后，就是o2小的在前面，o1大的在后面， 是升序
             *(2) 写成return o2.compareTo(o1) 或者return o2-o1表示降序
             */
            return o2-o1; //记忆法： 2-->1 降序
            //return o2.compareTo(o1);
        }
    });

}

/*

offer，add区别：

一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。

这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。



poll，remove区别：

remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似，

但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。



peek，element区别：

element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null
 */
