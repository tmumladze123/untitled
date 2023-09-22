package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
@JsonIgnoreProperties
public class Person {
    String userName = "username";
    String password = "password";
    String age;
}
