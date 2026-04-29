package base;

import io.restassured.response.Response;
import routes.Routes;


public class DummyAPI {

    public static Response createUser(Object payload) {
        return RestResource.post(Routes.CREATE_USER, payload);
    }

    public static Response getAllUsers() {
        return RestResource.get(Routes.GET_ALL_USERS);
    }

    public static Response getUser(int userId) {
        return RestResource.get(Routes.GET_SINGLE_USER, userId);
    }

    public static Response updateUser(int userId, Object payload) {
        return RestResource.put(Routes.UPDATE_USER, userId, payload);
    }

    public static Response deleteUser(int userId) {
        return RestResource.delete(Routes.DELETE_USER, userId);
    }

}