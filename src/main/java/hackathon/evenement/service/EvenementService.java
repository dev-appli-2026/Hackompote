package hackathon.evenement.service;

import hackathon.evenement.entity.Evenement;
import hackathon.evenement.repository.EvenementRepository;
import hackathon.evenement.dto.CreationEvenementForm;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementService {

    private final EvenementRepository evenementRepository;

    public EvenementService(EvenementRepository evenementRepository) {
        this.evenementRepository = evenementRepository;
    }

    public Evenement creerEvenement(CreationEvenementForm form) {

        Evenement evenement = new Evenement();
        evenement.setNom(form.getNom());
        evenement.setDateDebut(form.getDateDebut());
        evenement.setDateFin(form.getDateFin());
        evenement.setDureeHeures(form.getDureeHeures());
        evenement.setNbMaxParEquipe(form.getNbMaxParEquipe());
        evenement.setStatutEvent("Brouillon");
        evenement.setLocalisationGeo(form.getLocalisationGeo());
        evenement.setLienBilletterie(form.getLienBilletterie());

        return evenementRepository.save(evenement);
    }


    public Iterable<Evenement> listerEvenements() {
        return evenementRepository.findAll();
    }

    // Return les n événements qui sont dans l'etat statu dans l'ordre Asc sur la date de début
    public List<Evenement> getEvenementsPublie(int n, String etat) {
        return evenementRepository.findAllByStatutEventOrderByDateDebutAsc(etat,PageRequest.of(0, n));
    }

    // Return les n événements qui sont dans l'etat statu dans l'ordre Desc sur la date de début
    public List<Evenement> getEvenementsPasse(int n, String etat) {
        return evenementRepository.findAllByStatutEventOrderByDateDebutAsc(etat,PageRequest.of(0, n));
    }
}