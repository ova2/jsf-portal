package ova.util;

import org.apache.commons.lang3.StringUtils;
import ova.bean.MessagesProxy;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Message utils.
 */
public class MessageUtils
{
	public static final String FACES_MESSAGES = "javax.faces.Messages";

	public static FacesMessage getMessage(FacesMessage.Severity severity, String key, Object... params)
	{
		MessagesProxy messagesProxy = FacesUtils.lookup(MessagesProxy.class);

		String summary = messagesProxy.get(key);
		String detail = messagesProxy.get(key + "_detail");

		if ((summary != null) && (params != null)) {
			summary = MessageFormat.format(summary, params);
		}

		if ((detail != null) && (params != null)) {
			detail = MessageFormat.format(detail, params);
		}

		if (summary != null) {
			return new FacesMessage(severity, summary, ((detail != null) ? detail : StringUtils.EMPTY));
		}

		return new FacesMessage(severity, "???" + key + "???", ((detail != null) ? detail : StringUtils.EMPTY));
	}

	public static FacesMessage getMessage(String key, Object... params)
	{
		// set severity to error
		return getMessage(FacesMessage.SEVERITY_ERROR, key, params);
	}

	public static void addErrorMessage(MessagesProxy msgs, String key, Object... params)
	{
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgs.getText(key, params), null);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, msg);
		fc.validationFailed();
	}

	public static String getText(String key, Object... params)
	{
		MessagesProxy messagesProxy = FacesUtils.lookup(MessagesProxy.class);
		String text = messagesProxy.get(key);

		if ((text != null) && (params != null)) {
			text = MessageFormat.format(text, params);
		}

		return text;
	}

	public static Map<String, String> getMessages(Locale locale, String bundleName)
	{
		Map<String, String> msgs = new HashMap<String, String>();

		final FacesContext context = FacesContext.getCurrentInstance();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		if (loader == null) {
			loader = context.getApplication().getClass().getClassLoader();
		}

		ResourceBundle bundle =
		    ResourceBundle.getBundle(bundleName, ((locale != null) ? locale : context.getViewRoot().getLocale()),
		                             loader);

		if (bundle != null) {
			Enumeration<String> keys = bundle.getKeys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				msgs.put(key, bundle.getString(key));
			}
		}

		return msgs;
	}
}
