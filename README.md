Hash Table Analysis with Student Data
This repository contains the Java source code for a program that analyzes the performance of two hashing algorithms: 
Quadratic Probing and Double Hashing. The program focuses on the number of probes required to insert and find Student objects within a hash table.

Project Description:
  Implements two hash table classes: QuadraticHashTable and DoubleHashTable.
  Defines a Student class with phone, name, email, and course attributes.
  Calculates a hash value for each Student object (overloaded hashCode()).
  Reads student information from a file (or allows creating a mock dataset).
  Offers functionalities to insert and find Student objects in the hash tables.
  Analyzes the average probing sequences for insert and find operations.

Deliverables: Explained in detailed in the pdf
1. Student Class (Student.java):
   Contains attributes for phone, name, email, and course.
   Implements hashCode() to calculate a hash value for a Student object.
   Implements equals() to compare two Student objects.
2. Data Loading (DataReader.java):
   Reads student information from a file (or generates mock data).
   Creates a vector (or ArrayList) of Student objects.
   Handles file read exceptions.
   
2. Hash Table Classes (QuadraticHashTable.java & DoubleHashTable.java):
   Each class implements a separate hashing algorithm:
   Quadratic Probing
   Double Hashing
   Each class has a constructor to initialize the table size.
   insert(Student) method adds a student object to the hash table.
   find(Student) method searches for a student object in the hash table and returns true/false.

4. Main Driver:
   Tests both QuadraticHashTable and DoubleHashTable functionalities.
   Insert 100 student objects into each hash table.
   Performs successful and unsuccessful find operations for each table.
   Generates screenshots showcasing insert and find operations.

5. Simulation Programs (QuadraticSimul.java & DoubleSimul.java):
   Analyze average probing sequences for insert and find operations.
   Simulate insertions and searches with different input sizes (1000, 1500, 2000, 3000).
   Calculate and record the average number of probes required for each operation.
   Generate a table summarizing the results.
   
6. Analysis Report (PDF):
   Includes all deliverables mentioned above.
   Plots graphs comparing the average probing sequences for both algorithms (insert & find).
   Discusses which algorithm requires fewer probes and explains why.
   Compares performance of both algorithms for different input sizes and hash table sizes.

Getting Started:
  Clone or download this repository.
  Install Java and a compatible IDE (e.g., Eclipse, IntelliJ IDEA).
  Configure the IDE to recognize Java source files.
  (Optional) Replace the data loading logic to use your own student data file.
  Compile and run the program to execute the simulations and generate the report.
  
Requirements:
Java JRE or JDK
Basic understanding of hashing algorithms
