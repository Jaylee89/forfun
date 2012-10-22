/**
 * Copyright (c) 2011-2012, Kid Zhou 周磊 (zhouleib1412@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jstudio.push;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.AsyncContext;

/**
 * @author kid
 * 
 */
public class ContextManager {

	final static ConcurrentHashMap<String, AsyncContext> contexts = new ConcurrentHashMap<String, AsyncContext>();

	public static void put(String id, AsyncContext asyncContext) {
		contexts.put(id, asyncContext);
	}

	public static void clear() {
		contexts.clear();
	}

	public static AsyncContext remove(String id) {
		AsyncContext context = contexts.remove(id);
		return context;
	}

	public static List<AsyncContext> getAllContext() {
		List<AsyncContext> asyncContexts = new ArrayList<AsyncContext>();
		for (Entry<String, AsyncContext> ctxEntry : contexts.entrySet()) {
			asyncContexts.add(ctxEntry.getValue());
		}
		return asyncContexts;
	}

	public static void remove(AsyncContext context) {
		Iterator<Entry<String, AsyncContext>> it = contexts.entrySet()
				.iterator();
		while (it.hasNext()) {
			Map.Entry<String, AsyncContext> entry = it.next();
			AsyncContext obj = entry.getValue();
			if (obj != null && obj.equals(context)) {
				it.remove();
			}
		}
	}
}
