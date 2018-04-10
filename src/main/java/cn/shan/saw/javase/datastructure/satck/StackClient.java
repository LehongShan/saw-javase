package cn.shan.saw.javase.datastructure.satck;

import org.junit.Test;

/**
 * 栈测试客户端
 * Created by shanlehong on 2017/12/15.
 */
public class StackClient {

    @Test
    public void testSequenceStack(){
        SequenceStack<String> sequenceStack = new SequenceStack<>();
        sequenceStack.push("aaaaa");
        sequenceStack.push("bbbbb");
        sequenceStack.push("ccccc");
        sequenceStack.push("ddddd");
        sequenceStack.printStack();
        System.out.println("栈顶元素："+sequenceStack.peek());
        System.out.println("出栈元素："+sequenceStack.pop());
        sequenceStack.push("eeeee");
        sequenceStack.printStack();
    }

    @Test
    public void testLinkStack(){
        LinkStack<String> linkStack = new LinkStack<>();
        linkStack.push("aaaaa");
        linkStack.push("bbbbb");
        linkStack.push("ccccc");
        linkStack.push("ddddd");
        linkStack.printStack();
        System.out.println("栈顶元素："+linkStack.peek());
        System.out.println("出栈元素："+linkStack.pop());
        System.out.println("入栈元素：eeeee");
        linkStack.push("eeeee");
        linkStack.printStack();
    }

}
