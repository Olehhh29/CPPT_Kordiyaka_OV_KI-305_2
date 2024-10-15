import java.io.*;
import java.util.*;

/** Клас Lab1KordiyakaKI305 реалізує створення зубчастого массиву, вивід його та запис у файл "MyFile.txt" */
public class Lab1KordiyakaKI305 {
    /**
     * Статичний метод main є точкою входу в програму
     *
     * @param args
     * @throws FileNotFoundException
     */

    public static void main(String[] args) throws FileNotFoundException {

        // Оголошення змінних
        int size;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);

        // Створення файлу для запису
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        // Присвоєння довжини з консолі
        System.out.print("Size matrix: ");
        size = in.nextInt();
        in.nextLine();

        // Створення зубчастого массиву
        arr = new char[size][size];
        for (int i = 0; i < size; i += 2) {
            arr[i] = new char[size];
        }

        // Вибір символу для массиву
        System.out.print("Filler: ");
        filler = in.nextLine();
        in.close();

        // Перевірка на правильний ввід символу
        if (filler.length() == 1) {
            char fillerChar = filler.charAt(0);
            // Вивід та запис у файл массиву
            for (int i = size / 4; i < size - size / 4 - size / 2; i++) {
                for (int j = size / 4; j < size - size / 4; j++) {
                    arr[i][j] = fillerChar; // Заповнюємо матрицю символом
                }
            }
            for (int i = size / 4 + size / 2; i < size - size / 4; i++) {
                for (int j = size / 4; j < size - size / 4; j++) {
                    arr[i][j] = fillerChar; // Заповнюємо матрицю символом
                }
            }
            for (int i = size / 4; i < size - size / 4; i++) {
                for (int j = size / 4; j < size - size / 4 - size / 2; j++) {
                    arr[i][j] = fillerChar; // Заповнюємо матрицю символом
                }
            }
            for (int i = size / 4; i < size - size / 4; i++) {
                for (int j = size / 4 + size / 2; j < size - size / 4; j++) {
                    arr[i][j] = fillerChar; // Заповнюємо матрицю символом
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(arr[i][j] + "    ");
                    fout.print(arr[i][j] + "    "); // Виводимо елемент матриці
                }
                System.out.print("\n");
                fout.print("\n"); // Перехід на новий рядок після кожного рядка матриці
            }
        }

        else if (filler.length() == 0)
            System.out.print("\n Your symbol is absent\n");

        else
            System.out.print("\n Too much symbols\n  ");

        fout.flush();
        fout.close();
    }
}