// Rahul Chaudhari
// FILE PATH .\\lib\\Records.csv
import java.util.List;

/**
 * A Helper Class to insert students objects into hashtable using double hashing
 */
public class DoubleHashing {
    private int size;
    private Student[] table;
    private int step_counter_insert;
    private int p;
    private int q;
    private int step_counter_find;


    /**
     * @param size of the hashtable
     * 
     */
    public DoubleHashing(int size) {
        this.size = size;
        table = new Student[size];
        this.step_counter_insert = 0;
        p = size;
        q = p - 13;
        this.step_counter_find = 0;

    }

    /**
     * getter function to get the step_counter_insert (probing Sequence)
     * @return step count of inserting
     */
    public int get_step_counter_insert() {
        return step_counter_insert;
    }

    /**
     * getter function to get the step_counter (probing Sequence)
     * @return step count of finding
     */
    public int get_step_counter_find() {
        return step_counter_find;
    }

    /**
     * @param key hashing key of the object
     * @return index postion given by h(key) fuction
     */
    private int hash_h(int key) {
        int index = key % size; // h(key) = key % p {p = tableSize}
        return index;
    }

    /**
     * @param key hashing key of the object
     * @return index postion given by g(key) fuction
     */
    private int hash_g(int key) {
        // making sure q is not less than 2, which is a prime number
        if (q < 2) {
            q = 2;
        }
        int index = q - (key % q); // g(key) = q - (key % q) { 2 < q < p}
        return index;
    }

    /**
     * @param key hashing key of the object
     * @param i   probing index
     * @return final index postion after double hashing
     */
    private int hash_h_g_i(int key, int i) {
        int index = (hash_h(key) + i * hash_g(key)) % p; // when i = 0, its same has h(key) % tablesize
        return index;
    }

    /**
     * Insert a student into the hash table
     * 
     * @param newStudent the object to be inserted
     */
    public void insert(Student newStudent) {
        int key = Math.abs(newStudent.hashCode());
        int index = hash_h_g_i(key, 0);
        int i = 1;
        while (table[index] != null && i < size) { // i < size , N-1 max probing
            index = hash_h_g_i(key, i); // this way h(key) & g(key) will be same and i will keep changing
            i++;
            step_counter_insert++; // calculating the probing sequence count
        }
        if (table[index] == null) { // Check if the postion is empty
            table[index] = newStudent;
        } else {
            return; // use the return so that the output is not clustred while running simulation.
            // use the System.rr.printLn line while running sample run to see if some element is not 
            // in the has table
            // System.err.println(" Unable to insert student: " + newStudent.get_student_name());
        }
    }

    /**
     * Find a student in the hash table
     * 
     * @param findStudent the object to be found
     */
    public boolean find(Student findStudent) {
        int key = Math.abs(findStudent.hashCode());
        int index = hash_h_g_i(key, 0); // when i = 0, it is same has h(key) % size
        int i = 1;
        do { // using do while because when size is 1, it should do at least one comparison for index 0.
            
            if (table[index] != null && table[index].equals(findStudent)) {
                return true;
            }
            step_counter_find++; // how many steps it took before find or not finding element (Probing Squence)
            index = hash_h_g_i(key, i); // this way h(key) & g(key) will be same and i will keep changing
            i++;
        } while (table[index] != null && i < size);
        return false;
    }

    /**
     * main method to test the DoubleHashTable 
     * @param args
     */
    public static void main(String[] args) {
        // Creating the DoubleHashing object with size 100
        DoubleHashing hashTable = new DoubleHashing(100);

        // Readng the student list from the file
        List<Student> students = DataReader.Load_student_data_from_file(".\\lib\\Records.csv");

        // Insertin each student into the hash table one at a time
        for (Student student : students.subList(0, 100)) {
            hashTable.insert(student);
        }
        // Printing the contents of the table just to see if there are open postion for debugging
        // int one = 1;
        // for (Student student : hashTable.table) {
        //     System.out.println(one + " ");
        //     if (student != null) {
        //         System.out.println(student.get_student_name() + "\n");
        //     }
        //     one++;
        // }

        System.out.print("\n\n\n"); // clearing up space as some element might be not added
        System.out.println("Creating an existing student: ");
        Student existing_student = new Student("2-721-110-5276", "Cedrick Everett", "Cedrick_Everett604@bungar.biz",
                "Ecology");

        boolean found_existing = hashTable.find(existing_student);
        System.out.println("Exsisting student found Successful: " + found_existing);
        System.out.println("\nCreating an non existing student: ");
        Student non_existing_student = new Student("660-280-5213", "Rahul Chaudhari", "oe51384@truman.edu", "CS310");
        
        boolean found_non_existing = hashTable.find(non_existing_student);
        System.out.println("Non Exsisting student found (UnSuccessful): " + found_non_existing);
    }
}