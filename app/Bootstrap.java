import models.User;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

/**
 * @author: emtee
 * @date: 5/14/12 2:50 PM
 */

@OnApplicationStart
public class Bootstrap extends Job {
    @Override
    public void doJob() throws Exception {
        // Check if the database is empty
        if(User.count() == 0) {
            Fixtures.loadModels("initial-data.yml");
        }
    }
}
