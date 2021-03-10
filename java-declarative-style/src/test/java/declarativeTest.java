import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static java.lang.Character.isDigit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class declarativeTest {
    @Test
    void test(){
        List<String> strings = Arrays.asList("Hello", "2No", "Hola", "1Dear", "Why", "Mars_Planet");

        assertEquals(12, getResult_imperative(strings));
        assertEquals(12, getResult_Declarative(strings));
    }

    private int getResult_imperative(List<String> strings) {
        int result = 0;
        for (String string : strings){
            if(isDigit(string.charAt(0))) continue;
            if (string.contains("_")) continue;
            result += string.length();
        }
        return result;
    }

    private int getResult_Declarative(List<String> strings){
        return strings.
                stream().
                filter(s -> !isDigit(s.charAt(0))).
                filter(s -> !s.contains("_")).
                mapToInt(String::length).
                sum();
    }

}
