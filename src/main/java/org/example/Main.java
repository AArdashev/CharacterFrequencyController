package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CharacterFrequencyController {

    @PostMapping("/frequency")
    public ResponseEntity<Map<Character, Integer>> getCharacterFrequency(@RequestBody Map<String, String> requestBody) {
        String inputString = requestBody.get("inputString");
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : inputString.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Сортировка по убыванию частоты
        Map<Character, Integer> sortedFrequencyMap = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return ResponseEntity.ok(sortedFrequencyMap);
    }
}
