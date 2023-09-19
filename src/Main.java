import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num = 0;
        while (true)
        {
            System.out.print("Введите число: ");
            Scanner sc = new Scanner(System.in);
            try {
                num = sc.nextInt();
                break;
            } catch (InputMismatchException fg) {
                System.out.print("Вы ввели не число!\n");
            }
        }

        String fileName = "C:\\Users\\fr7nz\\IdeaProjects\\Lab1\\src\\file.txt";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split("[,.\\s]+");
                for (int i = 0; i < str.length; i++) {
                    char simb1 = str[i].charAt(0);
                    if ((str[i].length() == num) && ("БВГДЖЗЙКЛМНПРСТФХЦЧШЩбвгджзйклмнпрстфхцчшщ".contains(String.valueOf(simb1)))) {
                        str[i] = "";
                    }
                    System.out.println(str[i]);
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Ошибка при открытии файла: " + e.getMessage());
        }
    }
}