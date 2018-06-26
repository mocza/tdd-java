import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Salty on 5/13/2018.
 */
public class TagContentExtractor2 {
    private static final Pattern p = Pattern.compile("<([^<>]+)>(.*)</\\1>");
    private static final Pattern tagPattern = Pattern.compile(".*<([^<>]+)>.*");

    public static List<String> tagContents(List<String> input){
        List<String> output = new LinkedList<>();

        for(String line : input) {
            List<String> elems = getContent(line, 0);
            output.addAll(elems.isEmpty() ? Arrays.asList("None") : elems);
        }

        return output;
    }

    private static List<String> getContent(String s, int count) {
        List<String> ret = new ArrayList<>();
        if (tagPattern.matcher(s).matches()) {
            Matcher m = p.matcher(s);
            while (m.find()) {
                String elem = m.group(2);
                ret.addAll(getContent(elem, count + 1));
            }
        } else if (count > 0 && !s.isEmpty()) {
            ret.add(s);
        }
        return ret;
    }


}
