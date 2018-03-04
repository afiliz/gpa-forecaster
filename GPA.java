import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPA {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in); // Get GPA and credit info from past courses
        System.out.println("Please enter in your current GPA:");
        double currentGPA = reader.nextDouble();
        System.out.println("Please enter the total number of credits you have taken at your current university:");
        double currentCredits = reader.nextDouble();

        System.out.println("How many classes are you taking this quarter?"); // Get class number
        double currentClasses = reader.nextDouble();
        reader.nextLine(); // pass EOL token
        
        
        int counter = 1;
        double classCounter = currentClasses;

        ArrayList<String> classes = new ArrayList<String>(); // stores class names
        ArrayList<Double> classCredits = new ArrayList<Double>(); // stores class credits (corresponding to class name order)

        System.out.println("Enter in your current classes' names and the credits they are worth.");
        while(classCounter != 0) {
            System.out.println("Enter in the name of class " + counter + ": ");
            String className = reader.nextLine();
            classes.add(className);
            System.out.println("Enter in the credits this class is worth: ");
            classCredits.add(reader.nextDouble());
            reader.nextLine();
            counter++;
            classCounter--;
        }

        boolean doneForecasting = false; // set to true when user is done with program

        System.out.println("Now, enter in the letter grades that you could get: ");
        while(!doneForecasting) {
            double quarterCredits = 0;
            double gradePoints = 0;
            int gradeCounter = 0;
            while (gradeCounter < classes.size()){
                System.out.println(classes.get(gradeCounter) + "'s Grade: ");
                String grade = reader.next();
                switch (grade) {
                    case "A+":
                        gradePoints += 4.0 * classCredits.get(gradeCounter);
                        quarterCredits += classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    case "A" :
                        gradePoints += 4.0 * classCredits.get(gradeCounter);
                        classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    case "A-":
                        gradePoints += 3.7 * classCredits.get(gradeCounter);
                        classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    case "B+":
                        gradePoints += 3.3 * classCredits.get(gradeCounter);
                        classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    case "B":
                        gradePoints += 3.0 * classCredits.get(gradeCounter);
                        classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    case "B-":
                        gradePoints += 2.7 * classCredits.get(gradeCounter);
                        classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    case "C+":
                        gradePoints += 2.3 * classCredits.get(gradeCounter);
                        classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    case "C":
                        gradePoints += 2.0 * classCredits.get(gradeCounter);
                        classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    case "C-":
                        gradePoints += 1.7 * classCredits.get(gradeCounter);
                        classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    case "D+":
                        gradePoints += 1.3 * classCredits.get(gradeCounter);
                        classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    case "D":
                        gradePoints += 1.0 * classCredits.get(gradeCounter);
                        classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    case "D-":
                        gradePoints += 0.7 * classCredits.get(gradeCounter);
                        classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    case "F+":
                        gradePoints += 0 * classCredits.get(gradeCounter);
                        classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    case "F":
                        gradePoints += 0 * classCredits.get(gradeCounter);
                        classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    case "F-":
                        gradePoints += 0 * classCredits.get(gradeCounter);
                        classCredits.get(gradeCounter);
                        gradeCounter++;
                        break;
                    default:
                        System.out.println("Not a valid letter grade. Please try again.\n");
                        break;
                }
            }
        }
    }
}

// int promptValue = -1;
//         while(promptValue != 1 || promptValue != 0) {
//             Scanner input = new Scanner(System.in);
//             System.out.println("Do you want to import previous grades? Type 'Y' or 'N'.");
//             String prompt = input.next();

//             if(prompt.equals("Y")) {
//                 promptValue = 0;
//                 break;
//             }
//             else if(prompt.equals("N")) {
//                 promptValue = 1;
//                 break;
//             }
//             else {
//                 System.out.println("Wrong character inputted. Please try again.");
//             }
//         }
//         if(promptValue == 0) { //read from file
//             try {
//                 FileReader file = new FileReader("GPA.txt");
//                 BufferedReader reader = new BufferedReader(file);
//             }
//             catch(FileNotFoundException ex) { // no file found
//                 System.out.println("Could not find a file to import from.");
//             }
//             // catch(IOException ex) { // file found, but error in reading it
//             //     System.out.println("Error reading save file. Verify that the save file is readable.");
//             // }
//         }
//         else {
//             try {
//                 FileWriter fileWrite = new FileWriter("GPA.txt");
//                 BufferedWriter write = new BufferedWriter(fileWrite);
                
//                 while()
//             }
//             catch (IOException ex){
//                 System.out.println("Error printing to file. Make sure nothing is interfering with writing to GPA.txt");
//             }
//         }