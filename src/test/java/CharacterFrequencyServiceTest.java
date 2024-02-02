import org.junit.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Map;

public class CharacterFrequencyServiceTest {

    @Test
    public void testCharacterFrequencyCalculation() {
        CharacterFrequencyService service = new CharacterFrequencyService();
        String input = "aaaaabcccc";
        Map<Character, Integer> expected = Map.of(
                'a', 5,
                'c', 4,
                'b', 1
        );
        Map<Character, Integer> result = service.calculateCharacterFrequency(input);
        assertEquals(expected, result);
    }

    @Test
    public void testEmptyString() {
        CharacterFrequencyService service = new CharacterFrequencyService();
        String input = "";
        Map<Character, Integer> expected = Map.of();
        Map<Character, Integer> result = service.calculateCharacterFrequency(input);
        assertEquals(expected, result);
    }

    @Test
    public void testStringWithSpaces() {
        CharacterFrequencyService service = new CharacterFrequencyService();
        String input = "hello world";
        Map<Character, Integer> expected = Map.of(
                'h', 1,
                'e', 1,
                'l', 3,
                'o', 2,
                'w', 1,
                'r', 1,
                'd', 1
        );
        Map<Character, Integer> result = service.calculateCharacterFrequency(input);
        assertEquals(expected, result);
    }

    @Test
    public void testStringWithSpecialCharacters() {
        CharacterFrequencyService service = new CharacterFrequencyService();
        String input = "!@#$%^&*()_+";
        Map<Character, Integer> expected = Map.of(
                '!', 1,
                '@', 1,
                '#', 1,
                '$', 1,
                '%', 1,
                '^', 1,
                '&', 1,
                '*', 1,
                '(', 1,
                ')', 1,
                '_', 1,
                '+', 1
        );
        Map<Character, Integer> result = service.calculateCharacterFrequency(input);
        assertEquals(expected, result);
    }
}
