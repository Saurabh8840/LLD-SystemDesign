import java.util.ArrayList;
import java.util.List;



class Patient {
    String name;
    Doctor doctor;
}

class Doctor {
    String name;
    List<Patient> patients = new ArrayList<>();

    public void addPatient(Patient patient) {
        patients.add(patient);
        patient.doctor = this;
    }
}


public class bidirectional {

    public static void main(String[] args) {
        

    }
    
}
