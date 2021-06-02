/**
 * @description:
 *      被动使用类字段演示一：通过子类引用父类的静态字段，不会导致子类初始化
 * @author: Komorebi
 * @time: 2021/5/27 13:57
 */

class SuperClass {
    static {
        System.out.println("SuperClass init");
    }
    public static int value = 123;
    public void test() {
        System.out.println(321);
    }
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }
    public void test() {
        System.out.println(432);
    }
}

public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
//        SuperClass a = new SubClass();
//        a.test();
    }
}
