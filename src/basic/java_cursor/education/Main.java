package basic.java_cursor.education;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        WriteLogin writeLoginUser = new WriteLogin();

        String login;
        String password;
        String confirmPassword;

        System.out.println("Register please  ");
        while (true) {
            System.out.println("Register: Write login   : ");
            login = scanner.nextLine();
            System.out.println("Register: Write password: ");
            password = scanner.nextLine();
            System.out.println("Register: Write return password: ");
            confirmPassword = scanner.nextLine();

            if (writeLoginUser.signUp(login, password, confirmPassword)) {
                break;
            }
            System.out.println("Error");
        }

        System.out.println("Log in please");
        while (true) {
            System.out.println("Log in: Write login: ");
            login = scanner.nextLine();
            System.out.println("Log in: Write password: ");
            password = scanner.nextLine();

            if (writeLoginUser.signIn(login, password)) {
                break;
            }
            System.out.println("Error");
        }

        System.out.println("Let's continue our work");
    }
}
