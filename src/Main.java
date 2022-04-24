import java.util.Scanner;

public class Main {
    static boolean flag = false;
    static int num1;
    static int num2;
    static char op;
    static int result;


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter term: ");
        String term = reader.nextLine();
        String[] words = term.split(" "); // разбивка выражения на слова
        if (words.length != 3) {
            System.out.println("wrong format term1");
            System.exit(0);
        }
        //вывод выражения по частям
        //System.out.println(word);
        try {
            num1 = Integer.parseInt(words[0]);
            num2 = Integer.parseInt(words[2]);
        } catch (NumberFormatException e) {
            flag = true;
        }
        if (flag) {
            Rim[] cArray = Rim.values();
            for (Rim a : cArray) {
                if (words[0].equals(a.name())) {
                    num1 = a.getValue();
                    break;
                }
            }
            for (Rim a : cArray) {
                if (words[2].equals(a.name())) {
                    num2 = a.getValue();
                    break;
                }
            }
        }
        op = words[1].charAt(0);
        if (num1 < 1 | num1 > 10 | num2 < 1 | num2 > 10) {
            System.out.println("wrong format term2");
            System.exit(0);
        }
        switch (op) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> {
                double result1 = (double) num1 / (double) num2;
                if (result1 % 1 != 0) {
                    System.out.println("the answer is not an integer");
                    System.exit(0);
                }
                result = (int) result1;
            }
            default -> {
                System.out.println("wrong format term3");
                System.exit(0);
            }
        }
        if (!flag) {
            System.out.println(num1 + " " + op + " " + num2 + " = " + result);
            System.exit(0);
        }
        if (result < 1) {
            System.out.println("roman numeral number can't be negative");
            System.exit(0);
        }
        System.out.print(NumberConvertManager.transform_number_to_roman_numeral(num1));
        System.out.print(" " + op + " ");
        System.out.print(NumberConvertManager.transform_number_to_roman_numeral(num2));
        System.out.print(" = ");
        System.out.print(NumberConvertManager.transform_number_to_roman_numeral(result));
    }
}