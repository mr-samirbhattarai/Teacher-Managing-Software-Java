package CourseWork1;

/**
 * This is CourseWork1.Tutor class which is child class of CourseWork1.Teacher  class
 *
 * @author (Samir Bhattarai)
 * @version (2024/01/11-
 */

//creating class CourseWork1.Tutor
public class Tutor extends Teacher
{
    //declaring variables
    private double salary;
    private String specialization;
    private String academicQualifications;
    private int performanceIndex;
    private boolean isCertified;

    //creating constructor CourseWork1.Tutor
    public Tutor(int teacherId, String teacherName, String address, String workingType, String employmentStatus, int workingHours, double salary, String specialization, String academicQualifications, int performanceIndex){
        super(teacherId, teacherName, address, workingType, employmentStatus);
        super.setWorkingHours(workingHours);
        this.salary = salary;
        this.specialization = specialization;
        this.academicQualifications = academicQualifications;
        this.performanceIndex = performanceIndex;
        this.isCertified = false;
    }

    //creating getter/accessor method
    public double getSalary(){
        return salary;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getAcademicQualifications() {
        return academicQualifications;
    }

    public int getPerformanceIndex() {
        return performanceIndex;
    }

    public boolean getIsCertified() {
        return isCertified;
    }

    //creating setter method
    public void setSalary(double newSalary, int newPerformanceIndex)
    {
        if(getWorkingHours() > 20 && newPerformanceIndex >=5){
            if(performanceIndex >= 5 && newPerformanceIndex <= 7){
                this.salary = (newSalary + 0.05 * newSalary);
            }else if(newPerformanceIndex >= 8 && newPerformanceIndex <= 9){
                this.salary = (newSalary + 0.1 * newSalary);
            }else if(newPerformanceIndex==10){
                this.salary = (newSalary + 0.2 * newSalary);
            }
            this.isCertified = true;
            // added later
            this.performanceIndex = newPerformanceIndex;
        }else{
            System.out.println("Sorry! Salary cannot be approved.");
            this.isCertified = false;
        }
        /* in this condition if working hours is more than 20,
         * and if performance index is between 5 and 7 then salary is increased by 5%,
         * if performance index is between 8 and 9 then salary is increased by 10%,
         * if performance index is 10 then salary is increased by 20%,
         * and variable isCertified is changed to true,
         * else suitable message is displayed
         */
    }

    //creating method removeTutor
    public void removeTutor(){
        if(!isCertified){   //if tutor is not certified than the following variables are set to 0
            this.salary = 0;
            this.specialization = "";
            this.academicQualifications = "";
            this.performanceIndex = 0;
            this.isCertified = false;
        }else{
            System.out.println("Can't remove. CourseWork1.Tutor certified");
        }
    }

    //creating method display
    public void display(){
        super.display();    //calls superclass method
        if(isCertified){    //if tutor is certified then salary, specialization, academic qualifications, performance index is displayed
            System.out.println("Salary: " + salary);
            System.out.println("Specialization: " + specialization);
            System.out.println("Academic Qualifications: " + academicQualifications);
            System.out.println("Performance Index: " + performanceIndex);
        }else{
            System.out.println("Not Certified");
        }
    }
}
