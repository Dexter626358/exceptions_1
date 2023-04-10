package org.example;

import java.util.Random;

public class Main {
    static Random rnd = new Random();
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            task1();
        }
    }

    static void task1() {
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

    static int[] generateArray(){
        int maxSize = rnd.nextInt(1, 5);
        int[] array = new int[maxSize];
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(0, 100);
        }

        return array;
    }


    static int[] diffArrays(int[] array1, int[] array2){
    if(array1.length != array2.length) {
        throw new RuntimeException(String.format("Количество элементов в массивах должно быть одинаково. \nРазмер первого массива: %d\nРазмер второго массива: %d\n", array1.length, array2.length));
    }
    int[] newArray = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            newArray[i] = array1[i] - array2[i];
        }
        return newArray;
    }

    static int[] divArrays(int[] array1, int[] array2){
        if(array1.length != array2.length) {
            throw new RuntimeException(String.format("Количество элементов в массивах должно быть одинаково. \nРазмер первого массива: %d\nРазмер второго массива: %d\n", array1.length, array2.length));
        }
        int[] newArray = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            newArray[i] = array1[i] / array2[i];
        }
        return newArray;
    }

    static void printer(int[] array){
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println("\n");
    }



}