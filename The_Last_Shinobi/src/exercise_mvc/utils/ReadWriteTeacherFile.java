package exercise_mvc.utils;

import exercise_mvc.model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteTeacherFile {
    private static List<String> readFile(String path) {
        List<String> stringList = new ArrayList<>();
        String line;
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringList;
    }

    public static List<Teacher> readTeacherFile(String path) {
        List<String> stringList = readFile(path);
        List<Teacher> teacherList = new ArrayList<>();
        String[] info;
        for (String line : stringList) {
            info = line.split(",");
            teacherList.add(new Teacher(Integer.parseInt(info[0]), info[1], info[2], info[3], info[4]));
        }

        return teacherList;
    }

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
