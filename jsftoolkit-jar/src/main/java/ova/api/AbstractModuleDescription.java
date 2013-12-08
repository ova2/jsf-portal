package ova.api;

/**
 * Abstract class which implements some methodes in {@link ModuleDescription}.
 */
public abstract class AbstractModuleDescription implements ModuleDescription
{
	@Override
	public String getLogoName()
	{
		return "images/logo.png";
	}
}
