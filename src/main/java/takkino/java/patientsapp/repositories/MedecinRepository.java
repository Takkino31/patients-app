package takkino.java.patientsapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import takkino.java.patientsapp.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
