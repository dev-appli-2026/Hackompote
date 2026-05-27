package hackathon.accueil;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

import hackathon.evenement.service.EvenementService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AccueilController {

	// -------
	// Champs
	// -------

	private final UserDetailsService	userDetailsService;
	private final RememberMeServices	rememberMeServices;
	private final EvenementService evenementService;

	private boolean autoConnect = true; // true -> active l'autoconnexion

	// -------
	// Endpoints
	// -------

	// -------
	// home()

	@GetMapping( "/" )
	public String accueil(HttpServletRequest request, HttpServletResponse response, Model model) {

		// Connexion automatique avec le compe admin
		var	session	= request.getSession( true );
		var	sc		= (SecurityContext) session.getAttribute( SPRING_SECURITY_CONTEXT_KEY );
		if ( sc == null && autoConnect ) {
			var	userDetails	= userDetailsService.loadUserByUsername( "Admin" );
			var	authReq		= new UsernamePasswordAuthenticationToken( userDetails, null, userDetails.getAuthorities() );
			rememberMeServices.loginSuccess( request, response, authReq );
			sc = SecurityContextHolder.getContext();
			sc.setAuthentication( authReq );
			session.setAttribute( SPRING_SECURITY_CONTEXT_KEY, sc );
		}

		model.addAttribute("evenement", evenementService.getEvenementsPublie(3, "Publié"));
		autoConnect = false;

		return "public/accueil.html";
	}

	// -------
	// mentionsLegales()

	@GetMapping( "/mentions-legales" )
	public String mentionsLegales() {
		return "public/mentions-legales.html";
	}

	// -------
	// quiSommesNous()

	@GetMapping( "/qui-sommes-nous" )
	public String quiSommesNous() {
		return "public/qui-sommes-nous.html";
	}

}
