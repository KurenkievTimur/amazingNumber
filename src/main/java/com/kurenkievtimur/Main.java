package com.kurenkievtimur;

import java.util.Scanner;

import static com.kurenkievtimur.Param.getParam;
import static com.kurenkievtimur.Property.*;

public class Main {
    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");

        supportRequest();

        boolean isExit = false;
        while (!isExit) {
            System.out.print("\nEnter a request: ");
            String[] input = scanner.nextLine().split(" ");

            Param param = getParam(input);
            switch (param) {
                case ONE_PARAM -> printOneParam(input);
                case TWO_PARAM -> printTwoParam(input);
                case MORE_PARAM -> printMoreParam(input);
                case HELP -> supportRequest();
                case EXIT -> isExit = true;
                default -> System.out.println("\nThe first parameter should be a natural number or zero.");
            }
        }
        System.out.println("\nGoodbye!");
    }

    public static void supportRequest() {
        System.out.println("\nSupported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }

    public static void printProperties(long number) {
        System.out.printf("\nProperties of %s\n", number);

        String even = EVEN.isEven(number) ? "true" : "false";
        String odd = ODD.isOdd(number) ? "true" : "false";
        String buzz = BUZZ.isBuzz(number) ? "true" : "false";
        String duck = DUCK.isDuck(number) ? "true" : "false";
        String palindromic = PALINDROMIC.isPalindromic(number) ? "true" : "false";
        String gapful = GAPFUL.isGapful(number) ? "true" : "false";
        String spy = SPY.isSpy(number) ? "true" : "false";
        String square = SQUARE.isSquare(number) ? "true" : "false";
        String sunny = SUNNY.isSunny(number) ? "true" : "false";
        String jumping = JUMPING.isJumping(number) ? "true" : "false";
        String happy = HAPPY.isHappy(number) ? "true" : "false";
        String sad = SAD.isSad(number) ? "true" : "false";

        System.out.printf("\t\teven: %s\n", even);
        System.out.printf("\t\todd: %s\n", odd);
        System.out.printf("\t\tbuzz: %s\n", buzz);
        System.out.printf("\t\tduck: %s\n", duck);
        System.out.printf("\t\tpalindromic: %s\n", palindromic);
        System.out.printf("\t\tgapful: %s\n", gapful);
        System.out.printf("\t\tspy: %s\n", spy);
        System.out.printf("\t\tsquare: %s\n", square);
        System.out.printf("\t\tsunny: %s\n", sunny);
        System.out.printf("\t\tjumping: %s\n", jumping);
        System.out.printf("\t\thappy: %s\n", happy);
        System.out.printf("\t\tsad: %s\n", sad);
    }

    public static void printProperties(long[] numbers) {
        long number = numbers[0];
        long length = number + numbers[1];

        for (long i = number; i < length; i++) {
            String even = EVEN.isEven(i) ? "even, " : "";
            String odd = ODD.isOdd(i) ? "odd, " : "";
            String buzz = BUZZ.isBuzz(i) ? "buzz, " : "";
            String duck = DUCK.isDuck(i) ? "duck, " : "";
            String palindromic = PALINDROMIC.isPalindromic(i) ? "palindromic, " : "";
            String gapful = GAPFUL.isGapful(i) ? "gapful, " : "";
            String spy = SPY.isSpy(i) ? "spy, " : "";
            String square = SQUARE.isSquare(i) ? "square, " : "";
            String sunny = SUNNY.isSunny(i) ? "sunny, " : "";
            String jumping = JUMPING.isJumping(i) ? "jumping, " : "";
            String happy = HAPPY.isHappy(i) ? "happy, " : "";
            String sad = SAD.isSad(i) ? "sad" : "";

            System.out.printf("\t\t%d is %s%s%s%s%s%s%s%s%s%s%s%s\n", i, even, odd, buzz, duck, palindromic, gapful, spy, square, sunny, jumping, happy, sad);
        }
    }

    public static void printProperties(long[] numbers, String[] properties) {
        long number = numbers[0];
        long secondDigit = numbers[1];

        for (long i = number, counter = 0; counter < secondDigit; i++) {
            if (isNumberProperties(i, properties)) {
                String even = EVEN.isEven(i) ? "even, " : "";
                String odd = ODD.isOdd(i) ? "odd, " : "";
                String buzz = BUZZ.isBuzz(i) ? "buzz, " : "";
                String duck = DUCK.isDuck(i) ? "duck, " : "";
                String palindromic = PALINDROMIC.isPalindromic(i) ? "palindromic, " : "";
                String gapful = GAPFUL.isGapful(i) ? "gapful, " : "";
                String spy = SPY.isSpy(i) ? "spy, " : "";
                String square = SQUARE.isSquare(i) ? "square, " : "";
                String sunny = SUNNY.isSunny(i) ? "sunny, " : "";
                String jumping = JUMPING.isJumping(i) ? "jumping, " : "";
                String happy = HAPPY.isHappy(i) ? "happy, " : "";
                String sad = SAD.isSad(i) ? "sad" : "";

                System.out.printf("\t\t%d is %s%s%s%s%s%s%s%s%s%s%s%s\n", i, even, odd, buzz, duck, palindromic, gapful, spy, square, sunny, jumping, happy, sad);
                counter++;
            }
        }
    }

    public static boolean isNumberProperties(long number, String[] properties) {
        for (String property : properties) {
            Property propertyEnum = Property.valueOf(property.replace("-", ""));
            switch (propertyEnum) {
                case EVEN -> {
                    if (propertyEnum.isEven(number) && property.contains("-")) return false;
                    else if (!propertyEnum.isEven(number) && !property.contains("-")) return false;
                }
                case ODD -> {
                    if (propertyEnum.isOdd(number) && property.contains("-")) return false;
                    else if (!propertyEnum.isOdd(number) && !property.contains("-")) return false;
                }
                case BUZZ -> {
                    if (propertyEnum.isBuzz(number) && property.contains("-")) return false;
                    else if (!propertyEnum.isBuzz(number) && !property.contains("-")) return false;
                }
                case DUCK -> {
                    if (propertyEnum.isDuck(number) && property.contains("-")) return false;
                    else if (!propertyEnum.isDuck(number) && !property.contains("-")) return false;
                }
                case PALINDROMIC -> {
                    if (propertyEnum.isPalindromic(number) && property.contains("-")) return false;
                    else if (!propertyEnum.isPalindromic(number) && !property.contains("-")) return false;
                }
                case GAPFUL -> {
                    if (propertyEnum.isGapful(number) && property.contains("-")) return false;
                    else if (!propertyEnum.isGapful(number) && !property.contains("-")) return false;
                }
                case SPY -> {
                    if (propertyEnum.isSpy(number) && property.contains("-")) return false;
                    else if (!propertyEnum.isSpy(number) && !property.contains("-")) return false;
                }
                case SQUARE -> {
                    if (propertyEnum.isSquare(number) && property.contains("-")) return false;
                    else if (!propertyEnum.isSquare(number) && !property.contains("-")) return false;
                }
                case SUNNY -> {
                    if (propertyEnum.isSunny(number) && property.contains("-")) return false;
                    else if (!propertyEnum.isSunny(number) && !property.contains("-")) return false;
                }
                case JUMPING -> {
                    if (propertyEnum.isJumping(number) && property.contains("-")) return false;
                    else if (!propertyEnum.isJumping(number) && !property.contains("-")) return false;
                }
                case HAPPY -> {
                    if (propertyEnum.isHappy(number) && property.contains("-")) return false;
                    else if (!propertyEnum.isHappy(number) && !property.contains("-")) return false;
                }
                case SAD -> {
                    if (propertyEnum.isSad(number) && property.contains("-")) return false;
                    else if (!propertyEnum.isSad(number) && !property.contains("-")) return false;
                }
            }
        }

        return true;
    }

    public static boolean isNaturalOrZero(String number) {
        try {
            long positiveNumber = Long.parseLong(number);
            return positiveNumber >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNatural(String number) {
        try {
            long absoluteNumber = Long.parseLong(number);
            return absoluteNumber > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isUnAvailableProperties(String[] properties) {
        for (String property : properties) {
            if (isUnAvailableProperties(property))
                return true;
        }

        return false;
    }

    public static boolean isUnAvailableProperties(String property) {
        return !property.toUpperCase().matches("EVEN|ODD|BUZZ|DUCK|PALINDROMIC|GAPFUL|SPY|SQUARE|SUNNY|JUMPING|HAPPY|SAD" +
                "|-EVEN|-ODD|-BUZZ|-DUCK|-PALINDROMIC|-GAPFUL|-SPY|-SQUARE|-SUNNY|-JUMPING|-HAPPY|-SAD");
    }

    public static String getUnAvailableProperties(String[] properties) {
        StringBuilder builder = new StringBuilder();

        for (String property : properties) {
            if (isUnAvailableProperties(property))
                builder.append(property).append(", ");
        }

        builder.delete(builder.length() - 2, builder.length());

        return builder.toString();
    }

    public static boolean isMutuallyExclusiveProperties(String[] properties) {
        for (int i = 0; i < properties.length; i++) {
            String firstProperty = properties[i];
            for (int j = i; j < properties.length - 1; j++) {
                String secondProperty = properties[j + 1];
                if (isMutuallyExclusiveProperties(firstProperty, secondProperty))
                    return true;
            }
        }

        return false;
    }

    public static boolean isMutuallyExclusiveProperties(String firstProperty, String secondProperty) {
        if (firstProperty.contains("-") || secondProperty.contains("-"))
            return isNegativeMutuallyExclusiveProperties(firstProperty, secondProperty);

        boolean firstPair = firstProperty.equals("EVEN") && secondProperty.equals("ODD");
        boolean secondPair = firstProperty.equals("DUCK") && secondProperty.equals("SPY");
        boolean thirdPair = firstProperty.equals("SUNNY") && secondProperty.equals("SQUARE");
        boolean fourthPair = firstProperty.equals("HAPPY") && secondProperty.equals("SAD");

        boolean changeFirstPair = firstProperty.equals("ODD") && secondProperty.equals("EVEN");
        boolean changeSecondPair = firstProperty.equals("SPY") && secondProperty.equals("DUCK");
        boolean changeThirdPair = firstProperty.equals("SQUARE") && secondProperty.equals("SUNNY");
        boolean changeFourthPair = firstProperty.equals("SAD") && secondProperty.equals("HAPPY");

        boolean original = firstPair || secondPair || thirdPair || fourthPair;
        boolean change = changeFirstPair || changeSecondPair || changeThirdPair || changeFourthPair;

        return original || change;
    }

    public static boolean isNegativeMutuallyExclusiveProperties(String firstProperty, String secondProperty) {
        boolean firstPair = firstProperty.equals("-EVEN") && secondProperty.equals("-ODD");
        boolean secondPair = firstProperty.equals("-DUCK") && secondProperty.equals("-SPY");
        boolean thirdPair = firstProperty.equals("-SUNNY") && secondProperty.equals("-SQUARE");
        boolean fourthPair = firstProperty.equals("-HAPPY") && secondProperty.equals("-SAD");

        boolean changeFirstPair = firstProperty.equals("-ODD") && secondProperty.equals("-EVEN");
        boolean changeSecondPair = firstProperty.equals("-SPY") && secondProperty.equals("-DUCK");
        boolean changeThirdPair = firstProperty.equals("-SQUARE") && secondProperty.equals("-SUNNY");
        boolean changeFourthPair = firstProperty.equals("-SAD") && secondProperty.equals("-HAPPY");

        boolean original = firstPair || secondPair || thirdPair || fourthPair;
        boolean change = changeFirstPair || changeSecondPair || changeThirdPair || changeFourthPair;

        boolean negative = original || change;

        boolean firstContradiction = firstProperty.replace("-", "").equals(secondProperty);
        boolean secondContradiction = secondProperty.replace("-", "").equals(firstProperty);

        boolean contradiction = firstContradiction || secondContradiction;

        return negative || contradiction;
    }

    public static String getMutuallyExclusiveProperties(String[] properties) {
        StringBuilder builder = new StringBuilder();

        outerLoop:
        for (int i = 0; i < properties.length; i++) {
            String firstProperty = properties[i];
            for (int j = i; j < properties.length - 1; j++) {
                String secondProperty = properties[j + 1];
                if (isMutuallyExclusiveProperties(firstProperty, secondProperty)) {
                    builder.append(firstProperty).append(", ").append(secondProperty);
                    break outerLoop;
                }
            }
        }

        return builder.toString();
    }

    public static long[] getNumbers(String[] stringNumbers) {
        long[] numbers = new long[2];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Long.parseLong(stringNumbers[i]);
        }

        return numbers;
    }

    public static String[] getProperties(String[] input) {
        String[] properties = new String[input.length - 2];

        for (int i = 0; i < properties.length; i++) {
            properties[i] = input[i + 2].toUpperCase();
        }

        return properties;
    }

    public static void printOneParam(String[] input) {
        if (isNaturalOrZero(input[0])) {
            long number = Long.parseLong(input[0]);
            printProperties(number);
        } else
            System.out.println("\nThe first parameter should be a natural number or zero.");
    }

    public static void printTwoParam(String[] input) {
        if (isNaturalOrZero(input[0]) && isNatural(input[1])) {
            long[] numbers = getNumbers(input);
            printProperties(numbers);
        } else if (!isNaturalOrZero(input[0]))
            System.out.println("\nThe first parameter should be a natural number or zero.");
        else
            System.out.println("\nThe second parameter should be a natural number.");
    }

    public static void printMoreParam(String[] input) {
        String[] properties = getProperties(input);
        if (isNaturalOrZero(input[0]) && isNatural(input[1]) && !isUnAvailableProperties(properties) && !isMutuallyExclusiveProperties(properties)) {
            long[] numbers = getNumbers(input);
            System.out.println();
            printProperties(numbers, properties);
        } else if (!isNaturalOrZero(input[0])) {
            System.out.println("\nThe first parameter should be a natural number or zero.");
        } else if (!isNatural(input[1])) {
            System.out.println("\nThe second parameter should be a natural number.");
        } else if (isUnAvailableProperties(properties)) {
            String unAvailableProperties = getUnAvailableProperties(properties);
            boolean singular = unAvailableProperties.split(", ").length == 1;
            System.out.printf("\nThe %s [%S] %s wrong.\n", singular ? "property" : "properties", unAvailableProperties, singular ? "is" : "are");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
        } else if (isMutuallyExclusiveProperties(properties)) {
            String mutuallyExclusiveProperties = getMutuallyExclusiveProperties(properties);
            System.out.printf("\nThe request contains mutually exclusive properties: [%S]\n", mutuallyExclusiveProperties);
            System.out.println("There are no numbers with these properties.");
        }
    }
}