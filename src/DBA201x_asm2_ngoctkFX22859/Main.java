package DBA201x_asm2_ngoctkFX22859;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Integer EXIT_COMMAND_CODE = 0;
    public static final Scanner sc = new Scanner(System.in);

    public static int[] a;

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        System.out.println("+-------------------Menu------------------+");
        System.out.println("|      1.Manual Input                     |");
        System.out.println("|      2.File input                       |");
        System.out.println("|      3.Bubble sort                      |");
        System.out.println("|      4.Selection sort                   |");
        System.out.println("|      5.Insertion sort                   |");
        System.out.println("|      6.Search > value                   |");
        System.out.println("|      7.Search = value                   |");
        System.out.println("|      0.Exit                             |");
        System.out.println("+-----------------------------------------+");
        System.out.println("Chức năng: ");
        function();
    }

    public static void function() {
        int input;
        try {
            while (true) {
                input = sc.nextInt();
                if (input == 1) {
                    manualInput();
                    menu();
                }
                if (input == 2) {
                    fileInput();
                    menu();
                }
                if (input == 3) {
                    bubbleSort();
                    menu();
                }
                if (input == 4) {
                    selectionSort();
                    menu();
                }
                if (input == 5) {
                    insertionSort();
                    menu();
                }
                if (input == 6) {
                    linearSearch();
                    menu();
                }
                if (input == 7) {
                    binarySearch();
                    menu();
                }
                if (input == 0) {
                    System.out.println("Exit!");
                    System.exit(EXIT_COMMAND_CODE);
                }
                System.out.println("Số bạn nhập không đúng, vui lòng nhập lại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            sc.next();
            System.out.println("Lỗi nhập liệu hoặc số bạn nhập không hợp lệ. Vui lòng nhập lại.");
        }
    }

    // CHỨC NĂNG 1:
    static void manualInput() {
        System.out.print("Please enter input number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Please enter input elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Method.writeFile(arr);
    }

    // CHỨC NĂNG 2:
    static void fileInput() {
        System.out.println("Please enter the file path: ");
        String filePath = sc.next();
        a = Method.fileInput(filePath, a);
    }

    //CHỨC NĂNG 3:
    static void bubbleSort() {
        int[] b = Method.aToB(a);
        b = Method.bubbleSort(b);
        Method.saveArrayToFile(b, "OUTPUT1.txt");
    }

    // CHỨC NĂNG 4:
    static void selectionSort() {
        int[] b = Method.aToB(a);
        b = Method.selectionSort(b);
        Method.saveArrayToFile(b, "OUTPUT2.txt");
    }

    // CHỨC NĂNG 5:
    static void insertionSort() {
        int[] b = Method.aToB(a);
        b = Method.insertionSort(b);
        Method.saveArrayToFile(b, "OUTPUT3.txt");
    }

    // CHỨC NĂNG 6:
    static void linearSearch() {
        int[] b = Method.aToB(a);
        System.out.print("Please enter searched input value:");
        int value = sc.nextInt();
        System.out.println(Method.linearSearch(b, value));
    }

    // CHỨC NĂNG 7:
    static void binarySearch() {
        int[] b = Method.aToB(a);
        Arrays.sort(b);
        System.out.print("Please enter searched input value: ");
        int value = sc.nextInt();
        System.out.println(Method.binarySearch(b, value));
    }
}