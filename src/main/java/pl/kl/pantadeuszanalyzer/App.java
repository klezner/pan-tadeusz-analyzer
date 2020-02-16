package pl.kl.pantadeuszanalyzer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class App {
    public static void main(String[] args) throws MalformedURLException {

        URL urlPanTadeusz = new URL("https://wolnelektury.pl/media/book/txt/pan-tadeusz.txt");

        FileToStringReaderDAO panTadeuszToStringReader = new FileToStringReaderDAO(urlPanTadeusz);
        String panTadeuszAsAstring = panTadeuszToStringReader.loadBookToString();

        StringToMapConverterDAO pandTadeuszToMapConverter = new StringToMapConverterDAO(panTadeuszToStringReader);
        Map<String, Integer> panTadueszMapOfWords = pandTadeuszToMapConverter.convertStringToMap(panTadeuszAsAstring);

        BookAnalyzerDAO panTadeuszAnalyzer = new BookAnalyzerDAO(pandTadeuszToMapConverter);
        panTadeuszAnalyzer.findMostCommonWord(panTadueszMapOfWords);
        panTadeuszAnalyzer.find5MostCommonWords(panTadueszMapOfWords);
        panTadeuszAnalyzer.printSingleWords(panTadueszMapOfWords);
        panTadeuszAnalyzer.printNumberOfWords(panTadueszMapOfWords);
        panTadeuszAnalyzer.printWordsWithOccurrences(panTadueszMapOfWords);
    }
}
