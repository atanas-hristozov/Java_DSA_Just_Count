import java.util.*;

public class CharacterCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        Map<Character, Integer> lowercaseCount = new HashMap<>();
        Map<Character, Integer> uppercaseCount = new HashMap<>();
        Map<Character, Integer> symbolCount = new HashMap<>();

        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowercaseCount.put(c, lowercaseCount.getOrDefault(c, 0) + 1);
            } else if (Character.isUpperCase(c)) {
                uppercaseCount.put(c, uppercaseCount.getOrDefault(c, 0) + 1);
            } else {
                symbolCount.put(c, symbolCount.getOrDefault(c, 0) + 1);
            }
        }

        char lowercaseMaxChar = getMaxCharacter(lowercaseCount);
        char uppercaseMaxChar = getMaxCharacter(uppercaseCount);
        char symbolMaxChar = getMaxCharacter(symbolCount);

        int lowercaseMaxCount = lowercaseCount.getOrDefault(lowercaseMaxChar, 0);
        int uppercaseMaxCount = uppercaseCount.getOrDefault(uppercaseMaxChar, 0);
        int symbolMaxCount = symbolCount.getOrDefault(symbolMaxChar, 0);

        System.out.println(symbolMaxCount > 0 ? symbolMaxChar + " " + symbolMaxCount : "-");
        System.out.println(lowercaseMaxCount > 0 ? lowercaseMaxChar + " " + lowercaseMaxCount : "-");
        System.out.println(uppercaseMaxCount > 0 ? uppercaseMaxChar + " " + uppercaseMaxCount : "-");
    }

    public static char getMaxCharacter(Map<Character, Integer> map) {
        char maxChar = '-';
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount || (entry.getValue() == maxCount && entry.getKey() < maxChar)) {
                maxChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return maxChar;
    }
}