package takkino.java.patientsapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import takkino.java.patientsapp.entities.Medecin;
import takkino.java.patientsapp.repositories.MedecinRepository;

import java.util.Collection;

@Controller
public class MedecinController {
    private final MedecinRepository medecinRepository;

    public MedecinController(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }
    @GetMapping("/medecins")
    public String medecin(Model model) {
        Collection <Medecin> medecins =  medecinRepository.findAll();
        model.addAttribute("medecins", medecins);
        return "medecins";
    }

    @GetMapping("/deleteMedecin")
    public String deleteMedecin(@RequestParam (name="id")Long id) {
        medecinRepository.deleteById(id);
        return "redirect:/medecins";
    }
}
