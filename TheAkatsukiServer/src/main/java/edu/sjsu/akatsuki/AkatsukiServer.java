package edu.sjsu.akatsuki;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;
import org.restlet.Component;
import org.restlet.ext.jaxrs.JaxRsApplication;

public class AkatsukiServer extends Application {

	public static void main(String[] args) throws Exception {

		// Server server = new
		// Server(Protocol.HTTP,8080,HelloServerResource.class);
		// server.start();

		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8080);
		component.getDefaultHost().attach(new AkatsukiServer());
		component.start();

	}

	@Override
	public Restlet createInboundRoot() {

		Router router = new Router(getContext());
		router.attach("/newgame", NewGameResource.class);
		router.attach("/startGame", AkatsukiResource.class);
		
		return router;
	}

}
