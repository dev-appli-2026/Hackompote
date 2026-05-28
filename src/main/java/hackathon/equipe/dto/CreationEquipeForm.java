package hackathon.equipe.dto;

import hackathon.utilisateur.validation.PasswordMatches;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@PasswordMatches
public class CreationEquipeForm {

    @NotBlank(message = "Le nom de l'évenement est obligatoire.")
    private String nom;

    @NotBlank(message = "La date de début est obligatoire.")
    private LocalDate dateDebut;

    @NotBlank(message = "La date de fin est obligatoire.")
    private LocalDate dateFin;

    @NotNull(message = "La durée de l'évenement est obligatoire.")
    private int dureeHeures;

    @NotBlank(message = "Le nombre de participant par équipe est obligatoire.")
    private int nbMaxParEquipe;

    @NotBlank(message = "La localisation de l'évenement est obligatoire.")
    private String localisationGeo;

    @NotBlank(message = "Le lien de la billeterie de l'évenement est obligatoire.")
    private String lienBilletterie;

}