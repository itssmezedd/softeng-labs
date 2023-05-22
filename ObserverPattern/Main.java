import java.util.ArrayList;
import java.util.List;

// HonorSubject interface
interface HonorSubject {
    void includeStudent(Student student);
    void excludeStudent(Student student);
    void notifyStudent(Student student);
}

// Honor class implementing HonorSubject interface
class Honor implements HonorSubject {
    private double averageGrade;
    private List<Student> students;

    public Honor(double averageGrade) {
        this.averageGrade = averageGrade;
        this.students = new ArrayList<>();
    }

    @Override
    public void includeStudent(Student student) {
        students.add(student);
        notifyStudent(student);
    }

    @Override
    public void excludeStudent(Student student) {
        students.remove(student);
        System.out.println("Student " + student.getName() + " excluded from the honor roll.");
    }

    @Override
    public void notifyStudent(Student student) {
        String classification;
        if (student.getAverageGrade() >= 1.75) {
            classification = "Cum Laude";
        } else if (student.getAverageGrade() >= 1.25) {
            classification = "Magna Cum Laude";
        } else {
            classification = "Summa Cum Laude";
        }
        System.out.println("Congratulations, " + student.getName() + "! You are considered " + classification + "!");
    }
}

// StudentObserver interface
interface StudentObserver {
    void updateStudent(Honor honor);
}

// Student class implementing StudentObserver interface
class Student implements StudentObserver {
    private String studentNumber;
    private String name;
    private double averageGrade;

    public Student(String studentNumber, String name, double averageGrade) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.averageGrade = averageGrade;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getName() {
        return name;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public void updateStudent(Honor honor) {
        honor.excludeStudent(this);
    }
}

public class Main {
    public static void main(String[] args) {
        Honor honor = new Honor(1.5);  // Average grade for honor roll

        Student student1 = new Student("001", "John Doe", 1.8);
        Student student2 = new Student("002", "Jane Smith", 1.4);
        Student student3 = new Student("003", "Alice Johnson", 1.3);

        honor.includeStudent(student1);
        honor.includeStudent(student2);
        honor.includeStudent(student3);
    }
}
