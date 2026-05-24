package hackathon.utilisateur.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class StockageFichierService {

    private final Path dossierCv;

    public StockageFichierService(@Value("${app.upload.cv-dir:uploads/cv}") String dossier) throws IOException {
        this.dossierCv = Paths.get(dossier).toAbsolutePath().normalize();
        Files.createDirectories(this.dossierCv);
    }

    public String sauvegarderCv(MultipartFile fichier) {
        if (fichier == null || fichier.isEmpty()) {
            return null;
        }

        String nomOriginal = StringUtils.cleanPath(
                fichier.getOriginalFilename() == null ? "cv.pdf" : fichier.getOriginalFilename()
        );

        if (nomOriginal.contains("..")) {
            throw new IllegalArgumentException("Nom de fichier invalide.");
        }

        String contentType = fichier.getContentType();
        if (contentType == null || !contentType.equalsIgnoreCase("application/pdf")) {
            throw new IllegalArgumentException("Le CV doit être au format PDF.");
        }

        String nomStocke = UUID.randomUUID() + ".pdf";
        Path destination = dossierCv.resolve(nomStocke).normalize();

        if (!destination.getParent().equals(dossierCv)) {
            throw new IllegalArgumentException("Chemin de destination invalide.");
        }

        try {
            Files.copy(fichier.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
            return destination.toString();
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de l'enregistrement du CV.", e);
        }
    }
}