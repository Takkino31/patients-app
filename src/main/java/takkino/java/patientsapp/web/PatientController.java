package takkino.java.patientsapp.web;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import takkino.java.patientsapp.entities.Patient;
import takkino.java.patientsapp.repositories.PatientRepository;

@Controller
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

/*    @GetMapping("/index")
    public String index(Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "patients";
    }*/

    @GetMapping("/deletePatient")
    public String deletePatient(@RequestParam(name = "id") Long id,int page ,String keyword){
        patientRepository.deleteById(id);
        return "redirect:/index?page=&"+page+"&keyword="+keyword;
    }

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue ="0") int page,
                        @RequestParam(name = "size", defaultValue ="5") int size,
                        @RequestParam(name = "keyword", defaultValue ="") String keyword
        ) {

        Page<Patient> pagePatients = patientRepository.findByFirstNameContainsIgnoreCaseOrLastNameContainingIgnoreCase(keyword,keyword,PageRequest.of(page,size));
        model.addAttribute("listPatients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/formPatients")
    public String formPatients(Model model){
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }

    @PostMapping("/save")
    public String savePatient(@Valid @ModelAttribute("patient") Patient patient, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "formPatients";
        patientRepository.save(patient);
        return "redirect:/formPatients";
    }
}
