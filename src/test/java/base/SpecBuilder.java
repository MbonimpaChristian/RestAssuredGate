package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.ConfigLoader;

import static filters.FilterUtils.getLoggingFilters;


public class SpecBuilder {

    public static RequestSpecification getRequestSpec(){
            return new RequestSpecBuilder()
                .setBaseUri(ConfigLoader.getBaseUrl())
                    .addFilters(getLoggingFilters())
                    .setContentType(ContentType.JSON).
                build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }
}
