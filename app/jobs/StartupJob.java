package jobs;

import static play.Logger.debug;

import java.io.File;
import models.Item;


import org.joda.time.DateTimeZone;  


import play.Logger;
import play.Play;
import play.jobs.Job;  
import play.jobs.OnApplicationStart;  
import play.test.Fixtures;  


@OnApplicationStart
public class StartupJob extends Job {  
	public static final DateTimeZone TIMEZONE = DateTimeZone.forOffsetHours(-7);  


	@Override  
	public void doJob() {  
		Logger.info("[StartUp] init environment...");  
		/*  
		 * if (Play.mode.isProd()) {  
		 * //DateTimeZone.setDefault(TIMEZONE);  
		 * }  
		 */  
		Fixtures.delete();  
		if (Item.count() == 0) {  
			debug("loading ... default data"); 
			Fixtures.loadModels("initial-data.yml");  
		}  
	}  
}  
