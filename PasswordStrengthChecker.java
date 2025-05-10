import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        //Step 1: Input the password
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your passoword: ");
        String password = scanner.nextLine();

        //Step 2: call the method to check password strength
        checkPasswordStrength(password);
    }

    public static void checkPasswordStrength(String password){
        int score  = 0;

        //check length
        if(isLengthValid(password))score++;

        //check for different character types
        if(hasUpperCase(password))score++;
        if(hasLowerCase(password))score++;
        if(hasDigit(password))score++;
        if(hasSpecialChar(password))score++;

        //determine strength
        if(score <= 2){
            System.out.println("Password Strength: weak");
        }else if(score == 3 || score == 4){
            System.out.println("Password Strength : Medium");
        }else {
            System.out.println("Password Strength : Strong");
        }
    }

    public static boolean isLengthValid(String password){
        return password.length() >= 6;
    }

    public static boolean hasUpperCase(String password){
        for(int i = 0; i < password.length(); i++){
            if(Character.isUpperCase(password.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean hasLowerCase(String password){
        for(int i = 0; i < password.length(); i++){
            if(Character.isLowerCase(password.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean hasDigit(String password){
        for(int i= 0;i < password.length(); i++){
            if(Character.isDigit(password.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean hasSpecialChar(String password){
        String specialChars = "!@#$%^&*()-+";
        for (int i = 0; i < password.length(); i++) {
            if(specialChars.indexOf(password.charAt(i)) >= 0){
                return true;
            }
        }
        return false;
    }
}
