// Rahul Chaudhari
// FILE PATH .\\lib\\Records.csv
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// For Testing Purpose, Terminal was not able to show all the 2000 lines of data, it was showing only half.
// used this FileWriter so that all the data being read can be verified during debugging
// import java.io.FileWriter;

/**
 * A Helper Class to Read the Contains of a File
 */
public class DataReader {
    /**
     * Reads the files and insert it into a Array List
     * @param file_path the path where the file is located
     * @return the list of students objects read from the records file
     */
    public static List<Student> Load_student_data_from_file(String file_path) {
        List<Student> students_list = new ArrayList<>();
        try (BufferedReader read_data = new BufferedReader(new FileReader(file_path))) {
            String one_line;

            // Skip the header of the file which is phone,name,email,course
            String header = read_data.readLine();

            while ((one_line = read_data.readLine()) != null) {
                // System.out.println(one +" "+ one_line); used during printing

                // if the file has missing rows for example as follows:
                // 0-230-367-7323,Camden Long,Camden_Long9539@famism.biz,Health
                //
                // 7-241-634-6332,Noah Oliver,Noah_Oliver9716@fuliss.net,Ecology
                if (one_line.trim().isEmpty()) {
                    continue;
                }
                String[] elements_of_student = one_line.split(",");
                if (elements_of_student.length == 4) {
                    String phone = elements_of_student[0].trim(); // trim function deletes the whitespaces
                    String name = elements_of_student[1].trim();
                    String email = elements_of_student[2].trim();
                    String course = elements_of_student[3].trim();
                    students_list.add(new Student(phone, name, email, course));
                } else {
                    System.err.println("Info Missing of Following Line : " + one_line);
                }
            }
        } catch (IOException error) {
            System.err.println("Following Error Occurred: " + error.getMessage());
        } catch (OutOfMemoryError e) {
            System.err.println("Too Many Values to store in Array" + e.getMessage());
        } 
        return students_list;
    }
    // Used for Testing purpose while writing a file and check for it. 
    // public static void main(String[] args) throws IOException {
    //     List<Student> students = Load_student_data_from_file(".\\lib\\Records.csv");
    //     int one = 1; // for counting the index if all the data are read
    //     try {
    //         FileWriter myfilewrite = new FileWriter(".\\lib\\test.txt");
    //         // // Print student information in the file
    //         for (Student student : students) {
    //             myfilewrite.write(one + "       " + student.get_phone_number() + " "
    //                     + student.get_student_name() + " " + student.get_student_email()
    //                     + " " + student.get_course() + "\n");
    //             one++; // increasing the index
    //         }
    //         myfilewrite.close();
    //     } catch (IOException error) {
    //         System.err.println(error.getMessage());
    //     }
    // }
}
