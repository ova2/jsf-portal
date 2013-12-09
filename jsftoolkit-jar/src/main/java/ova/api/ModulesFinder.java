package ova.api;

import org.primefaces.extensions.model.fluidgrid.FluidGridItem;

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
	 * @return List<FluidGridItem> List of instances of {@link ModuleDescription}.
	 */
	List<FluidGridItem> getModules();
}
