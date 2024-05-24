// Rahul Chaudhari
// FILE PATH .\\lib\\Records.csv
import java.util.List;
import java.util.Random;

/**
 * A Class That Runs the Simulation of QuaraticHashing
 */
public class QuadraticSimul {
    /**
     * Main function to run the Simulation of the Quadratic Probing Algorithm
     * @param args
     */
    public static void main(String[] args) {
        int find_simulation_size = 1000;
        int[] hash_table_sizes = { 1000, 1500, 2000, 3000 };
        int[] input_sizes = { 1000, 1000, 2000, 2000 };
        System.out.println("-------------- Average Calculation of Quadratic Probing --------------");
        for (int i = 0; i < hash_table_sizes.length; i++) {
            int hash_size = hash_table_sizes[i];
            int input_size_value = input_sizes[i];

            QuadraticHashTable Quad_hash_table = new QuadraticHashTable(hash_size);

            // Readng the student list from the file - FILE PATH .\\lib\\Records.csv
            List<Student> students = DataReader.Load_student_data_from_file(".\\lib\\Records.csv");

            // Insertin each student into the hash table one at a time
            for (int j = 0; j < input_size_value; j++) {
                int index = new Random().nextInt(students.size() / 2);
                Student particular_student = students.get(index);
                Quad_hash_table.insert(particular_student);
            }
            int total_steps_insert = Quad_hash_table.get_step_counter_insert(); // this is already Culumative

            // Searching for random Student objects in the hash table
            for (int j = 0; j < find_simulation_size; j++) {
                int index = new Random().nextInt(students.size() / 2);
                Student find_student = students.get(index);
                boolean flag = Quad_hash_table.find(find_student);
            }
            int total_find_steps = Quad_hash_table.get_step_counter_find(); // this is already Culumative

            double average_insert_steps = (double) total_steps_insert / input_size_value;
            double average_find_steps = (double) total_find_steps / find_simulation_size;

            System.out.println("\nHash Table size: " + hash_size + " | Input size: " + input_size_value 
            + " | Average Insert steps: " + average_insert_steps + " | Average Find steps: " + average_find_steps);

        }
    }
}
