package controllers;

import play.mvc.With;

/**
 * @author: emtee
 * @date: 5/14/12 4:41 PM
 */
@Check("admin")
@With(Secure.class)
public class Users extends CRUD {
}
