package StreamAPI;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        int [] numbers = {11,2,3,4,5,6,6,7};
        ArrayList<Integer> listOne = Arrays.stream(numbers)
                .mapToObj(n -> n)
                .sorted((nOne,nTwo) ->Math.abs(nOne) - Math.abs(nTwo))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(listOne);
    }
}
