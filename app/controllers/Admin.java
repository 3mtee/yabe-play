package controllers;

import models.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

/**
 * @author: emtee
 * @date: 5/14/12 5:14 PM
 */
@With(Secure.class)
public class Admin extends Controller {
    @Before
    static void setConnectedUser() {
        if (Security.isConnected()) {
            User user = User.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.fullname);
        }
    }

    public static void index() {
        render();
    }

}
