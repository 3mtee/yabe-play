package controllers;

import play.mvc.With;

/**
 * @author: emtee
 * @date: 5/14/12 4:40 PM
 */

@Check("admin")
@With(Secure.class)
public class Comments extends CRUD {
}
