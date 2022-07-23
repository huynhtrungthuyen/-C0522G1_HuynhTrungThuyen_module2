package ss16_io_text_file.exercise.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCopy {
    public static List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        String line;
        int sum = 0;

        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                sum += line.length();
                list.add(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Số kí tự có trong file: " + sum);
        return list;
    }

    public static void writeFile(String path, List<String> list) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String item : list) {
                bufferedWriter.write(item);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String sourcePath = "src/ss16_io_text_file/exercise/copy_file_text/source.csv";
        String targetPath = "src/ss16_io_text_file/exercise/copy_file_text/target.csv";
        FileCopy.writeFile(targetPath, FileCopy.readFile(sourcePath));
    }
}
