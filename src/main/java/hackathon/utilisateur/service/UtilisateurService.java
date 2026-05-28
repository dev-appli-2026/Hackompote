package hackathon.utilisateur.service;

import hackathon.utilisateur.dto.CreationUtilisateurForm;
import hackathon.utilisateur.entity.Utilisateur;
import hackathon.utilisateur.repository.UtilisateurRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final StockageFichierService stockageFichierService;

    public UtilisateurService(UtilisateurRepository utilisateurRepository,
                              PasswordEncoder passwordEncoder,
                              StockageFichierService stockageFichierService) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
        this.stockageFichierService = stockageFichierService;
    }

    public Utilisateur creerUtilisateur(CreationUtilisateurForm form) {

        if (utilisateurRepository.existsByAdresseMail(form.getAdresseMail())) {
            throw new IllegalArgumentException("Cette adresse mail est déjà utilisée.");
        }

        if (utilisateurRepository.existsByPseudo(form.getPseudo())) {
            throw new IllegalArgumentException("Ce pseudo est déjà utilisé.");
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(form.getNom());
        utilisateur.setPrenom(form.getPrenom());
        utilisateur.setAdresseMail(form.getAdresseMail());
        utilisateur.setDateNaissance(form.getDateNaissance());

        String motDePasseEncode = passwordEncoder.encode(form.getMotDePasse());
        utilisateur.setMotDePasse(motDePasseEncode);

        utilisateur.setRole("Participant");
        utilisateur.setStatutRecherche(form.isStatutRecherche());
        utilisateur.setPseudo(form.getPseudo());
        utilisateur.setCompetencesCles("");

        String lienCv = stockageFichierService.sauvegarderCv(form.getCv());
        utilisateur.setLienCv(lienCv);

        return utilisateurRepository.save(utilisateur);
    }

}