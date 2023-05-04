import java.util.regex.Pattern;

public class LessonExceptions {

    public static void main(String[] args) {
        checkLoginAndPassword("login", "pass", "pass");
        checkLoginAndPassword("login/", "pass", "pass");
        checkLoginAndPassword("loginloginloginloginlogin", "pass", "pass");
        checkLoginAndPassword("login", ".pass", "pass");
        checkLoginAndPassword("login", "passpasspasspasspass", "pass");
        checkLoginAndPassword("login", "pass", "pass2");

    }

    public static void checkLoginAndPassword(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка << " + e + " >>");
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка << " + e + " >>");
        }
    }

    public static void checkLogin(String login) throws WrongLoginException {
        boolean writeLogin = login.matches("^\\w+$");
        if (!writeLogin) {
            throw new WrongLoginException("Логин должен содержать буквы латтинского алфавита, цифры и(или) нижние подчеркивания");
        } else if (login.length() > 20) {
            throw new WrongLoginException("Логин должен быть меньше или равен 20 символам");
        }
    }

    public static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        boolean writePassword = password.matches("^\\w+$");
        if (!writePassword) {
            throw new WrongPasswordException("Пароль должен содержать буквы латтинского алфавита, цифры и(или) нижние подчеркивания");
        } else if (password.length() > 19) {
            throw new WrongPasswordException("Пароль должен быть меньше 20 символов");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не равны");
        }
    }
}

