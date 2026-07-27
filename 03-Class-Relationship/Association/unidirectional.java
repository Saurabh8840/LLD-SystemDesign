// package 03-Class-Relationship.Association;



class Patient{

    
    
    String name;
    String illness;

    Patient(String name, String illness){
        this.name=name;
        this.illness=illness;
    }

}

class Doctor{
 
    private  Patient  patient;
    String name;

    Doctor(String name, Patient patient){
        this.name=name;
        this.patient=patient;
    }

    public void treat(){
      System.out.println("Doctor  name : " + name);
      System.out.println("Patient illness : "+ patient.illness);
      System.out.println("Treating patient  : "+ patient.name);
    }
}

public class unidirectional {
     
    public static void main(String[] args) {
        
        Patient p1=new Patient("shrish","fever");
        Doctor d1=new Doctor("Saurabh",p1);
        
        d1.treat();
        
    }
      

}
