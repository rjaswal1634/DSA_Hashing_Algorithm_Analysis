// Rahul Chaudhari
import java.util.Objects;

// Student class with their details of phone, name, email, course
public class Student {
    private String phone;
    private String name;
    private String email;
    private String course;

    /**
     * Default Constructor for empty values
     */
    public Student() {
        // using the constructor method to assign empty value to the default constructor
        this("000-000-0000", "", "", "");
    }

    // Constructor
    /**
     * this function takes 4 strings and assignents it to respective private
     * variable of studnet class
     * 
     * @param phone  number of the student
     * @param name   of the studnet
     * @param email  of the the student
     * @param course taken by the student
     */
    public Student(String phone, String name, String email, String course) {
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    /**
     * getter function for phone number of the student.
     * 
     * @return The phone number of the student.
     */
    public String get_phone_number() {
        return phone;
    }

    /**
     * getter function for the name of the student.
     * 
     * @return The name of the student.
     */
    public String get_student_name() {
        return name;
    }

    /**
     * getter function for the email of the student.
     * 
     * @return The email of the student.
     */
    public String get_student_email() {
        return email;
    }

    /**
     * getter function for the course information of the student
     * 
     * @return The course information of the student.
     */
    public String get_course() {
        return course;
    }

    // Setters
    /**
     * Setter function for the phone of the student.
     * 
     * @param phone The name to phone for the student.
     */
    public void set_phone_number(String phone) {
        this.phone = phone;
    }

    /**
     * Setter function for the name of the student.
     * 
     * @param name The name to set for the student.
     */
    public void set_student_name(String name) {
        this.name = name;
    }

    /**
     * Setter function for the email of the student.
     * 
     * @param email The email to set for the student.
     */
    public void set_student_email(String email) {
        this.email = email;
    }

    /**
     * Setter function for the course information of the student.
     * 
     * @param course The course information to set for the student.
     */
    public void set_course(String course) {
        this.course = course;
    }

    /**
     * Computes the hash code for the student object.
     * 
     * @return The hash code value for the student.
     */
    @Override
    public int hashCode() {
        int hash_value = 13; // sets of prime numbers should be used to make it unique.
        hash_value = 29 * hash_value + Objects.hashCode(phone);
        hash_value = 29 * hash_value + Objects.hashCode(name);
        hash_value = 29 * hash_value + Objects.hashCode(email);
        hash_value = 29 * hash_value + Objects.hashCode(course);
        return hash_value;
    }

    /**
     * Checks if the student object is equal to another object.
     * 
     * @param other_student The object to compare with the student.
     * @return True if the student is equal to the other object, false otherwise.
     */
    @Override
    public boolean equals(Object other_student) {
        if (other_student == null || (this.getClass() != other_student.getClass())) {
            return false;
        }
        if (this == other_student) {
            return true;
        }
        Student comparable_other_student = (Student) other_student; // type cast object to student class
        // Objects.equals() method can be also used as we are importing util.Objects
        boolean flag = this.phone.equals(comparable_other_student.phone)
                && this.name.equals(comparable_other_student.name)
                && this.email.equals(comparable_other_student.email)
                && this.course.equals(comparable_other_student.course);
        return flag;
    }

    // Used for testing purpose of the student class if the code is running well.
    // public static void main(String[] args) {
    //     Student student1 = new Student("660-280-5213", "Rahul Chaudhari",
    //             "oe51384@truman.edu", "CS310");
    //     Student student2 = new Student("515-388-0855", "Aditiya Shah",
    //             "ve21851@truman.edu", "CS191");
    //     Student student3 = new Student();
    //     // Testing HashCode function
    //     System.out.println("Hash code for student1: " + student1.hashCode());
    //     System.out.println("Hash code for student2: " + student2.hashCode());
    //     System.out.println(student3.get_phone_number()); // testing empty constructor // see output 000-000-0000
    //     // Testing Equal Operator
    //     System.out.println("Are student 1 and 2 the same person? " +
    //             student1.equals(student2));
    // }

}
