package ova.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessBean;
import java.util.ArrayList;
import java.util.List;


/**
 * CDI extension for eager CDI beans.
 */
public class EagerExtension implements Extension
{
	//~ Instance fields --------------------------------------------------------

	private List<Bean<?>> eagerBeansList = new ArrayList<Bean<?>>();

	//~ Methods ----------------------------------------------------------------

	public <T> void collect(@Observes ProcessBean<T> event)
	{
		if (event.getAnnotated().isAnnotationPresent(Eager.class)
		    && event.getAnnotated().isAnnotationPresent(ApplicationScoped.class)) {
			eagerBeansList.add(event.getBean());
		}
	}

	public void load(@Observes AfterDeploymentValidation event, BeanManager beanManager)
	{
		for (Bean<?> bean : eagerBeansList) {
			beanManager.getReference(bean, bean.getBeanClass(), beanManager.createCreationalContext(bean)).toString();
		}
	}
}
