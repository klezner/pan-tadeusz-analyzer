package pl.kl.pantadeuszanalyser;

import java.util.*;
import java.util.stream.Collectors;

public class BookAnalyzerDAO implements AnalyzerDAO {

    private ConverterDAO converterDAO;

    public BookAnalyzerDAO(ConverterDAO converterDAO) {
        this.converterDAO = converterDAO;
    }

    @Override
    public void findMostCommonWord(Map<String, Integer> wordMap) {
        String key = wordMap.entrySet().stream()
                .max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .get()
                .getKey();

        System.out.println("Most common word in Pan Tadeusz is: \"" + key + "\"");

    }

    @Override
    public void find5MostCommonWords(Map<String, Integer> wordMap) {
        Map<String, Integer> wordMapSortedByValuesDesc = sortMapByValuesDescending(wordMap);

        List<Map.Entry<String, Integer>> collect = wordMapSortedByValuesDesc.entrySet().stream()
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("5 most common words in Pan Tadeusz are: ");
        for (int i = 0; i < 5; i++) {
            System.out.println("\"" + collect.get(i).getKey() + "\"");
        }
    }

    @Override
    public void printSingleWords(Map<String, Integer> wordMap) {
        List<Map.Entry<String, Integer>> collect = wordMap.entrySet().stream()
                .filter(word -> word.getValue() == 1)
                .collect(Collectors.toList());

        System.out.println("Words that occur in Pan Tadeusz single time: ");
        for (int i = 0; i < collect.size(); i++) {
            System.out.println("\"" + collect.get(i).getKey() + "\"");
        }
    }

    @Override
    public void printWordsWithOccurrences(Map<String, Integer> wordMap) {
        System.out.println("Words occurrences in Pan Tadeusz: ");
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("Word: '" + entry.getKey() + "' occurrs: " + entry.getValue() + " time.");
            } else {
                System.out.println("Word: '" + entry.getKey() + "' occurrs: " + entry.getValue() + " times.");
            }
        }
    }

    @Override
    public void printNumberOfWords(Map<String, Integer> wordMap) {
        System.out.println("Number of different words that occurs in PanTadeusz: " + wordMap.size());
    }

    private Map<String, Integer> sortMapByValuesDescending(Map<String, Integer> wordMap) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        Map<String, Integer> wordMapSortedByValues = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            wordMapSortedByValues.put(entry.getKey(), entry.getValue());
        }

        return wordMapSortedByValues;
    }
}
