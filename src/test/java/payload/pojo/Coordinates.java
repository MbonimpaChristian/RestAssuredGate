package payload.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)

@Getter
@Setter
public class Coordinates {

    private double lat;
    private double lng;


}
