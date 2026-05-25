package hackathon.evenement.dto;

import hackathon.utilisateur.validation.PasswordMatches;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ext.javatime.deser.key.LocalDateKeyDeserializer;

import java.time.LocalDate;

@Data
@PasswordMatches
public class CreationEvenementForm {

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