package Seminar_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DictionaryOfWords {
    public Map<String, Integer> dict;
    private ArrayList<String> arr;
    private String str = "";

    public DictionaryOfWords() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("")) { // Считываем строку пока не введем пустой символ
            str = str.concat(line + " ");
        }
        arr = strToArr(str);
        dict = arrToDict(arr);
    }

    private static ArrayList<String> strToArr(String str) {
//        Метод для преобразования строки в список слов
        ArrayList<String> array = new ArrayList<>();
        for (String elem: str.split(" ")) {
            if (DictionaryOfWords.isRussian(elem) & !elem.equals(""))
                array.add(elem.toLowerCase());
        }
        return array;
    }

    private static Map<String, Integer> arrToDict(ArrayList<String> array) {
//      Метод преобразующий список слов и количество каждого слова в списке в словарь
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        int count;
        String elem;
        while (!array.isEmpty()) {
            count = 0;
            elem = array.get(0);
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).equals(elem))
                    count++;
            }
            dictionary.put(elem, count);
            for (int i = 0; i < count; i++)
                array.remove(elem);
        }
        return dictionary;
    }

    private static boolean isRussian (String elem) {
//        Метод для проверки того, что введенное слово - русское
        String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        for (int i = 0; i < elem.length(); i++) {
            if (alphabet.indexOf(elem.charAt(i)) == -1) return false;
        }
        return true;
    }
}
