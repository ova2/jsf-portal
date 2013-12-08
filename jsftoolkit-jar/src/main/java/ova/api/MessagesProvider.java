/*
 * Copyright (C) 2013 Scalaris AG, Germany. All rights reserved.
 *
 * $Id: MessagesProvider.java 95834 2013-04-30 12:17:07Z ova $
 */

package ova.api;

import java.util.Locale;
import java.util.Map;


/**
 * Any JSF app. implementing this interface can participate in an unified message handling (when all keys and messages
 * are merged to a map and available via "msgs" EL, e.g. as #{msgs['mykey']}).
 *
 * @author  ova / last modified by $Author: ova $
 * @version $Revision: 95834 $
 */
public interface MessagesProvider
{
	//~ Methods ----------------------------------------------------------------

	/**
	 * Returns all mesages (key, text) to the module this interface is implemented for.
	 *
	 * @param  locale current Locale or null
	 * @return Map with message keys and message text.
	 */
	Map<String, String> getMessages(Locale locale);
}
