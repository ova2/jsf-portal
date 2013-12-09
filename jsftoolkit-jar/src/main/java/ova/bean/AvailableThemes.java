package ova.bean;

import ova.model.Theme;

import java.util.ArrayList;
import java.util.List;

/**
 * Available themes.
 */
public class AvailableThemes
{
	private static AvailableThemes INSTANCE = null;

	private List<Theme> themes;

	private AvailableThemes()
	{
		themes = new ArrayList<Theme>();

		themes.add(new Theme("afterdark", "themeswitcher/afterdark.png"));
		themes.add(new Theme("afternoon", "themeswitcher/afternoon.png"));
		themes.add(new Theme("afterwork", "themeswitcher/afterwork.png"));
		themes.add(new Theme("aristo", "themeswitcher/aristo.png"));
		themes.add(new Theme("black-tie", "themeswitcher/black-tie.png"));
		themes.add(new Theme("blitzer", "themeswitcher/blitzer.png"));
		themes.add(new Theme("bluesky", "themeswitcher/bluesky.png"));
		themes.add(new Theme("bootstrap", "themeswitcher/bootstrap.png"));
		themes.add(new Theme("casablanca", "themeswitcher/casablanca.png"));
		themes.add(new Theme("cruze", "themeswitcher/cruze.png"));
		themes.add(new Theme("cupertino", "themeswitcher/cupertino.png"));
		themes.add(new Theme("dark-hive", "themeswitcher/dark-hive.png"));
		themes.add(new Theme("delta", "themeswitcher/delta.png"));
		themes.add(new Theme("dot-luv", "themeswitcher/dot-luv.png"));
		themes.add(new Theme("eggplant", "themeswitcher/eggplant.png"));
		themes.add(new Theme("excite-bike", "themeswitcher/excite-bike.png"));
		themes.add(new Theme("flick", "themeswitcher/flick.png"));
		themes.add(new Theme("glass-x", "themeswitcher/glass-x.png"));
		themes.add(new Theme("home", "themeswitcher/home.png"));
		themes.add(new Theme("hot-sneaks", "themeswitcher/hot-sneaks.png"));
		themes.add(new Theme("humanity", "themeswitcher/humanity.png"));
		themes.add(new Theme("le-frog", "themeswitcher/le-frog.png"));
		themes.add(new Theme("midnight", "themeswitcher/midnight.png"));
		themes.add(new Theme("mint-choc", "themeswitcher/mint-choc.png"));
		themes.add(new Theme("overcast", "themeswitcher/overcast.png"));
		themes.add(new Theme("pepper-grinder", "themeswitcher/pepper-grinder.png"));
		themes.add(new Theme("redmond", "themeswitcher/redmond.png"));
		themes.add(new Theme("rocket", "themeswitcher/rocket.png"));
		themes.add(new Theme("sam", "themeswitcher/sam.png"));
		themes.add(new Theme("smoothness", "themeswitcher/smoothness.png"));
		themes.add(new Theme("south-street", "themeswitcher/south-street.png"));
		themes.add(new Theme("start", "themeswitcher/start.png"));
		themes.add(new Theme("sunny", "themeswitcher/sunny.png"));
		themes.add(new Theme("swanky-purse", "themeswitcher/swanky-purse.png"));
		themes.add(new Theme("trontastic", "themeswitcher/trontastic.png"));
		themes.add(new Theme("ui-darkness", "themeswitcher/ui-darkness.png"));
		themes.add(new Theme("ui-lightness", "themeswitcher/ui-lightness.png"));
		themes.add(new Theme("vader", "themeswitcher/vader.png"));
	}

	//~ Methods ----------------------------------------------------------------

	public List<Theme> getThemes()
	{
		return themes;
	}

	public static AvailableThemes getInstance()
	{
		if (INSTANCE == null) {
			INSTANCE = new AvailableThemes();
		}

		return INSTANCE;
	}
}
