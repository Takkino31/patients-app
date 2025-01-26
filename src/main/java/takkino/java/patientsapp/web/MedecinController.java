package takkino.java.patientsapp.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @GetMapping("/deleteMedecin")
    public String deleteMedecin(
            @RequestParam (name="id")Long id
    ) {
        medecinRepository.deleteById(id);
        return "redirect:/medecins";
    }

    @GetMapping("/medecins")
    public String medecin(
                Model model,
                @RequestParam(name = "page", defaultValue ="0") int page
            ) {
//        Collection < Medecin> medecins =  medecinRepository.findAll();
//        model.addAttribute("medecins", medecins);

        Page<Medecin> pageMedecins = medecinRepository.findAll(PageRequest.of(page, 5));
        model.addAttribute("medecins", pageMedecins.getContent());
        model.addAttribute("page", pageMedecins.getTotalPages());
        System.out.println("page Medecins : " + page);
        return "medecins";
    }



}
