package utils;

public class Worker extends Human implements Comparable<Worker>{
    private float weakSalary;
    private float workHoursPerDay;

    public  Worker(String firstName, String lastName, float weakSalary, float workHoursPerDay){
        super(firstName, lastName);
        this.weakSalary = weakSalary;
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    public String toString() {
        return String.format("%s - Weak salary: %.2f - Work hours: %.2f %.2f \n",
                super.toString(), this.getWeakSalary(), this.getWorkHoursPerDay(), this.MoneyPerHour());
    }

    public float MoneyPerHour(){
        try {
            return this.getWeakSalary() / (this.getWorkHoursPerDay() * 6);
        }
        catch (ArithmeticException ex){
            System.out.println(ex);
        }
        return 0;
    }

    public float getWeakSalary() {
        return weakSalary;
    }

    public void setWeakSalary(float weakSalary) {
        this.weakSalary = weakSalary;
    }

    public float getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    public void setWorkHoursPerDay(float workHoursPerDay) {
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    public int compareTo(Worker worker) {
        return this.MoneyPerHour() > worker.MoneyPerHour() ? 1 : 0;
    }
}
