package payload.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)

@Getter
@Setter
public class Company {

    private String name;
    private String department;
    private String title;
    private Address address;



}
