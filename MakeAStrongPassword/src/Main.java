import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------Welcome-----------");
        System.out.println("*--Make a STRONG password--*");
        System.out.println("Enter password length:");
        int length = scanner.nextInt();
        String password = makePassword(length);

        System.out.println("Here is your password: " + password);
        passwordSecurity(password);
    }

    public static String makePassword(int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        char[] characters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','_','A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','*','#','&','/'};

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length);
            String randomValue = String.valueOf(characters[randomIndex]);
            builder.append(randomValue);
        }

        String password = builder.toString();
        return password;
    }

    public static void passwordSecurity(String password) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
            if (Character.isDigit(character)) {
                hasDigit = true;
            } else if (Character.isUpperCase(character)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(character)) {
                hasLowerCase = true;
            } else if ("*#&/".indexOf(character) != -1) {
                hasSpecial = true;
            }
        }

        System.out.println("Your security:");
        System.out.println("Uppercase status: " + hasUpperCase);
        System.out.println("Lowercase status: " + hasLowerCase);
        System.out.println("Digit status: " + hasDigit);
        System.out.println("Special character status: " + hasSpecial);
        System.out.println("Size status (must be at least 8): " + (password.length() >= 8));

        int counter = 0;
        if (hasSpecial) {
            counter++;
        }
        if (hasDigit) {
            counter++;
        }
        if (hasLowerCase) {
            counter++;
        }
        if (hasUpperCase) {
            counter++;
        }
        if (password.length() >= 8) {
            counter++;
        }
        System.out.println("Security level: " + counter);
    }
}
