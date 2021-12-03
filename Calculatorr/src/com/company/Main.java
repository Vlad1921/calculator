package com.company;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("input.txt"));

        for (String s : lines) {
            System.out.println(s);
        }
        File file = new File("output.txt");
        PrintWriter pw = new PrintWriter(file);
        String a, b, c;
        System.out.println("Решение -");

        for (int i = 0; i<5; i++) {
            String line = lines.get(i);

            if (isResult(line)) {
                String[] data = getS(line);
                a = data[0];
                b = data[1];
                c = data[2];

                int q = getQ(a);
                int w = getQ(c);

                String operation = b;
                switch (operation) {
                    case ("-"):
                        System.out.println(sub(q, w));
                        pw.println(sub(q, w));

                        break;
                    case ("+"):
                        System.out.println(add(q, w));
                        pw.println(add(q, w));

                        break;
                    case ("/"):
                        System.out.println(div(q, w));
                        pw.println(div(q, w));

                        break;
                    case ("%"):
                        System.out.println(remains(q, w));
                        pw.println(remains(q, w));

                        break;
                    case ("*"):
                        System.out.println(multiply(q, w));
                        pw.println(multiply(q, w));
                        break;
                    case ("^"):
                        System.out.println(degree(q, w));
                        pw.println(degree(q, w));
                        break;
                }

            } else {
                System.out.println("Неверные данные");
                pw.println("Неверные данные");
                pw.close();
            }

        }pw.close();
    }


    private static int getQ(String a) {
        return Integer.parseInt(a);
    }


    private static String[] getS(String string) {
        return string.split(" ");
    }


    private static String getString(Scanner scanner) {
        return scanner.nextLine();
    }
    private static boolean isResult(String string) {
        return string.matches("\\d+\\s[\\+\\-\\*\\/\\%\\^]\\s\\d+");
    }


    private static double degree(int q, int w) {
        return Math.pow(q, w);
    }

    static int multiply(int q, int w) {
        return q * w;
    }

    static int remains(int q, int w) {
        return q % w;
    }

    static int div(int q, int w) {
        return q / w;
    }

    static int add(int q, int w) {
        return q + w;
    }

    static int sub(int q, int w) {
        return q - w;
    }
}
