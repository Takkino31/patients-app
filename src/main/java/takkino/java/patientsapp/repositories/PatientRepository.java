package takkino.java.patientsapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import takkino.java.patientsapp.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Page<Patient> findByFirstNameContainsIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName, Pageable pageable);
}
