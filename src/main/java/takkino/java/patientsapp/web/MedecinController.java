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
                @RequestParam(name = "page", defaultValue ="0") int page,
                @RequestParam(name = "size", defaultValue ="5") int size,
                @RequestParam(name = "search", defaultValue ="") String search
            ) {


        Page<Medecin> pageMedecins = medecinRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("medecins", pageMedecins.getContent());
        model.addAttribute("pages", new int[pageMedecins.getTotalPages()] );
        model.addAttribute("currentPage", page);
        model.addAttribute("search", search);

        return "medecins";
    }



}
