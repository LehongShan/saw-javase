package cn.shan.saw.javase.classload;

/**
 * Created by shanlehong on 2017/3/29.
 */
public class Glyph {

    public void draw(){
        System.out.print("Glyph.draw()");
    }
    public Glyph() {
        System.out.println("before");
        draw();
        System.out.println("after");
    }

}
