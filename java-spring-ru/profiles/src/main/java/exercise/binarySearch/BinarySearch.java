package exercise.binarySearch;

import java.util.Arrays;

public class BinarySearch {
    public static int bin(int[] arr, int item) {
        //поиск происходит по принципу много мало
        //есть х - правильный ответ (item), arr - массив чисел, guess - число, которое программа пробует угадать.
        //если guess меньше правильного ответа, то минимальная планка поднимается на уровень угадки
        //если guess больше правильного ответа, то максимальная планка снижается на уровень угадки
        int res = 0;
        int min = 0;
        int max = arr.length-1;
        while(min<=max) {
            int mid = (min + max);
            int guess = arr[mid];
            if (guess == item) {
                res = mid;
            }
            if (guess > item) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        System.out.println(bin(arr, 2));

    }
}
