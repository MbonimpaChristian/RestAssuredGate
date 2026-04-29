package utils;

import com.github.javafaker.Faker;
import payload.pojo.Hair;
import payload.pojo.User;

public class FakerUtils {


    public static String getFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String getLastName() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }


    public static Hair getHair() {
        Faker faker = new Faker();
        Hair hair = new Hair();
        hair.setColor(faker.color().name());
        hair.setType("Curly");
        return hair;
    }

}
