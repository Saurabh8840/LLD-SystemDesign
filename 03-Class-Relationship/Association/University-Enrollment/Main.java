import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Classroom{

    private String roomcode;
    private int Capacity;

    Classroom(String roomcode,int Capacity){
         this.roomcode=roomcode;
         this.Capacity=Capacity;

    }
    
    String getRoomCode(){
        return roomcode;
    }

    void getCapacity(){
        System.out.println("Capacity :"+ Capacity);
    }
    
}


class Professor{

    private String name;
    private String subject;
    private List<Enrollment> enrollments=new ArrayList<>();



    Professor(String name, String subject){
        this.name=name;
        this.subject=subject;
    }

    void addEnrollment(Enrollment enrollment){
           enrollments.add(enrollment);
    }

    //get students

    //enrollments.stream() $\rightarrow$ Takes the list of enrollments (e.g., [Enrollment1, Enrollment2, Enrollment3])..map(Enrollment::getStudent) $\rightarrow$ Opens up each enrollment, extracts the Student object inside it, and creates a stream of students (e.g., [Alice, Bob, Alice])..distinct() $\rightarrow$ Removes duplicates if a student is enrolled multiple times (e.g., [Alice, Bob])..collect(Collectors.toList()) $\rightarrow$ Packs those extracted students into a brand new List<Student>.
    List<Student> getStudents(){
        return enrollments.stream()
              .map(Enrollment::getStudent)
              .distinct()
              .collect(Collectors.toList());
    }
    
    public String getName() { return name; }
    public String getSubject() { return subject; }

    //void getEnrollments(){}

    public List<Enrollment> getEnrollments(){return enrollments;}

    
}


class Student{

    String name;
    List<Enrollment> enrollments=new ArrayList<>();

    Student(String name){
      this.name=name;
    }

    void addEnrollment(Enrollment enrollment){
          enrollments.add(enrollment);
    }

    // void getprofessor(){// } wrong way bcz try to hit professer list which is in other class 

    public List<Professor> getProfessors(){
           return enrollments.stream()
                .map(Enrollment::getProfessor)
                .distinct()
                .collect(Collectors.toList());
    }


    public String getName(){
        return name;
    }

    public List<Enrollment> getEnrollments(){
        return enrollments;
    }

}

class Enrollment {
    private Professor professor;
    private Student student;
    private Classroom classroom;
    private String schedule;

    public Enrollment(Professor professor, Student student,
                      Classroom classroom, String schedule) {
        this.professor = professor;
        this.student = student;
        this.classroom = classroom;
        this.schedule = schedule;
        //automatically increment when a new enrollement happens 
        professor.addEnrollment(this);
        student.addEnrollment(this);
    }

    public Professor getProfessor() { return professor; }
    public Student getStudent() { return student; }
    public Classroom getClassroom() { return classroom; }
    public String getSchedule() { return schedule; }
}

public class Main {

    public static void main(String[] args) {
         
        Professor profJohn = new Professor("Prof. John", "Mathematics");
        Professor profSarah = new Professor("Prof. Sarah", "Physics");

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        Classroom roomA101 = new Classroom("A101", 30);
        Classroom roomB205 = new Classroom("B205", 50);

        new Enrollment(profJohn, alice, roomA101, "Monday 9:00 AM");
        new Enrollment(profJohn, bob, roomA101, "Monday 10:00 AM");
        new Enrollment(profSarah, alice, roomB205, "Wednesday 2:00 PM");
        

        
        System.out.println(profJohn.getName() + "'s students:");
        for(Student s:profJohn.getStudents()){
            System.out.println(" - "+s.getName());
        }

        System.out.println(alice.getName() + " 's professors :");
        for (Professor p : alice.getProfessors()) {
            System.out.println("  - " + p.getName() + " (" + p.getSubject() + ")");
        }


        System.out.println(profJohn.getName() + "'s schedule:");
        for (Enrollment e : profJohn.getEnrollments()) {
            System.out.println("  - " + e.getSchedule() + " with "
                + e.getStudent().getName()
                + " in Room " + e.getClassroom().getRoomCode());
        }

        


    }
    
}
