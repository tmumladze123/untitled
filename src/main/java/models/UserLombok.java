package models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class UserLombok {
    String userName = "username";
    String password = "password";
}
