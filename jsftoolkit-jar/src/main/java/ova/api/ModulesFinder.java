package ova.api;

import java.util.List;


/**
 * Interface to collects all available JSF modules.
 */
public interface ModulesFinder
{
	//~ Methods ----------------------------------------------------------------

	/**
	 * Gets a list of available modules in a modular JSF application.
	 *
	 * @return List<ModuleDescription> List of instances of {@link ModuleDescription}.
	 */
	List<ModuleDescription> getModules();
}
