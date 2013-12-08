package ova.common;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ova.api.AbstractModuleDescription;
import ova.api.ModuleDescription;
import ova.bean.MessagesProxy;


/**
 * Module specific implementation of the {@link ModuleDescription}.
 */
@ApplicationScoped
@Named
public class ModADescription extends AbstractModuleDescription implements Serializable
{
	//~ Instance fields --------------------------------------------------------

	@Inject
	private MessagesProxy msgs;

	//~ Methods ----------------------------------------------------------------

	@Override
	public String getName()
	{
		return msgs.get("a.modName");
	}

	@Override
	public String getDescription()
	{
		return msgs.get("a.modDesc");
	}

	@Override
	public String getPrefix()
	{
		return "moda";
	}

	@Override
	public String getUrl()
	{
		return "/moda/views/hello.jsf";
	}
}
