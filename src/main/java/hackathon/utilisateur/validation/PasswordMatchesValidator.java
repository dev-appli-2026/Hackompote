package hackathon.utilisateur.validation;

import hackathon.utilisateur.dto.CreationUtilisateurForm;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, CreationUtilisateurForm> {

    @Override
    public boolean isValid(CreationUtilisateurForm form, ConstraintValidatorContext context) {
        if (form == null) {
            return true;
        }

        boolean valide = form.getMotDePasse() != null
                && form.getMotDePasse().equals(form.getConfirmationMotDePasse());

        if (!valide) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Les mots de passe ne correspondent pas.")
                    .addPropertyNode("confirmationMotDePasse")
                    .addConstraintViolation();
        }
        return valide;
    }
}