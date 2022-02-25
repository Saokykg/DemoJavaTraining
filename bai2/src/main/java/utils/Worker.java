package utils;

public class Worker extends Human{
    private float weakSalary;
    private float workHoursPerDay;

    public  Worker(String firstName, String lastName, float weakSalary, float workHoursPerDay){
        super(firstName, lastName);
        this.weakSalary = weakSalary;
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    public String toString() {
        return String.format("%s %s \nWeak salary: %.2f \nWork hours per day: %.2f",
                this.getFirstName(), this.getLastName(), this.getWeakSalary(), this.getWorkHoursPerDay());
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
}
