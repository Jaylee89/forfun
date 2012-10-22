package com.jstudio.push;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "keep-servlet", value = { "/keep" }, asyncSupported = true)
public class KeepServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	
	public Map<String,String> map = new HashMap<String,String>();
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KeepServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("devid");
		if(id==null||id.trim().equals("")){
			System.out.println("设备号为空");
			return;
		}
		System.out.println("设备"+id+"保持连接请求"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
		//查询设备是否已经通知需要上线
		if (isNotified(id)){
			response.getWriter().print("open");
			map.put(id, "false");
		}else{
		AsyncContext ctx = request.startAsync(request, response);
		ctx.addListener(new AsyncListener() {
			@Override
			public void onTimeout(AsyncEvent event) throws IOException {
				System.out.println("onTimeout");
				ContextManager.remove(event.getAsyncContext());
			}
			
			@Override
			public void onStartAsync(AsyncEvent arg0) throws IOException {
				System.out.println("onStartAsync");
			}
			
			@Override
			public void onError(AsyncEvent arg0) throws IOException {
				System.out.println("onError");
			}
			
			@Override
			public void onComplete(AsyncEvent arg0) throws IOException {
				System.out.println("onComplete");
			}
		});
		ctx.setTimeout(5*60*1000L);
		ContextManager.put(id, ctx);
	}
	}

	private boolean isNotified(String id) {
		return "true".equals(map.get(id)+"");
	}


}
