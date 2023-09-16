import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import models.Person;
import models.User;
import models.UserLombok;
import org.testng.annotations.Test;


@Log
@Slf4j
public class Lombok {

    //difference between lombok setter and getter and normal class
    @Test
    public  void differenceBetweenSetterAndGetter(){
        UserLombok userLombok = new UserLombok();
        userLombok.setPassword("Password");
        userLombok.getUserName();

        User user = new User();
        user.setAge("12");
        user.getPassword();
    }
    //usage of @String
    @Test
    public  void toStringDifference(){
        UserLombok userLombok = new UserLombok();
        System.out.println(userLombok);

        User user = new User();
        System.out.println(user);
    }
    //usage of @String
    @Test
    public  void usageOfBuilderClass(){
        Person person = Person.builder().userName("username").password("password").build();


        User user = new User();
        user.setUserName("username");
        user.setPassword("password");
    }
    //usage of @String
    @SneakyThrows
    @Test
    public  void usageOfSneakyThrows(){
        Thread.sleep(2000);
    }

    @Test
    public  void usageOfLog(){
    log.severe("something is wrong");
    }
}
