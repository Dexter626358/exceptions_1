package org.example;

import java.util.Random;

public class Main {
    static Random rnd = new Random();
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            task1();
        }

        for (int i = 0; i < 10; i++) {
            task2();
        }
    }

    static void task1() {  // метод вычитания массивов с проверкой исключений
        try {
            int[] array1 = generateArray();
            int[] array2 = generateArray();
            int[] diffArray = diffArrays(array1, array2);
            System.out.println("Первый массив имеет вид:");
            printer(array1);
            System.out.println("Второй массив имеет вид:");
            printer(array2);
            System.out.println("Итоговый массив: ");
            printer(diffArray);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println();

            }
        }

    static void task2() {  // деление одного массива на другой с проверкой исключения
        try {
            int[] array1 = generateArray();
            int[] array2 = generateArray();
            double[] divArray = divArrays(array1, array2);
            System.out.println("Первый массив имеет вид:");
            printer(array1);
            System.out.println("Второй массив имеет вид:");
            printer(array2);
            System.out.println("Итоговый массив: ");
            printer(divArray);
        }catch(RuntimeException e){  // вывод исключения
            System.out.println(e.getMessage());
            System.out.println();
        }

    }


    static int[] generateArray(){  // метод заполнения нового массива
        int maxSize = rnd.nextInt(0, 5);  // случайная генерация размера массива
        int[] array = new int[maxSize];
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(0, 100);  // заполнение массива случайными числами
        }

        return array;
    }


    static int[] diffArrays(int[] array1, int[] array2){  // метод вычитания элементов одного массива из элементов другого
        if(array1 == null || array2 == null || array1.length == 0 || array2.length == 0){
            throw new NullPointerException("Один из массивов не существует");  // проверка массива на существование
        }

        if(array1.length != array2.length) {  // проверка размеров массивов
            throw new RuntimeException(String.format("Количество элементов в массивах должно быть одинаково. \nРазмер первого массива: %d\nРазмер второго массива: %d\n", array1.length, array2.length));
        }
        int[] newArray = new int[array1.length];
            for (int i = 0; i < array1.length; i++) {
                newArray[i] = array1[i] - array2[i];  // вычитание элементов массива
            }
            return newArray;
    }

    static double[] divArrays(int[] array1, int[] array2){  //  метод деления элементов одного массива на другой
        if(array1 == null || array2 == null || array1.length == 0 || array2.length == 0){
            throw new RuntimeException("Один из массивов не существует");  // проверка существования массива
        }

        if(array1.length != array2.length) {  //   проврка совпадания количества элементов в массивах
            throw new RuntimeException(String.format("Количество элементов в массивах должно быть одинаково. \nРазмер первого массива: %d\nРазмер второго массива: %d\n", array1.length, array2.length));
        }
        double[] newArray = new double[array1.length];
        for (int i = 0; i < array1.length; i++) {
            if(array2[i] == 0){  // проверка деления на ноль
                throw new RuntimeException("Второй массив содержит ноль. Деление на ноль не возможно.");
            }
            newArray[i] =  Math.round((double) array1[i] / array2[i]);  // деление элементов массива
        }
        return newArray;
    }

    static void printer(int[] array){  // метод вывода на печать массива типа int
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println("\n");
    }

    static void printer(double[] array){ // метод вывода на печать массива типа double
        for (double item : array) {
            System.out.print(item + " ");
        }
        System.out.println("\n");
    }



}