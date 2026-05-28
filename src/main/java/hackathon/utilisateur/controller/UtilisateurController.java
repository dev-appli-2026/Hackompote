package hackathon.utilisateur.controller;

import hackathon.utilisateur.dto.CreationUtilisateurForm;
import hackathon.utilisateur.entity.Utilisateur;
import hackathon.utilisateur.repository.UtilisateurRepository;
import hackathon.utilisateur.service.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/creation")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurController(UtilisateurService utilisateurService, UtilisateurRepository utilisateurRepository) {
        this.utilisateurService = utilisateurService;
        this.utilisateurRepository = utilisateurRepository;
    }

    @GetMapping
    public String afficherFormulaire(Model model) {
        if (!model.containsAttribute("creationUtilisateurForm")) {
            model.addAttribute("creationUtilisateurForm", new CreationUtilisateurForm());
        }
        return "public/creation/creation-utilisateur.html";
    }

    @PostMapping
    public String traiterFormulaire(
            @Valid CreationUtilisateurForm creationUtilisateurForm,
            BindingResult bindingResult,
            Model model) {

        if (creationUtilisateurForm.getCv() != null && !creationUtilisateurForm.getCv().isEmpty()) {
            String nomFichier = creationUtilisateurForm.getCv().getOriginalFilename();
            if (nomFichier == null || !nomFichier.toLowerCase().endsWith(".pdf")) {
                bindingResult.rejectValue("cv", "cv.invalid", "Le CV doit être un fichier PDF.");
            }
        }

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "public/creation/creation-utilisateur.html";
        }

        try {
            utilisateurService.creerUtilisateur(creationUtilisateurForm);
        } catch (IllegalArgumentException e) {
            bindingResult.rejectValue("adresseMail", "adresseMail.exists", e.getMessage());
            System.out.println(bindingResult.getAllErrors());
            return "public/creation/creation-utilisateur.html";
        }

        model.addAttribute("successMessage", "Compte créé avec succès.");
        return "redirect:/connexion";
    }

}