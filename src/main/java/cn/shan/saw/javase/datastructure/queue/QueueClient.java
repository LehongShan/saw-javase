package cn.shan.saw.javase.datastructure.queue;

import org.junit.Test;

/**
 * 队列客户端
 * Created by shanlehong on 2017/12/18.
 */
public class QueueClient {

    @Test
    public void testSequenceQueue(){
        SequenceQueue<String> sequenceQueue = new SequenceQueue<>();
        sequenceQueue.add("aaaa");
        sequenceQueue.add("bbbb");
        sequenceQueue.printQueue();
        sequenceQueue.remove();
        System.out.println("\n以下出现顺序队列假满情况");
        sequenceQueue.add("cccc");
        sequenceQueue.printQueue();

    }

    @Test
    public void testLoopQueue(){
        LoopQueue<String> loopQueue = new LoopQueue<>();
        loopQueue.add("aaaa");
        loopQueue.add("bbbb");
        loopQueue.printQueue();
        loopQueue.remove();
        System.out.println("\n以下新队列");
        loopQueue.add("cccc");
        loopQueue.printQueue();

    }


}
