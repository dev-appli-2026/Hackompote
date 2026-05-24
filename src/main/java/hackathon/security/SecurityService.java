package hackathon.security;

import java.util.List;

import hackathon.utilisateur.entity.Utilisateur;
import hackathon.utilisateur.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {

	private final UtilisateurRepository utilisateurRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Utilisateur utilisateur = utilisateurRepository.findByPseudo(username);

		if (utilisateur == null) {
			utilisateur = utilisateurRepository.findByAdresseMail(username);
		}

		if (utilisateur == null) {
			throw new UsernameNotFoundException(
					"L'utilisateur '" + username + "' n'existe pas"
			);
		}

		return User.withUsername(utilisateur.getPseudo())
				.password(utilisateur.getMotDePasse())
				.roles("Participant")
				.build();
	}
}