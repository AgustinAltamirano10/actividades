import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


/**
 * The test class NewsFeedTest.
 */
public class NewsFeedTest
{
    @Test
    public void testShow() {
        MessagePost messagePost = new MessagePost("Leonardo da Vinci", 
        "Had a great idea this morning.\n" + 
        "But now I forgot what it was. Something to do with flying...");
        messagePost.like();
        messagePost.like();
        PhotoPost photoPost = new PhotoPost("Alexander Graham Bell", 
        "experiment.jpg", 
        "I think I might call this thing ’telephone’.");
        photoPost.like();
        photoPost.like();
        photoPost.like();
        photoPost.like();
        NewsFeed feed = new NewsFeed();
        feed.addPost(messagePost);
        feed.addPost(photoPost);
        feed.show();
    }

    @Test
    public void test1()
    {
        NewsFeed feed = new NewsFeed();
        Post post = new Post("carlos");
        Post post1 = new Post("raul");
        Post post2 = new Post("jorge");
        Post post3 = new Post("juan");
        feed.addPost(post);
        feed.addPost(post1);
        feed.addPost(post2);
        feed.addPost(post3);
        feed.show();
    }

    @Test
    public void test3()
    {
        MessagePost mensaje = new MessagePost("carlos", "hola");
        assertEquals("hola", mensaje.getText());
    }
}
