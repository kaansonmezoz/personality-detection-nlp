package nlp.personalitydetection.preprocessing.fileoperations.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextReader {
    public List<String> readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        List<String> lines = new ArrayList<>();
        String line;

        while((line = reader.readLine()) != null){
            lines.add(line);
        }

        reader.close();

        return lines;
    }
}
