package cn.shan.saw.javase.classload;

/**
 * Created by shanlehong on 2017/5/11.
 */
public class Test {


    public static void main(String []args){
      String ruleId = "CLTSF01";
      String vCLSFruleId = "";
        vCLSFruleId+= ruleId.substring(0,5);
        System.out.println(vCLSFruleId);
        System.out.println(vCLSFruleId.equals("CLTSF")) ;
    }
}
