package takkino.java.patientsapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import takkino.java.patientsapp.entities.Medecin;
import takkino.java.patientsapp.entities.Patient;
import takkino.java.patientsapp.repositories.MedecinRepository;
import takkino.java.patientsapp.repositories.PatientRepository;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PatientsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PatientRepository patientRepository, MedecinRepository MedecinRepository, MedecinRepository medecinRepository) {
        return args -> {
//            System.out.println("patientRepository.findAll()");
            Patient patient1 = new Patient();
            patient1.setFirstName("Jan");
            patient1.setLastName("Doe");
            patient1.setDateOfBirth(new Date());
            patient1.setScore(10);
            patient1.setSick(true);
//            patientRepository.save(patient1);
            Patient patient2 = new Patient(null,"Abraham","Lo",new Date(),false,654);
//            patientRepository.save(patient2);
            Patient patient3 = Patient.builder()
                    .firstName("Takkino")
                    .lastName("War")
                    .score(42)
                    .build()
                    ;
//          patientRepository.save(patient3);

            Medecin medecin1 = Medecin.builder()
                    .firstName("Dona")
                    .lastName("Paulsen")
                    .dateOfBirth(new Date())
                    .specialite("No people")
                    .build();
            Medecin medecin2 = new Medecin(null,"Saint", "Franklin", new Date(), "Pediatric");
            Medecin medecin3 = new Medecin(null,"Deguene", "Fall", new Date(), "Big Heart");
            Medecin medecin4 = new Medecin(null,"Gaye", "abdou", new Date(), "Real");
            Medecin medecin5 = new Medecin(null,"Diarra", "Fall", new Date(), "Lover");
            medecinRepository.save(medecin1);
            medecinRepository.save(medecin2);
            medecinRepository.save(medecin3);
            medecinRepository.save(medecin4);
            medecinRepository.save(medecin5);
//            System.out.println(patient1.getFirstName() + " " + patient1.getLastName() + " " + patient1.getDateOfBirth() + " " + patient1.getScore());
//            System.out.println(patient2.getFirstName() + " " + patient2.getLastName() + " " + patient2.getDateOfBirth() + " " + patient2.getScore());
//            System.out.println(patient3.getFirstName() + " " + patient3.getLastName() + " " + patient3.getDateOfBirth() + " " + patient3.getScore());

//            final List<Patient> patients = patientRepository.findAll();
//            patients.forEach(patient ->
//                    System.out.println(patient.getFirstName() + " " + patient.getLastName() + " " + patient.getDateOfBirth() + " " + patient.getScore())
//            );
        };
    }
}
