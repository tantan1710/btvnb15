import menu.Menu;
import service.StudentService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        Menu menu = new Menu();
        menu.menuDisplay(scanner, studentService);
    }
}
