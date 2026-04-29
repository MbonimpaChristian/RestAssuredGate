//package group4;
//
//import io.github.cdimascio.dotenv.Dotenv;
//import io.restassured.response.Response;
//import utils.ConfigLoader;
//
//import java.time.Instant;
//import java.util.HashMap;
//
//import static group4.RestResource.postAccount;
//
//public class TokenManager {
//    private static String access_token;
//    private static Instant expiry_time;
//    private static final long expiresIn = Instant.now().getEpochSecond();
//
//    public synchronized static String getAccessToken() {
//        try{
//            if(access_token == null || Instant.now().isAfter(expiry_time)){
//                Response response = renewToken();
//                access_token = response.path("accessToken");
//                expiry_time = Instant.now().plusSeconds(expiresIn - 300);
//            } else {
//                System.out.println("Token is still good to use!");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to renew token!", e);
//        }
//        return access_token;
//    }
//
//    private static Response renewToken() {
//        Dotenv dotenv = Dotenv.load();
//
//        HashMap<String, String> formParams = new HashMap<>();
//        formParams.put("refreshToken", dotenv.get("REFRESH_TOKEN"));
//
//        Response response = postAccount(formParams);
//        if(response.statusCode() != 200){
//            throw new RuntimeException("Failed : Renew Token Failed "+ response.statusCode());
//        }
//        return response;
//    }
//}
