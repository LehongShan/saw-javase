package cn.shan.saw.javase.classload;

/**
 * Created by shanlehong on 2017/3/29.
 */
public class RoundGlyph extends Glyph {
    private static int radius=1;

    public RoundGlyph(int r) {
        radius=r;
        System.out.println("roundGlyph.radius="+radius);
    }
    public void draw(){
        System.out.println("roundGlyph.radius="+radius);
    }
    public static void main(String[] args) {
        new RoundGlyph(5);
    }

}
