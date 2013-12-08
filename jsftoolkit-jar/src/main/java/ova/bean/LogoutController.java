package ova.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;


/**
 * Invalidates current session and redirects to the login page.
 */
@Named
@RequestScoped
public class LogoutController
{
	//~ Methods ----------------------------------------------------------------

	public String logout() throws IOException
	{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.invalidateSession();

		return "/index.html";
	}

	public String logout(String outcome) throws IOException
	{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.invalidateSession();

		return outcome;
	}
}
