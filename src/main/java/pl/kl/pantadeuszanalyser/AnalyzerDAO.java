package pl.kl.pantadeuszanalyser;

import java.util.Map;

public interface AnalyzerDAO {

    void findMostCommonWord(Map<String, Integer> wordMap);

    void find5MostCommonWords(Map<String, Integer> wordMap);

    void printSingleWords(Map<String, Integer> wordMap);

    void printWordsWithOccurrences(Map<String, Integer> wordMap);

    void printNumberOfWords(Map<String, Integer> wordMap);
}
