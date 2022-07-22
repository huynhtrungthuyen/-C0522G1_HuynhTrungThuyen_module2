package ss16_io_text_file.exercise.read_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainCountry {
    public static List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;

        try {
            file = new File(path);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Country> readCountryFile(String path) {
        List<String> strings = readFile(path);
        List<Country> countries = new ArrayList<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            countries.add(new Country(Integer.parseInt(info[0]), info[1], info[2]));
        }

        return countries;
    }

    public static void main(String[] args) {
        String path = "src/ss16_io_text_file/exercise/read_file_csv/country.csv";
        for (Country country : readCountryFile(path)) {
            System.out.println(country);
        }
    }
}
