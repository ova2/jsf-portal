package ova.comparator;

import org.primefaces.extensions.model.fluidgrid.FluidGridItem;
import ova.api.ModuleDescription;

import java.util.Comparator;


/**
 * Comparator for JSF modules in a portal software.
 */
public class ModuleDescriptionComparator implements Comparator<FluidGridItem>
{
	private static final ModuleDescriptionComparator INSTANCE = new ModuleDescriptionComparator();

	private ModuleDescriptionComparator()
	{
	}

	/**
	 * Returns singleton comparator instance.
	 *
	 * @return ModuleDescriptionComparator
	 */
	public static ModuleDescriptionComparator getInstance()
	{
		return INSTANCE;
	}

	/**
	 * Compare {@link ModuleDescription}s.
	 *
	 * @param  mod1 the first module to be compared.
	 * @param  mod2  the second module to be compared.
	 * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater
	 *         than the second.
	 */
	@Override
	public int compare(FluidGridItem mod1, FluidGridItem mod2)
	{
		return ((ModuleDescription)mod1.getData()).getName().compareToIgnoreCase(((ModuleDescription)mod2.getData()).getName());
	}
}
