package models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    String userName = "username";
    String password = "password";
    String age;
}
