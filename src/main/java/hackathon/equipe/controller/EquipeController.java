package hackathon.equipe.controller;

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
@RequestMapping("/equipe") //TODO a vérifier
public class EquipeController {

    private final EvenementService evenementService;

    public EquipeController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @GetMapping
    public String afficherEvenement(Model model) {
        return "public/creation/creation-equipe.html";
    }
}