import models.Post;
import models.User;
import org.junit.Before;
import org.junit.Test;
import play.test.Fixtures;
import play.test.UnitTest;

import java.util.List;

public class BasicTest extends UnitTest {

    public static final String NAME = "Emtee";

    @Before
    public void setup() {
        Fixtures.deleteDatabase();
    }

    @Test
    public void createAndRetrieveUserTest() {
        new User("emtee@gmail.com", "test", NAME).save();

        final User user = User.find("byEmail", "emtee@gmail.com").first();

        assertNotNull(user);
        assertEquals(NAME, user.fullname);

        assertNotNull(User.connect("emtee@gmail.com", "test"));
        assertNull(User.connect("emtee@gmail.com", "atest"));
        assertNull(User.connect("emt", "test"));

    }

    @Test
    public void createPost() {
        // Create a new user and save it
        User user = new User("emtee@gmail.com", "secret", "emtee").save();

        // Create a new post
        new Post(user, "My first post", "Hello world").save();

        // Test that the post has been created
        assertEquals(1, Post.count());

        // Retrieve all posts created by Bob
        List<Post> posts = Post.find("byAuthor", user).fetch();

        // Tests
        assertEquals(1, posts.size());
        Post firstPost = posts.get(0);
        assertNotNull(firstPost);
        assertEquals(user, firstPost.author);
        assertEquals("My first post", firstPost.title);
        assertEquals("Hello world", firstPost.content);
        assertNotNull(firstPost.postedAt);
    }

}
