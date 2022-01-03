package basic.java_cursor.education;

import java.util.Arrays;
import java.util.regex.Pattern;

public class WriteLogin {
    private static final int MIN_LANG_LOGIN = 0; //Ведення даних мінімальна кількість символі.
    private static final int MAX_LANG_LOGIN = 20;//Ведення даних максимальна кількість символі.

    private static final int MIN_LANG_PASSWORD = 0;//Ведення даних мінімальна кількість символі.
    private static final int MAX_LANG_PASSWORD = 20;//Ведення даних максимальна кількість символі.

    private String login;
    private String password;
    private String confirmPassword;

    public void setLogin(String login) throws WrongLoginException { // перевірка логіна на коректність
        if (MIN_LANG_LOGIN < login.length() && login.length() < MAX_LANG_LOGIN) {
            if (isCorrectCharacters(login)) {
                this.login = login;
                return;
            }
        }

        throw new WrongLoginException("Login inappropriate");
    }

    public String getLogin() {
        return this.login;
    }

    public void setPassword(String password) throws WrongPasswordException { //перевірка пароля на коректність
        if (MIN_LANG_PASSWORD < password.length() && password.length() < MAX_LANG_PASSWORD) {
            if (isCorrectCharacters(password)) {
                this.password = password;
                return;
            }
        }

        throw new WrongPasswordException();
    }

    public String getPassword() {
        return this.password;
    }

    public void setConfirmPassword(String confirmPassword) throws WrongPasswordException {//перевірка коректності пароля для підтвердження
        if (MIN_LANG_PASSWORD <= confirmPassword.length() && confirmPassword.length() <= MAX_LANG_PASSWORD) {
            if (isCorrectCharacters(confirmPassword)) {
                this.confirmPassword = confirmPassword;
                return;
            }
        }

        throw new WrongPasswordException();
    }

     public boolean signUp(String login, String password, String confirmPassword) {//перевірка на співпадіння пароля та підтверження
        try {
            if (isStringMatch(password, confirmPassword)) {
                this.setLogin(login);
                this.setPassword(password);
                this.setConfirmPassword(confirmPassword);

                return true;
            } else {
                System.out.println("Password mismatch");
            }
        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println(ex);
        }

        return false;
    }

    public boolean signIn(String login, String password) {//перевірка відповідності логіну та паролю для входу в систему
        if (isStringMatch(login, this.getLogin()) && isStringMatch(password, this.getPassword())) {
            return true;
        }

        return false;
    }

    private boolean isCorrectCharacters(String login) {
        String correctStrng = "^[a-zA-Z0-9_]"; // перевірка дозволених символів
        return Pattern.compile(correctStrng).matcher(login).find();
    }

    private boolean isStringMatch(String string, String confirmString) {//Порівняння двох значень (логіну чи паролю)
        char[] lineString = string.toCharArray();
        char[] lineConfirmString = confirmString.toCharArray();

        return Arrays.equals(lineString, lineConfirmString);
    }
}
