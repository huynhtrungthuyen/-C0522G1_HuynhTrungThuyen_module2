package exercise_mvc.utils;

import exercise_mvc.model.Teacher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteTeacherFile {
    private static void writeFile(String path, String data) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeTeacherFile(String path, List<Teacher> teachers) {
        StringBuilder data = new StringBuilder();
        for (Teacher teacher : teachers) {
            data.append(teacher.getInfo());
        }

        writeFile(path, data.toString());
    }
}
