package DBA201x_asm2_ngoctkFX22859;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Method {

    //Lưu DL của mảng a sang mảng b
    static int[] aToB(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }

    // In mảng được sắp xếp
    static void printArray(int[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.printf("%d.0  ", b[i]);
        }
        System.out.println();
    }

    // Lưu mảng đc sx
    static void saveArrayToFile(int[] b, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < b.length; i++) {
                writer.write(b[i] + ".0");
                if (i < b.length - 1) {
                    writer.write(" ");
                }
            }
        } catch (IOException e) {
            System.out.println("IOException" + e.getMessage());
        }
    }

    // Lưu KQ CN6,7
    static void saveStringToFile(String st, String fileName) {
        try (FileWriter fw1 = new FileWriter(fileName);
             BufferedWriter bw1 = new BufferedWriter(fw1)) {
            bw1.write(st);
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
    }

    // CHỨC NĂNG 1:
    static void writeFile(int[] arr) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("INPUT.txt"))) {
            for (int i = 0; i < arr.length; i++) {
                writer.write(Integer.toString(arr[i]));
                if (i < arr.length - 1) {
                    writer.write(" ");
                }
            }
        } catch (IOException io) {
            System.out.println("IO Exception" + io.getMessage());
        }
    }

    // CHỨC NĂNG 2:
    static int[] fileInput(String filePath, int[] a) {
        try (FileReader fr1 = new FileReader(filePath);
             BufferedReader br1 = new BufferedReader(fr1)) {
            String line = "";
            while (true) {
                line = br1.readLine();
                if (line == null) {
                    break;
                }
                String[] inputArray = line.split(" ");
                a = new int[inputArray.length];

                // Chuyển đổi chuỗi thành số nguyên
                for (int i = 0; i < inputArray.length; i++) {
                    a[i] = Integer.parseInt(inputArray[i]);
                }

                // In ra mảng a
                System.out.print("Input array: '");
                for (int i = 0; i < a.length; i++) {
                    System.out.print(a[i]);
                    // Thêm dấu cách nếu không phải phần tử cuối cùng
                    if (i < a.length - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println("'");
            }
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
        return a;
    }

    // CHỨC NĂNG 3:
    static int[] bubbleSort(int[] b) {
        int n = b.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (b[i] > b[j]) {
                    int temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
            printArray(b);
        }
        return b;
    }

    // CHỨC NĂNG 4:
    static int[] selectionSort(int[] b) {
        int n = b.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                // TÌM MIN[i,n]
                if (b[j] < b[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int t = b[i];
                b[i] = b[minIndex];
                b[minIndex] = t;
            }
            printArray(b);
        }
        return b;
    }

    //CHỨC NĂNG 5:
    static int[] insertionSort(int[] b) {
        int n = b.length;
        for (int i = 1; i < n; i++) {
            int bi = b[i];
            int j = i - 1;
            while (j >= 0 && b[j] > bi) {
                b[j + 1] = b[j];
                j--;
            }
            b[j + 1] = bi;
            printArray(b);
        }
        return b;
    }

    //CHỨC NĂNG 6:
    static String linearSearch(int[] b, int value) {
        int n = b.length;
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (b[i] > value) {
                arr.add(i);
            }
        }
        if (!arr.isEmpty()) {
            String result1 = "Large position:";
            for (Integer element : arr) result1 += " " + element;
            saveStringToFile(result1, "OUTPUT4.txt");
            return result1;
        } else {
            String result2 = "The value does not exist!";
            saveStringToFile(result2, "OUTPUT4.txt");
            return result2;
        }
    }

    // CHỨC NĂNG 7:
    static String binarySearch(int[] b, int value) {
        int n = b.length;
        int iLeft = 0;
        int iRight = n - 1;
        String result1 = "The right position: ";
        String result2 = "The value does not exist!";
        while (iLeft <= iRight) {
            int iMid = (iLeft + iRight) / 2;
            if (value == b[iMid]) {
                result1 += iMid;
                saveStringToFile(result1, "OUTPUT5.txt");
                return result1;
            } else if (value > b[iMid]) {
                iLeft = iMid + 1;
            } else {
                iRight = iMid - 1;
            }
        }
        saveStringToFile(result2, "OUTPUT5.txt");
        return result2;
    }
}
