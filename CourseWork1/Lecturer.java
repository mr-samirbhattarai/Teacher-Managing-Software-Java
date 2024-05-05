package CourseWork1;

/**
 * This is CourseWork1.Lecturer class which is child class of CourseWork1.Teacher class.
 *
 * @author (Samir Bhattarai)
 * @version (2024/01/11)
 */

public class Lecturer extends Teacher   //creating class, CourseWork1.Lecturer
{
    //declaring variables
    private String department;
    private int yearsOfExperience;
    private int gradedScore;
    private boolean hasGraded;

    //creating constructor
    public Lecturer(int teacherId, String teacherName, String address, String workingType, String employmentStatus, String department, int yearsOfExperience)
    {
        super(teacherId, teacherName, address, workingType, employmentStatus);
        this.department=department;
        this.yearsOfExperience=yearsOfExperience;
        this.gradedScore=0;
        this.hasGraded=false;
    }

    // creating getter/accessor method
    public String getDepartment(){
        return department;
    }

    public int getYearsOfExperience(){
        return yearsOfExperience;
    }

    public int getGradedScore(){
        return gradedScore;
    }

    public boolean getHasGraded(){
        return hasGraded;
    }

    //creating setter method
    public void setGradedScore(int gradedScore){
        this.gradedScore = gradedScore;
    }

    // creating method gradeAssignment
    public void gradeAssignment(int gradedScore, String department, int yearsOfExperience){
        if(yearsOfExperience >= 5 && this.department == department){
            if(gradedScore >=70 && gradedScore <= 100){
                System.out.println("Your grade is A");
            }else if(gradedScore >=60 && gradedScore < 70){
                System.out.println("Your grade is B");
            }else if(gradedScore >=50 && gradedScore < 60){
                System.out.println("Your grade is C");
            }else if(gradedScore >=40 && gradedScore < 50){
                System.out.println("Your grade is D");
            }else{
                System.out.println("Your grade is F");
            }
            this.hasGraded = true;
            this.gradedScore = gradedScore;
        }else{
            System.out.println("Your grade is not assigned");
        }
    }

    /* in this condition, if year of experience is more than 5 and if department matches,
     * and if graded score is between 70 and 100 output is given A,
     * if graded score is between 60 to69 output is given B,
     * if graded score is between 50 and 59 output is given C,
     * if graded score is between 40 and 49 output is given D,
     * if graded score is between 0 and 39 output is given E,
     * and variable hasGraded is changed to true,
     * but if condition does not match it gives the output graded not assigned
     */

    //creating method display
    public void display(){
        super.display();    //calls display method from parent class(superclass) CourseWork1.Teacher and display
        System.out.println("Department:" + department); //display department
        System.out.println("Years of Experience:" + yearsOfExperience); //display year of experience    
        if(hasGraded){  //checking condition for graded score using if else
            System.out.println("Graded Score:" + gradedScore);
        }else if (!hasGraded){
            System.out.println("GradedScore: Not Graded yet");
        }
        /* in this condition, if hasgraded is true then corresponding value is displayed,
         * else the message is displayed saying Not Graded yet
         */
    }
}