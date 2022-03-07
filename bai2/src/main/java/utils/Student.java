package utils;

public class Student extends Human implements Comparable<Student>{
    private int grade;

    public Student(String firstName, String lastName, int grade){
        super(firstName, lastName);
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%s - grade %d \n", super.toString(), this.getGrade());
    }

    @Override
    public int compareTo(Student student) {
        return this.grade > student.grade ? 0 : 1; //check -1 0 1 collection.sort
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
