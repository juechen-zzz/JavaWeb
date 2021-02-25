import com.komorebi.dao.UserDaoImpl;
import com.komorebi.dao.UserDaoMysqlImpl;
import com.komorebi.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
//        // 用户实际调用的是业务层，Dao层不需要接触
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.setUserDao(new UserDaoMysqlImpl());

        // 获取ApplicationContext，拿到Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserServiceImpl userService = (UserServiceImpl) context.getBean("UserServiceImpl");

        userService.getUser();
    }
}