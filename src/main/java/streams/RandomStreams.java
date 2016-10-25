package streams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Ken Kousen on 8/13/16.
 */
public class RandomStreams {
    public static final int LIMIT = 10;

    public static void main(String[] args) {
        Random r = new Random();
        r.ints()
                .limit(LIMIT)
                .sorted()
                .forEach(System.out::println);

        r.doubles()
                .limit(LIMIT)
                .filter(x -> x < 0.5)
                .sorted()
                .forEach(System.out::println);

        List<String> longs = r.longs()
                .limit(LIMIT)
                .mapToObj(Long::toString)
                .collect(Collectors.toList());

        List<Integer> listOfInts = r.ints()
                .limit(LIMIT)
//                .collect(Collectors.toList());
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
    }
}
