package work;

import java.util.HashMap;
import java.util.Map;

/**
 * 作业1
 *
 * @author Tommy
 */
public class Hello {


    /**
     *
     *
     * familiarWithByteCode
     * 需要涉及基本类型，四则运行，if和for，然后自
     * 己分析一下对应的字节码
     *
     */
    public Object byteCodeTest(int a,int b){
        Map map = new HashMap<>(1);
        if(a > b){
            a = a * b;
        }else if(a < b) {
            a = a / b;
        }
        a = a + b;
        b = a - b;
        for(int i = 0; i< b; i++){
            map.put(i,b);
        }

        return map;
    }

    /**
     * zangtao@zangtaodeMacBook-Pro work % javap -c Hello.class
     * Compiled from "Hello.java"
     * public class work.Hello {
     *   public work.Hello();
     *     Code:
     *        0: aload_0
     *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *        4: return
     *
     *   public java.lang.Object byteCodeTest(int, int);
     *     Code:
     *        0: new           #2                  // class java/util/HashMap
     *        3: dup
     *        4: iconst_1
     *        5: invokespecial #3                  // Method java/util/HashMap."<init>":(I)V
     *        8: astore_3
     *        9: iload_1
     *       10: iload_2
     *       11: if_icmple     21
     *       14: iload_1
     *       15: iload_2
     *       16: imul
     *       17: istore_1
     *       18: goto          30
     *       21: iload_1
     *       22: iload_2
     *       23: if_icmpge     30
     *       26: iload_1
     *       27: iload_2
     *       28: idiv
     *       29: istore_1
     *       30: iload_1
     *       31: iload_2
     *       32: iadd
     *       33: istore_1
     *       34: iload_1
     *       35: iload_2
     *       36: isub
     *       37: istore_2
     *       38: iconst_0
     *       39: istore        4
     *       41: iload         4
     *       43: iload_2
     *       44: if_icmpge     69
     *       47: aload_3
     *       48: iload         4
     *       50: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
     *       53: iload_2
     *       54: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
     *       57: invokeinterface #5,  3            // InterfaceMethod java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
     *       62: pop
     *       63: iinc          4, 1
     *       66: goto          41
     *       69: aload_3
     *       70: areturn
     * }
     */


}
