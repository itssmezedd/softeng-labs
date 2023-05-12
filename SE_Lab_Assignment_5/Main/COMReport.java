package SE_Lab_Assignment_5.Main;

import java.io.IOException;
import SE_Lab_Assignment_5.DA.BlockSectionDA;
import SE_Lab_Assignment_5.Domain.Course;
import SE_Lab_Assignment_5.Domain.Student;

public class COMReport {
    public static void main(String[] args) throws IOException {
        BlockSectionDA blocksectionDA = new BlockSectionDA();
        blocksectionDA.getBlockSection();

        StringBuilder stored_Strings = new StringBuilder();
        stored_Strings.append(String.format("%-20s %-30s %-50s\n%-20s %s\n\n", "Block Section:", blocksectionDA.getBlockSection().getBlockCode(),
                          "Block Section Desription: " + blocksectionDA.getBlockSection().getDescription(),
                          "Class Adviser:", blocksectionDA.getBlockSection().getAdviser()));

        for (Student student : blocksectionDA.getBlockSection().getStudentList()) {
            stored_Strings.append("--------------------------------------------------------------------------------------\n");
            stored_Strings.append(String.format("%-20s %-30s %-50s\n%-20s %s\n\n", "Student:", student.getStudentNumber(),
                              "Student Name: " + student.getName(),
                              "", "Program: " + student.getProgram()));
            stored_Strings.append("Schedule\n");
            stored_Strings.append(String.format("%-15s %-30s %-10s %-10s %-10s\n", "Course Code", "Description", "Unit", "Day", "Time"));
            for (Course course : student.getCourseList()) {
                stored_Strings.append(String.format("%-15s %-30s %-10s %-10s %-10s\n", course.getCourseCode(),
                                    course.getDescription(), course.getUnit(), course.getDay(), course.getTime()));
            }
            stored_Strings.append("\n");
        }

        System.out.print(stored_Strings.toString());
    }
}
