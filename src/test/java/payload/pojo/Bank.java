package payload.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)

@Getter
@Setter
public class Bank {

    private String cardNumber;
    private  String cardType;
    private String currency;




}
