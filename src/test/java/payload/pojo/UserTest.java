package tests;

import io.restassured.response.Response;
import payload.UserResponse;
import payload.pojo.Company;
import payload.pojo.User;

import static io.restassured.RestAssured.given;

public class UserTest {

    public void getUsers() {

        Response response =
                given()
                        .when()
                        .get("https://dummyjson.com/users");

        UserResponse userResponse =
                response.as(UserResponse.class);

        User user = userResponse.getUsers().get(0);

        System.out.println(user.getFirstName());
        System.out.println(user.getEmail());
        System.out.println(user.getHair().getColor());
        System.out.println(user.getCompany().getAddress().getCity());
        System.out.println(user.getCompany().getName());
        System.out.println(user.getCompany().getAddress().getCoordinates().getLat());
    }
}