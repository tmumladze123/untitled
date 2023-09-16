package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"password", "age","userName" })
public class User {
    String userName = "username";
    String password = "password";
    @JsonIgnore
    String age;
    public String getUserName() {
        return userName;
    }
    public String setAge(String a) {
        return this.age=a;
    }
    public String getAge() {
        return age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
