import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 5/13/2018.
 */
public class TagContentExtractorTest {

    @Test
    public void simpleTag() throws Exception {
        assertArrayEquals(Arrays.asList("hi").toArray(), TagContentExtractor.tagContents(Arrays.asList("<h1>hi</h1>")).toArray());
    }

    @Test
    public void noTag() throws Exception {
        assertArrayEquals(Arrays.asList().toArray(), TagContentExtractor.tagContents(Arrays.asList("hi")).toArray());

    }

    @Test
    public void nestedTag() throws Exception {
        assertArrayEquals(Arrays.asList("hi").toArray(), TagContentExtractor.tagContents(Arrays.asList("<h1><h2>hi</h2></h1>")).toArray());
    }

    @Test
    public void nestedTagWithInvalidContent() throws Exception {
        assertArrayEquals(Arrays.asList("hi").toArray(), TagContentExtractor.tagContents(Arrays.asList("<h1><h2>hi</h2>invalid</h1>")).toArray());
    }

    @Test
    public void multiTags() throws Exception {
        assertArrayEquals(Arrays.asList("hello", "hi").toArray(), TagContentExtractor.tagContents(Arrays.asList("<h1><h2>hi</h2></h1><a>hello</a>")).toArray());
    }

    @Test
    public void multiTags2() throws Exception {
        assertArrayEquals(Arrays.asList("Sanjay has no watch", "So wait for a while").toArray(), TagContentExtractor.tagContents(Arrays.asList("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>")).toArray());
    }

    @Test
    public void complexTag() throws Exception {
        assertArrayEquals(Arrays.asList("YjncQJp=mN8OV9WEviqvJT`YS$WD=^gryB)NWAal").toArray(),
                TagContentExtractor.tagContents(Arrays.asList("<GfYTkjn{CTWM-U@3Wv(h( ~Cnc9&BKA>YjncQJp=mN8OV9WEviqvJT`YS$WD=^gryB)NWAal</GfYTkjn{CTWM-U@3Wv(h( ~Cnc9&BKA>")).toArray());
    }

}
