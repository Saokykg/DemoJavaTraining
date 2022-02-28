package utils;

import utils.GlobalPara;
import utils.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    public List<Student> sortListStudent(){
        List<Student> listStudents = GlobalPara.studentList;
        Collections.sort(listStudents,new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getGrade() > o2.getGrade() ? 1 : -1;
            }
        });
        return listStudents;
    }

    public List<Worker> sortListWorker(){
        List<Worker>listWorkers= GlobalPara.workerList;
        Collections.sort(listWorkers, new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                return (int) (o1.MoneyPerHour() - o2.MoneyPerHour());
            }
        });
        return listWorkers;
    }

    public List<Human> sortListHuman(){
        List<Human> listHuman = new ArrayList<>();
        listHuman.addAll(GlobalPara.workerList);
        listHuman.addAll(GlobalPara.studentList);
        Collections.sort(listHuman, new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        return listHuman;
    }
}
