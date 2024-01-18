import java.io.IOException;
import java.util.Scanner;

public class TwoThreeFourTree {

    public static void main(String[] args) throws IOException {
        boolean isRunning = true;
        Tree234 tree234 = new Tree234();

        try (Scanner scanner = new Scanner(System.in)) {
            while (isRunning) {
                switch (getUserChoice(scanner)) {
                    case 'S':
                        displayTree(tree234);
                        break;
                    case 'I':
                        insertValue(scanner, tree234);
                        break;
                    case 'D':
                        deleteValue(scanner, tree234);
                        break;
                    case 'F':
                        findValue(scanner, tree234);
                        break;
                    case 'E':
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid entry");
                }
            }
        }
    }

    private static char getUserChoice(Scanner scanner) throws IOException {
        System.out.println("\n(S)how, (I)nsert, (D)elete, (F)ind or (E)xit");
        while (true) {
            String input = scanner.next().toUpperCase();
            if (input.matches("[SIDFE]")) {
                return input.charAt(0);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void insertValue(Scanner scanner, Tree234 tree234) throws IOException {
        System.out.print("Value to insert: ");
        long value = getLongInput(scanner);
        tree234.insert(value);
    }

    private static void deleteValue(Scanner scanner, Tree234 tree234) throws IOException {
        System.out.print("Value to delete: ");
        long value = getLongInput(scanner);
        tree234.delete(value);
    }

    private static void findValue(Scanner scanner, Tree234 tree234) throws IOException {
        System.out.print("Value to find: ");
        long value = getLongInput(scanner);
        if (tree234.find(value) != -1) {
            System.out.println("Value is in the tree");
        } else {
            System.out.println("Value is not in the tree");
        }
    }

    private static long getLongInput(Scanner scanner) {
        while (!scanner.hasNext("[0-9]+")) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        return Long.parseLong(scanner.next());
    }

    private static void displayTree(Tree234 tree234) {
        System.out.println("\nThe tree contains: ");
        tree234.printTree();
    }
}