package group4;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.response.Response;
import utils.ConfigLoader;

import java.time.Instant;
import java.util.HashMap;

import static group4.RestResource.postAccount;

public class TokenManager {
    private static String access_token;
    private static Instant expiry_time;

    public synchronized static String getAccessToken() {
        try{
            if(access_token == null || Instant.now().isAfter(expiry_time)){
                Response response = renewToken();
                access_token = response.path("access_token");
                int expiresIn = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiresIn - 300);
            } else {
                System.out.println("Token is still good to use!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to renew token!", e);
        }
        return access_token;
    }

    private static Response renewToken() {
        Dotenv dotenv = Dotenv.load();

        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("grant_type", ConfigLoader.getInstance().getGrantType());
        formParams.put("refresh_token", dotenv.get("REFRESH_TOKEN"));
        formParams.put("client_id", ConfigLoader.getInstance().getClientId());

        Response response = postAccount(formParams);
        if(response.statusCode() != 200){
            throw new RuntimeException("Failed : Renew Token Failed "+ response.statusCode());
        }
        return response;
    }
}
