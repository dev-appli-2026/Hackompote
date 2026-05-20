package hackathon.security;

import java.util.ArrayList;
import java.util.List;

import hackathon.utilisateur.Utilisateur;
import hackathon.utilisateur.UtilisateurRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hackathon.utilisateur.Utilisateur;
import hackathon.utilisateur.UtilisateurRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {

	private final UtilisateurRepository utilisateurRepository;

	@Override
	public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {

		Utilisateur utilisateur = utilisateurRepository.findByPseudo( username );
		if ( utilisateur == null ) {
			utilisateur = utilisateurRepository.findByAdresseMail( username );
			if ( utilisateur == null ) {
				throw new UsernameNotFoundException( "Le utilisateur '" + username + "' n'existe pas" );
			}
		}

		List<String> roles = new ArrayList<>();
		roles.add( "USER" );
		//TODO A refaire avec l'enum
//		if ( utilisateur.isRoleAdmin() ) {
//			roles.add( "ADMIN" );
//		}

		UserDetails userDetails = User.withUsername( utilisateur.getPseudo() ).password( utilisateur.getEmpreinteMdp() )
				.roles( roles.toArray( new String[] {} ) ).build();

		return userDetails;
	}
}
