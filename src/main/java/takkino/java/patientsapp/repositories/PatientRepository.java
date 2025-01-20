package takkino.java.patientsapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import takkino.java.patientsapp.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
