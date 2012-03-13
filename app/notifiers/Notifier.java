package notifiers;

import java.util.*;

import play.*;
import play.mvc.*;

public class Notifier extends Mailer {

	private static boolean enabled = ("true".equals(Play.configuration.getProperty("mail.enabled", "true").toLowerCase()));
	
    public static void sendResult(int id, String project, String version, boolean passed, String[] to) {
    	
    	if (!enabled) return;

        setSubject("[" + Play.configuration.getProperty("mail.tag", "calimoucho")+"] %s - For %s, %s", (passed ? "PASSED" : "FAILED"), project, version);
        setFrom(Play.configuration.getProperty("mail.from"));
        addRecipient((Object[])to);
        send(id);
    }
    
}

