package controllers;

import play.mvc.With;

/**
 * @author: emtee
 * @date: 5/14/12 4:32 PM
 */
@Check("admin")
@With(Secure.class)
public class Posts extends CRUD {
}
