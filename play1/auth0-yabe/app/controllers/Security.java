package controllers;

import play.Play;
import play.libs.F;
import play.libs.WS;
import play.mvc.Before;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Security extends Secure.Security {

	static void onDisconnected() {
	    Application.index();
	}

	static void onAuthenticated() {
	    Admin.index();
	}

	static boolean check(String profile) {
		String jwt = session.get("username");
		if(jwt == null) {
			return false;
		}

		System.out.println("jwt: " + jwt);
		//TODO - Validate the jwt is valid and has the correct role - return true

		if("admin".equals(profile)) {
			return true;
	    }
	    return false;
	}

	public static void callback(String code) {

		Map<String,String> params = new HashMap<String, String>();
		params.put( "client_id", "Hel0gGbhEcJndakQkFE0HLFQZTlxeCdi");
		params.put( "client_secret", "9GS3apLJ1DFJpmUMTLEBfnD54NPe2QJ2ZLtWxdd8JM4QZyhQmr5HRAbnnX4Ld8W-");
		params.put( "redirect_uri", "http://localhost:9000/callback");
		params.put( "grant_type", "authorization_code");
		params.put( "code", code);
		F.Promise<WS.HttpResponse> r1 = WS
				.url(String.format("https://%s/oauth/token", "moonsault-test.auth0.com"))
				.mimeType("application/x-www-form-urlencoded")
				.setParameters(params)
				.postAsync();

		F.Promise<List<WS.HttpResponse>> promises = F.Promise.waitAll(r1);

		// Suspend processing here, until all three remote calls are complete.
		List<WS.HttpResponse> httpResponses = await(promises);
		String id_token = httpResponses.get(0).getJson().getAsJsonObject().get("id_token").toString();
		System.out.println(id_token);
		session.put("username", id_token);

		redirect("/admin");
	}

}