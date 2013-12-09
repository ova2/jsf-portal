package ova.bean;

import org.primefaces.extensions.converter.LocaleConverter;
import ova.model.Theme;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Bean as data container for user settings.
 */
@Named
@SessionScoped
public class UserSettingsData implements Serializable
{
	private static final String LOCALE_KEY = "locale";
	private static final String THEME_KEY = "theme";

	@Inject
	private MessagesProxy msgs;

	private Map<String, Object> settings;

	/** all supported locales */
	private List<SelectItem> locales;

	@PostConstruct
	protected void initialize()
	{
        settings = new HashMap<String, Object>();
		
		// ensure that all settings are set
		FacesContext fc = FacesContext.getCurrentInstance();

		Locale locale = getLocale();
		if (locale == null) {
			// returns locale based on "accept-language" header or the server default
			locale = fc.getExternalContext().getRequestLocale();

			if (locale == null || !getSupportedLocales(fc).contains(locale)) {
				// No header for "accept-language" or not suppoted Locale ==> take default locale as fallback
				locale = fc.getApplication().getDefaultLocale();
			}

			setLocale(locale);
		}

		Theme theme = getTheme();
		if (theme == null) {
	        setTheme(getAvailableThemes().get(2));
		}
	}
    
    public void saveSettings(AjaxBehaviorEvent e)
   	{
   		// save settings in the backend or cookies ...
   
   		// reload the web app at the same view
   		FacesContext fc = FacesContext.getCurrentInstance();
   		fc.getApplication().getNavigationHandler()
   		  .handleNavigation(fc, "null", fc.getViewRoot().getViewId() + "?faces-redirect=true");
   	}
    

	/**
	 * Gets supported locales.
	 *
	 * @return List<SelectItem> supported locales
	 */
	public List<SelectItem> getLocales()
	{
		if (locales == null) {
			locales = new ArrayList<SelectItem>();

			FacesContext fc = FacesContext.getCurrentInstance();

			// get all supported locales
			Iterator<Locale> iter = fc.getApplication().getSupportedLocales();
			while (iter.hasNext()) {
				Locale supLocale = iter.next();
				locales.add(new SelectItem(supLocale,
				                           msgs.getText("jsftoolkit.locale."
				                                        + LocaleConverter.getLocaleString(supLocale, '_'))));
			}
		}

		return locales;
	}

	/**
	 * Gets all available themes.
	 *
	 * @return List<Theme> list of theme objects
	 */
	public List<Theme> getAvailableThemes()
	{
		return AvailableThemes.getInstance().getThemes();
	}

	private List<Locale> getSupportedLocales(FacesContext fc)
	{
		List<Locale> supportedLocales = new ArrayList<Locale>();
		Iterator<Locale> iter = fc.getApplication().getSupportedLocales();
		while (iter.hasNext()) {
			supportedLocales.add(iter.next());
		}

		return supportedLocales;
	}

	public Locale getLocale()
	{
		return (Locale) settings.get(LOCALE_KEY);
	}

	public void setLocale(Locale locale)
	{
		settings.put(LOCALE_KEY, locale);
	}

	public Theme getTheme()
	{
		return (Theme) settings.get(THEME_KEY);
	}

	public void setTheme(Theme theme)
	{
		settings.put(THEME_KEY, theme);
	}
}
