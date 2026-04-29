package payload.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)

@Getter
@Setter
public class Address {

    private String address;
    private String city;
    private String state;
    private String country;
    private Coordinates coordinates;




}
