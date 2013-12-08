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
public class ModBDescription extends AbstractModuleDescription implements Serializable
{
	//~ Instance fields --------------------------------------------------------

	@Inject
	private MessagesProxy msgs;

	//~ Methods ----------------------------------------------------------------

	@Override
	public String getName()
	{
		return msgs.get("b.modName");
	}

	@Override
	public String getDescription()
	{
		return msgs.get("b.modDesc");
	}

	@Override
	public String getPrefix()
	{
		return "modb";
	}

	@Override
	public String getUrl()
	{
		return "/modb/views/hello.jsf";
	}
}
