package ova.converter;

import ova.bean.AvailableThemes;
import ova.model.Theme;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.List;

/**
 * Theme converter.
 */
@FacesConverter("jsftoolkit.ThemeConverter")
public class ThemeConverter implements Converter
{
	//~ Methods ----------------------------------------------------------------

	@Override
	public Object getAsObject(final FacesContext context, final UIComponent component, final String value)
	{
		List<Theme> themes = AvailableThemes.getInstance().getThemes();
		for (Theme theme : themes) {
			if (theme.getName().equals(value)) {
				return theme;
			}
		}

		return null;
	}

	@Override
	public String getAsString(final FacesContext context, final UIComponent component, final Object value)
	{
		return ((Theme) value).getName();
	}
}
