import utils.*;

import java.io.IOException;
import java.util.List;

public class main {



    public static void main(String[] args) throws IOException {
        GlobalPara.studentList = HumanInput.studentList();
        GlobalPara.workerList = HumanInput.workerList();

        System.out.println(GlobalPara.studentList);
        System.out.println(GlobalPara.workerList);

        Sorting sort = new Sorting();
        List<Student> stList = sort.sortListStudent();
        System.out.println(stList);

        List<Worker> wkList = sort.sortListWorker();
        System.out.println(wkList);

        GlobalPara.humanList.addAll(GlobalPara.studentList);
        GlobalPara.humanList.addAll(GlobalPara.workerList);

        List<Human> hmList = sort.sortListHuman();
        System.out.println(hmList.toString());


    }
}
