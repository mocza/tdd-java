import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Salty on 5/13/2018.
 */
public class TagContentExtractor {
    private static final Pattern p = Pattern.compile("<([^<>]+)>(.*)</\\1>");
    private static final Pattern tagPattern = Pattern.compile(".*<([^<>]+)>.*");

    public static List<String> tagContents(List<String> input){
        List<String> output = new LinkedList<>();

        for(String line : input){

            Queue<String> contents = new LinkedList<>();
            contents.offer(line);

            while (!contents.isEmpty() && tagPattern.matcher(contents.peek()).matches()) {
                Matcher m = p.matcher(contents.poll());
                while (m.find()) {
                    String elem = m.group(2);
                    if (!tagPattern.matcher(elem).matches() && !elem.isEmpty()) {
                        output.add(elem);
                    } else {
                        contents.offer(elem);
                    }
                }
            }


        }

        return output;
    }


}
