import org.omg.CORBA.ObjectHolder;

/**
 * @description: JHSDB测试代码
 * @author: Komorebi
 * @time: 2021/5/25 13:12
 */
public class JHSDB_TestCase {
    static class Test {

        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done"); // 这里设一个断点 }
        }

        private static class ObjectHolder {
        }

        public static void main(String[] args) {
            Test test = new JHSDB_TestCase.Test();
            test.foo();
        }
    }
}
