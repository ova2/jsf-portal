package ova.common;

import ova.api.ResourceBundleMessages;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Module specific extension of the {@link ova.api.ResourceBundleMessages}.
 */
@ApplicationScoped
@Named
public class JsfToolkitMessages extends ResourceBundleMessages
{
	//~ Methods ----------------------------------------------------------------

	@Override
	protected String getBundleName()
	{
		return "jsftoolkit";
	}
}
