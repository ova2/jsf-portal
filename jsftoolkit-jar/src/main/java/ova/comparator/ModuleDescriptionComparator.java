package ova.comparator;

import ova.api.ModuleDescription;

import java.util.Comparator;


/**
 * Comparator for JSF modules in a portal software {@link ModuleDescription}.
 */
public class ModuleDescriptionComparator implements Comparator<ModuleDescription>
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
	 * @param  mode1 the first module to be compared.
	 * @param  mod2  the second module to be compared.
	 * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater
	 *         than the second.
	 */
	@Override
	public int compare(ModuleDescription mode1, ModuleDescription mod2)
	{
		return mode1.getName().compareToIgnoreCase(mod2.getName());
	}
}
