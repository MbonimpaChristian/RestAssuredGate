package payload.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

@Getter
@Setter
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    private Address address;
    private Hair hair;
    private Bank bank;
    private Company company;




}
