package ova.api;

/**
 * Interface for modular JSF applications. This interface should be implemented by every module (JSF app.) to allow a
 * seamless integration into a "portal" software.
 */
public interface ModuleDescription
{
	//~ Methods ----------------------------------------------------------------

	/**
	 * Provides a human readable name of the module.
	 *
	 * @return String name of the module
	 */
	String getName();

	/**
	 * Provides a description of the module.
	 *
	 * @return String description
	 */
	String getDescription();

	/**
	 * Provides a module specific prefix, e.g. "secservice". This is a folder below the context where all web pages and
	 * resources are located.
	 *
	 * @return String prefix
	 */
	String getPrefix();

	/**
	 * Provides a name for a logo image, e.g. "images/logo.png" (used in h:graphicImage).
	 *
	 * @return String logo name
	 */
	String getLogoName();

	/**
	 * Provides a start (home) URL to be navigated for the module.
	 *
	 * @return String URL
	 */
	String getUrl();
}
