package hackathon.utilisateur.dto;

import hackathon.utilisateur.validation.PasswordMatches;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;

@Data
@PasswordMatches
public class CreationUtilisateurForm {

    @NotBlank(message = "Le prénom est obligatoire.")
    private String prenom;

    @NotBlank(message = "Le nom est obligatoire.")
    private String nom;

    @NotBlank(message = "Le pseudo est obligatoire.")
    private String pseudo;

    @NotNull(message = "La date de naissance est obligatoire.")
    private LocalDate dateNaissance;

    @NotBlank(message = "L'adresse mail est obligatoire.")
    @Email(message = "L'adresse mail n'est pas valide.")
    private String adresseMail;

    @NotBlank(message = "Le mot de passe est obligatoire.")
    @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères.")
    private String motDePasse;

    @NotBlank(message = "La confirmation du mot de passe est obligatoire.")
    private String confirmationMotDePasse;

    private MultipartFile cv;

    private boolean statutRecherche;

}