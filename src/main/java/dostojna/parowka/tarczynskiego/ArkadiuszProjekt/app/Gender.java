package dostojna.parowka.tarczynskiego.ArkadiuszProjekt.app;

/*
 * @Author: Arkadiusz Brych
 * Class is checking gender after the last letter in the name
 * */
public class Gender {

    public static String checkGender(String name) {

        if (name.charAt(name.length()-1) == 'a') {
            return "F";
        } else {
            return "M";
        }
    }
}
