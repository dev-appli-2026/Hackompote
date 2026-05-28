package hackathon.equipe.service;

import hackathon.equipe.dto.CreationEquipeForm;
import hackathon.equipe.entity.Equipe;
import hackathon.equipe.repository.EquipeRepository;
import hackathon.utilisateur.entity.Utilisateur;
import hackathon.utilisateur.repository.UtilisateurRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    private final EquipeRepository equipeRepository;
    private final UtilisateurRepository utilisateurRepository;

    public EquipeService(EquipeRepository equipeRepository, UtilisateurRepository utilisateurRepository) {
        this.equipeRepository = equipeRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public Equipe creerEquipe(CreationEquipeForm form) {

        Equipe equipe = new Equipe();
//        equipe.setNom(form.getNom());
//        equipe.setDateDebut(form.getDateDebut());
//        equipe.setDateFin(form.getDateFin());
//        equipe.setDureeHeures(form.getDureeHeures());
//        equipe.setNbMaxParEquipe(form.getNbMaxParEquipe());
//        equipe.setStatutEvent("Brouillon");
//        equipe.setLocalisationGeo(form.getLocalisationGeo());
//        equipe.setLienBilletterie(form.getLienBilletterie());

        return equipeRepository.save(equipe);
    }


    public Iterable<Equipe> listerEquipes() {
        return equipeRepository.findAll();
    }

    // Return
    public List<Utilisateur> getUtilisateurInEquipe(int idEquipe) {
        return utilisateurRepository.findAllByIdEquipe(idEquipe);
    }
}