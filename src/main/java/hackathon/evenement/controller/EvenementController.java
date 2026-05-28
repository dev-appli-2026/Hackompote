package hackathon.evenement.controller;

import hackathon.evenement.dto.CreationEvenementForm;
import hackathon.evenement.service.EvenementService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/evenement")
public class EvenementController {

    private final EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @GetMapping
    public String afficherPages(Model model) {
        model.addAttribute("allEvenement", evenementService.getEvenementsAll());
        return "public/evenement.html";
    }

    @GetMapping("/creation")
    public String afficherFormulaire(Model model) {
        if (!model.containsAttribute("creationEvenementForm")) {
            model.addAttribute("creationEvenementForm", new CreationEvenementForm());
        }
        return "public/creation/creation-evenement.html";
    }

    @PostMapping
    public String traiterFormulaire(
            @Valid CreationEvenementForm creationEvenementForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "public/creation/creation-evenement.html"; //TODO route a faire
        }

        try {
            evenementService.creerEvenement(creationEvenementForm);
        } catch (IllegalArgumentException e) {
            System.out.println(bindingResult.getAllErrors());
            return "public/creation/creation-evenement.html"; //TODO route a faire
        }

        model.addAttribute("successMessage", "L'évenement créé avec succès.");
        return "redirect:/connexion"; //TODO route a faire
    }
}