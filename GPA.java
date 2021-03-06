import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPA {
    public static void main(String[] args) throws IOException {
        boolean accurateResult = false;
        Scanner reader = new Scanner(System.in); // Get GPA and credit info from past courses
        System.out.println("\nWelcome to the GPA Forecaster!"); // Prompt
        System.out.println("Please note that results may be off by around +/- 0.01.\n");

        System.out.println("Please enter in your current GPA:");
        double currentGPA = reader.nextDouble();
        System.out.println("\nPlease enter the total number of credits you have taken at your school.");
        System.out.println("For more accurate results, please subtract pass/no pass credits from your total credits:");
        double currentCredits = reader.nextDouble();
        double currentGradePoints = currentGPA * currentCredits;

        System.out.println("\nHow many classes are you taking this quarter/semester?"); // Get current class amount
        double currentClasses = reader.nextDouble();
        reader.nextLine(); // pass EOL token
        
        int counter = 1;
        double classCounter = currentClasses;

        ArrayList<String> classes = new ArrayList<String>(); // stores class names
        ArrayList<Double> classCredits = new ArrayList<Double>(); // stores class credits (corresponding to class name order)

        System.out.println("\nEnter in your current classes' names and the credits they are worth.");
        while(classCounter != 0) {
            System.out.println("\nEnter in the name of class " + counter + ": ");
            String className = reader.nextLine();
            classes.add(className);
            System.out.println("\nEnter in the credits this class is worth: ");
            classCredits.add(reader.nextDouble());
            reader.nextLine();
            counter++;
            classCounter--;
        }

        boolean doneForecasting = false; // set to true when user is done with program

        System.out.println("\nEnter in the letter grades that you could get: ");
        while(!doneForecasting) {
            double quarterCredits = 0;
            double gradePoints = 0;
            int gradeCounter = 0;
            while (gradeCounter < classes.size()){ 
                System.out.println("\n" + classes.get(gradeCounter) + "'s Grade: ");
                String grade = reader.nextLine();
                if(grade.equals("A+")){ // Add to quarter credit total based on letter grade inputted
                    gradePoints += 4.0 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else if(grade.equals("A")){
                    gradePoints += 4.0 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else if(grade.equals("A-")){
                    gradePoints += 3.7 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else if(grade.equals("B+")){
                    gradePoints += 3.3 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else if(grade.equals("B")){
                    gradePoints += 3.0 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else if(grade.equals("B-")){
                    gradePoints += 2.7 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else if(grade.equals("C+")){
                    gradePoints += 2.3 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else if(grade.equals("C")){
                    gradePoints += 2.0 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else if(grade.equals("C-")){
                    gradePoints += 1.7 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else if(grade.equals("D+")){
                    gradePoints += 1.3 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else if(grade.equals("D")){
                    gradePoints += 1.0 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else if(grade.equals("D-")){
                    gradePoints += 0.7 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else if(grade.equals("F+")){
                    gradePoints += 0.0 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else if(grade.equals("F")){
                    gradePoints += 0.0 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else if(grade.equals("F-")){
                    gradePoints += 0.0 * classCredits.get(gradeCounter);
                    quarterCredits += classCredits.get(gradeCounter);
                    gradeCounter++;
                }
                else{
                    System.out.println("Not a valid letter grade. Please try again.");
                }
            }

            // Final calculations. Add grade points from past and current quarter grade points,
            // and final credits from past and current quarter credits, divide final grade points
            // by final credits to get final GPA
            double finalGradePoints = currentGradePoints + gradePoints;
            double finalCredits = currentCredits + quarterCredits;
            double finalGPA = finalGradePoints/finalCredits;
            
            System.out.println("\nYour forecasted GPA with these letter grades is: " + String.format("%.5g%n", finalGPA));
            boolean choiceMade = false;
            String choice = "";
            while (!choiceMade){ //check if user wants to make another forecast
                System.out.println("\nWould you like to make another forecast? Type 'Y' or 'N'");
                choice = reader.next();
                if(!choice.equals("Y") || !choice.equals("N") || !choice.equals("y") || !choice.equals("n")) choiceMade = true;
                else System.out.println("You did not input a valid answer.");
            }
            reader.nextLine();
            if(choice.equals("N") || choice.equals("n")) doneForecasting = true;
        }
    }
}
