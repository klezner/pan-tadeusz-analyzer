package pl.kl.pantadeuszanalyser;

import java.util.Map;

public class BookAnalyzerDAO implements AnalyzerDAO {

    private ConverterDAO converterDAO;

    public BookAnalyzerDAO(ConverterDAO converterDAO) {
        this.converterDAO = converterDAO;
    }

    @Override
    public void findMostCommonWord(Map<String, Integer> wordMap) {

    }

    @Override
    public void find5MostCommonWords(Map<String, Integer> wordMap) {

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
}
