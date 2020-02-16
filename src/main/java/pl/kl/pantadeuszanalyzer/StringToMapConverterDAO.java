package pl.kl.pantadeuszanalyzer;

import java.util.Map;
import java.util.TreeMap;

public class StringToMapConverterDAO implements ConverterDAO{

    private ReaderDAO readerDAO;

    public StringToMapConverterDAO(ReaderDAO readerDAO) {
        this.readerDAO = readerDAO;
    }


    @Override
    public Map<String, Integer> convertStringToMap(String book) {

        Map<String, Integer> wordMap = new TreeMap<>();

        String[] words = book.toLowerCase().replaceAll("[,.();…/0-9*«»?:!—\\-]", "").split("\\s+");

        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        return wordMap;
    }
}
