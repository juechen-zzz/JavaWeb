import com.komorebi.pojo.Student;
import com.komorebi.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
        // Student(name=komorebi, address=Address(address=nanjing), books=[A, B, C], hobbies=[a, b, c], card={1=v1, 2=v2}, games=[LOL], info={学号=20190001, 性别=1}, wife=null)
    }

    @Test
    public void MyTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userBeans.xml");
        User user = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user == user2);
    }
}
