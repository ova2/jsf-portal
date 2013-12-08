package ova.bean;

import org.apache.commons.lang3.StringUtils;
import ova.api.MessagesProvider;
import ova.util.MessageUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Application scoped bean to give an access to all available messages in a modular JSF web application.
 */
@ApplicationScoped
@Named(value = "msgs")
public class MessagesProxy implements Map<String, String>, Serializable
{
	@Inject
	private UserSettingsData userSettingsData;

	@Any
	@Inject
	private Instance<MessagesProvider> messagesProviders;

	/** all cached locale specific messages */
	private Map<Locale, Map<String, String>> msgs = new ConcurrentHashMap<Locale, Map<String, String>>();

    @Override
	public String get(Object key)
	{
		if (key == null) {
			return null;
		}

		Locale locale = userSettingsData.getLocale();
		Map<String, String> messages = msgs.get(locale);

		if (messages == null) {
			// no messages to current locale are available yet
			messages = new HashMap<String, String>();
			msgs.put(locale, messages);

			// load messages from JSF impl. first
			messages.putAll(MessageUtils.getMessages(locale, MessageUtils.FACES_MESSAGES));

			// load messages from providers in JARs
			for (MessagesProvider messagesProvider : messagesProviders) {
				messages.putAll(messagesProvider.getMessages(locale));
			}
		}

		return messages.get(key);
	}
    
    public String getText(String key)
   	{
         return this.get(key);
    }
    
    public String getText(String key, Object... params)
	{
		String text = this.get(key);

		if ((text != null) && (params != null)) {
			text = MessageFormat.format(text, params);
		}

		return text;
	}

	public FacesMessage getMessage(FacesMessage.Severity severity, String key, Object... params)
	{
		String summary = this.get(key);
		String detail = this.get(key + "_detail");

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
    
   	public FacesMessage getMessage(String key, Object... params)
   	{
   		// set severity to error
   		return getMessage(FacesMessage.SEVERITY_ERROR, key, params);
   	}    
    
    /////////////////////////////////////////////////////////
	// java.util.Map interface
	/////////////////////////////////////////////////////////

    public int size() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException();
    }

    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException();
    }   

    public String put(String key, String value) {
        throw new UnsupportedOperationException();
    }

    public String remove(Object key) {
        throw new UnsupportedOperationException();
    }

    public void putAll(Map<? extends String, ? extends String> m) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Set<String> keySet() {
        throw new UnsupportedOperationException();
    }

    public Collection<String> values() {
        throw new UnsupportedOperationException();
    }

    public Set<Entry<String, String>> entrySet() {
        throw new UnsupportedOperationException();
    }   
}
