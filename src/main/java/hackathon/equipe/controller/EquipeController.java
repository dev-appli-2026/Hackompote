package hackathon.equipe.controller;

import hackathon.equipe.dto.CreationEquipeForm;
import hackathon.equipe.service.EquipeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipe")
public class EquipeController {

    private final EquipeService equipeService;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @GetMapping
    public String afficherEquipe(Model model) {
        int numEquipe = 1;
        model.addAttribute("ListeUtilisateurSansEquipe", equipeService.getUtilisateurInEquipe(0));
        model.addAttribute("ListeUtilisateurEquipe", equipeService.getUtilisateurInEquipe(numEquipe));
        model.addAttribute("MentorEquipe", equipeService.getMentorEquipe(numEquipe));
        return "public/creation/creation-equipe.html";
    }
}