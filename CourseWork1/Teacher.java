package CourseWork1;

/**
 * This is the CourseWork1.Teacher class which is the parent class of CourseWork1.Lecturer and CourseWork1.Tutor classes.
 *
 * @author (Samir Bhattarai )
 * @version (2024/01/10)
 */
public class Teacher   // creating class, CourseWork1.Teacher
{
    //declaring variable
    private int teacherId;
    private String teacherName;
    private String address;
    private String workingType;
    private String employmentStatus;
    private int workingHours;

    //creating constructor CourseWork1.Teacher
    public Teacher(int teacherId, String teacherName, String address, String workingType, String employmentStatus){
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.address = address;
        this.workingType = workingType;
        this.employmentStatus = employmentStatus;
    }

    //creating getter/accessor method
    public int getTeacherId(){
        return teacherId;
    }

    public String getTeacherName(){
        return teacherName;
    }

    public String getAddress(){
        return address;
    }

    public String getWorkingType(){
        return workingType;
    }

    public String getEmploymentStatus(){
        return employmentStatus;
    }

    public int getWorkingHours(){
        return workingHours;
    }

    //creating setter method
    public void setWorkingHours(int workingHours){
        this.workingHours = workingHours;
    }

    // creating method display
    public void display(){
        System.out.println("CourseWork1.Teacher Id: "+ getTeacherId()); //displaying teacher id
        System.out.println("CourseWork1.Teacher Name: "+teacherName);   //displaying teacher name
        System.out.println("Address: " +getAddress());  //displaying address
        System.out.println("Working Type: " +workingType);  //displaying working type
        System.out.println("Employment Status: "+getEmploymentStatus());    //displaying employment status
        if(workingHours <= 0 ){
            System.out.println("Working hour: Not assigned");
        }else{
            System.out.println("Working Hours: "+this.workingHours);
        }
        /* if workingHours is less or equal to zero then output is Not assigned.
         * but if workingHours is greater than 0 then output is given the working hour
         */
    }
}
