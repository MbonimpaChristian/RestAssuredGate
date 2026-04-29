package payload.pojo;

import io.restassured.response.Response;
import payload.UserResponse;

import static io.restassured.RestAssured.given;

public class UserTest {

    import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

    public class UserTest {

        public void getUsers() {

            Response response =
                    given()
                            .when()
                            .get("https://dummyjson.com/users");

            // 🔥 DESERIALIZATION
            UserResponse userResponse =
                    response.as(UserResponse.class);

            // Access data
            User user = userResponse.getUsers().get(0);

            System.out.println(user.getFirstName());
            System.out.println(user.getEmail());
            System.out.println(user.getHair().getColor());
            System.out.println(user.getAddress().getCity());
            System.out.println(user.getCompany().getName());
            System.out.println(user.getCompany().getAddress().getCoordinates().getLat());
        }
    }
}
