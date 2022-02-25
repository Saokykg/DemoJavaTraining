package utils;

public class Student extends Human {
    private int grade;

    public Student(String firstName, String lastName, int grade){
        super(firstName, lastName);
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%s %s \ngrade: %d", this.getFirstName(), this.getLastName(), this.getGrade());
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
