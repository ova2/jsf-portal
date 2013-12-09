package ova.util;

import org.apache.deltaspike.core.api.provider.BeanManagerProvider;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import java.util.Iterator;


/**
 * Utility class for JSF in CDI + CODI environment.
 */
public class FacesUtils
{
	public static BeanManager getBeanManager()
	{
		return BeanManagerProvider.getInstance().getBeanManager();
	}

	@SuppressWarnings("unchecked")
	public static <T> T lookup(Class<T> clazz)
	{
		BeanManager bm = getBeanManager();
		Iterator<Bean<?>> iter = bm.getBeans(clazz).iterator();
		if (!iter.hasNext()) {
			throw new IllegalStateException("CDI BeanManager cannot find an instance of requested type "
			                                + clazz.getName());
		}

		Bean<T> bean = (Bean<T>) iter.next();
		CreationalContext<T> ctx = bm.createCreationalContext(bean);

		return (T) bm.getReference(bean, clazz, ctx);
	}

	public static <T> boolean isBeanExist(Class<T> clazz)
	{
		Iterator<Bean<?>> iter = getBeanManager().getBeans(clazz).iterator();

		return iter.hasNext();
	}
}
