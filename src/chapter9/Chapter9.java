package chapter9;

public class Chapter9 {

    /**
     * Метод findindLongestCommonSubstring принимает две строки word1 и word2, для которых нужно найти длину общей
     * подстроки.
     * Внутри метода создается двумерный массив cell, размер которой определяется длинами слов word1 и word2.
     * Затем внутри циклов, где перебираются индексы слов происходит проверка.
     * Если значение буквы word1 по i индексу совпадает со значением буквы word2 по j индексу, то значение в массиве
     * по индексу cell[i][j] равно значению соседа сверху слева увеличенного на единцу, если i и j больше нуля,
     * либо становится единицей, т.к. на гранцие массива.
     * Если же буквы не совпадают, то значение по индексу cell[i][j] равно нулю.
     * Затем происходит просмотр всего массива, чтобы найти максимальное значение подстроки.
     * Метод возвращает сообщение с информацией - какая максимальная длина подстроки для слов word1 и word2.
     */

    public static String findindLongestCommonSubstring(String word1, String word2) {
        int[][] cell = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        cell[i][j] = cell[i - 1][j - 1] + 1;
                    } else {
                        cell[i][j] = 1;
                    }
                } else {
                    cell[i][j] = 0;
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                maxLength=Math.max(maxLength,cell[i][j]);
            }
        }
        return "The Longest Common Substring for " + word1 + " - " + word2 + " = " + maxLength;
    }

    /**
     * Метод findindLongestCommonSubsequence принимает две строки word1 и word2, для которых нужно найти длину общей
     * подпоследовательности.
     * Внутри метода создается двумерный массив cell, размер которой определяется длинами слов word1 и word2.
     * Затем внутри циклов, где перебираются индексы слов происходит проверка.
     * Если значение буквы word1 по i индексу совпадает со значением буквы word2 по j индексу, то значение в массиве
     * по индексу cell[i][j] равно значению соседа сверху слева увеличенного на единцу, если i и j больше нуля,
     * либо становится единицей, т.к. на гранцие массива.
     * Если же буквы не совпадают, то значение рассматривается исходя их индексов:
     *  - Если i и j не равны нулю, то берется максимальное значение между соседом слева и соседом сверху.
     *  - Если только i не равен нулю, то берется значение соседа сверху.
     *  - Если только j не равен нулю, то берется значение соседа слева.
     *  - Если же и i и j равны нулю, то и само значение равно 0.
     * Метод возвращает сообщение с информацией - какая максимальная длина подпоследовательности для слов word1 и word2.
     */

    public static String findindLongestCommonSubsequence(String word1, String word2) {
        int[][] cell = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        cell[i][j] = cell[i - 1][j - 1] + 1;
                    } else {
                        cell[i][j] = 1;
                    }
                } else {
                    if (i > 0 && j > 0) {
                        cell[i][j] = Math.max(cell[i - 1][j], cell[i][j - 1]);
                    } else if (i > 0) {
                        cell[i][j] = cell[i - 1][j];
                    } else if (j > 0) {
                        cell[i][j] = cell[i][j - 1];
                    } else {
                        cell[i][j] = 0;
                    }
                }
            }
        }
        return "The Longest Common Subsequence for " + word1 + " - " + word2 + " = " + cell[word1.length()-1][word2.length()-1];
    }
}
