package work;

/**
 * @author Tommy
 */
public class HelloByteCode {

    public static void main(String[] args) {
        HelloByteCode helloByteCode = new HelloByteCode();

    }

    /**
     * zangtao@zangtaodeMacBook-Pro work % javap -c HelloByteCode.class
     * Compiled from "HelloByteCode.java"
     * public class work.HelloByteCode {
     *   public work.HelloByteCode();
     *     Code:
     *        0: aload_0
     *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *        4: return
     *
     *   public static void main(java.lang.String[]);
     *     Code:
     *        0: new           #2                  // class work/HelloByteCode
     *        3: dup
     *        4: invokespecial #3                  // Method "<init>":()V
     *        7: astore_1
     *        8: return
     * }
     */
}
