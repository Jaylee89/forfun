package com.jstudio.push;

import java.io.IOException;

import javax.servlet.AsyncContext;

public class NotifyService {
	public void notify(String id) throws IOException {
		String body = "open";
		if (id != null) {
			AsyncContext ctx = ContextManager.remove(id);
			pushMsg(body, ctx);
		} else {
			for (AsyncContext asyncContext : ContextManager.getAllContext()) {
				pushMsg(body, asyncContext);
			}
			ContextManager.clear();
		}
	}
	
    private void pushMsg(String body, AsyncContext ctx) throws IOException {
    	if(ctx==null){
    		return;
    	}
        ctx.getResponse().getWriter().print(body);
        ctx.getResponse().setContentType("text/plain");
        ctx.complete();
    }
}
