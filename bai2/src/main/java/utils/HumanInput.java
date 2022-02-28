package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class HumanInput {
    public static List<Student> studentList() throws IOException {
        FileInputStream fi = null;
        List<Student> studentList = new ArrayList<>();
        try {
            fi = new FileInputStream("src/input/student.txt");
            int i = 0;
            String tmp = "";
            List<String> student = new ArrayList<>();
            while ((i = fi.read()) != -1){
                switch (i){
                    case 10:
                        student.add(tmp);
                        tmp = "";
                        studentList.add(new Student(student.get(0), student.get(1), Integer.parseInt(student.get(2))));
                        student.clear();
                        break;
                    case 32:
                        student.add(tmp);
                        tmp="";
                        break;
                    default:
                        tmp+= (char) i;
                        break;
                }
            }
            fi.close();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            fi.close();
        }

        return studentList;
    }

    public static List<Worker> workerList() throws IOException {
        FileInputStream fi = null;
        List<Worker> workerList = new ArrayList<>();
        try {
            fi = new FileInputStream("src/input/worker.txt");
            int i = 0;
            String tmp = "";
            List<String> worker = new ArrayList<>();
            while ((i = fi.read()) != -1){
                switch (i){
                    case 10:
                        worker.add(tmp);
                        tmp = "";
                        workerList.add(new Worker(worker.get(0),
                                    worker.get(1),
                                    Float.parseFloat(worker.get(2)),
                                    Float.parseFloat(worker.get(3))));
                        worker.clear();
                        break;
                    case 32:
                        worker.add(tmp);
                        tmp="";
                        break;
                    default:
                        tmp+= (char) i;
                        break;
                }
            }
            fi.close();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            fi.close();
        }

        return workerList;
    }
}
