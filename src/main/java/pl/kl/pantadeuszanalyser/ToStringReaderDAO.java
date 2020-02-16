package pl.kl.pantadeuszanalyser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ToStringReaderDAO implements ReaderDAO {

    private URL url;

    public ToStringReaderDAO(URL url) {

        this.url = url;
    }

    public String LoadBookToString() {

        StringBuilder bookAsAString = new StringBuilder();

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String readedLine;

            while ((readedLine = in.readLine()) != null)
                bookAsAString.append(readedLine).append("\n");
                in.close();

        } catch (IOException e) {
            System.out.println("End Of File!");
        }
        return bookAsAString.substring(bookAsAString.indexOf("Księga pierwsza"), bookAsAString.indexOf("-----"));
    }
}
