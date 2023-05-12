package ss;

import java.util.Scanner;

public class Group3CFG {
    public static String def_letters = "";
    public static String rep_def_letters = "";
    public static String grammar = "";
    public static String replacer = "";
    public static String answer = "";

    public static boolean doHaveReplacer = false;

    public static void main(String[] args) {
        inputProcess();
    }

    public static void inputProcess() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter default letters: ");
        def_letters = scanner.nextLine();

        // -----------------------------------------------------------------------------------------------------------------

        System.out.println("\n*****\nNote\n1. Replacer must be on uppercase and besides lowercase letters [aMb]\n2. " +
                "Only those letters that is placed beside the Uppercase letter are affected by the rule of replace\n*****\n");
        System.out.print("Enter default letters with replacer: ");
        rep_def_letters = scanner.nextLine();
        replacerInput_checker(rep_def_letters);

        // -----------------------------------------------------------------------------------------------------------------

        System.out.print("\nEnter grammar: ");
        grammar = scanner.nextLine();
        grammar_checker();

        // -----------------------------------------------------------------------------------------------------------------

        displayProcess();
        scanner.close();
    }

    // Display
    public static void displayProcess() {
        System.out.println();
        System.out.println("S -> " + def_letters + " | " + rep_def_letters);
        if (grammar.equals(def_letters)) {
            System.out.println("S -> " + def_letters);
            System.out.println();
            System.out.println("Output: " +def_letters);

        } else {
            System.out.println("S -> " + rep_def_letters);
            System.out.println();

            replacer = replacerChecker(rep_def_letters);
            loop_replacer(rep_def_letters, replacer, 0);
        }
    }

    // Grammar Checker
    public static void grammar_checker() {
        boolean containsAll = true;
        containsAll = true;
        for (int i = 0; i < def_letters.length(); i++) {
            if (grammar.indexOf(def_letters.charAt(i)) == -1) {
                containsAll = false;
                break;
            }
        }

        if (!containsAll) {
            System.out.print("\033\143");
            System.out.println("Error: (Grammar) input must contain the letters of the default letters.");
            System.out.println();
            inputProcess();
        }

    }

    // Input Checkers
    public static void replacerInput_checker(String rep_def_letters) {

        // check replacer making sure it is not loweredcase
        for (int j = 0; j < rep_def_letters.length(); j++) {
            if (!def_letters.contains(String.valueOf(rep_def_letters.charAt(j)))) {
                if (Character.isLowerCase(rep_def_letters.charAt(j))) {
                    System.out.print("\033\143");
                    System.out.println(
                            "Error: (Replacer) input must be on uppercase.");
                    System.out.println();
                    inputProcess();
                }
            }
        }
        // check if replacer with grammar contains lowercase letter beside of it
        try {
            for (int i = 0; i < rep_def_letters.length(); i++) {
                char letter = rep_def_letters.charAt(i);
                if (Character.isUpperCase(letter)) {
                    if (Character.isLowerCase(rep_def_letters.charAt(i - 1))
                            && Character.isLowerCase(rep_def_letters.charAt(i + 1))) {
                        break;
                    } else {
                        System.out.print("\033\143");
                        System.out.println(
                                "Error: (Replacer) input must contains lowercase letter beside of it.  [sample (aMb)]");
                        System.out.println();
                        inputProcess();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print("\033\143");
            System.out.println(
                    "Error: (Replacer) input must contains lowercase letter beside of it.");
            System.out.println();
            inputProcess();
        }

        // check if grammar contains all letters of defletters
        boolean containsAll = true;
        containsAll = true;
        for (int i = 0; i < def_letters.length(); i++) {
            if (rep_def_letters.indexOf(def_letters.charAt(i)) == -1) {
                containsAll = false;
                break;
            }
        }

        if (!containsAll) {
            System.out.print("\033\143");
            System.out.println(
                    "Error: (Grammar) input must contain letters of the default letters.");
            System.out.println();
            inputProcess();
        }
    }

    // Count Letters
    public static int countLetters(String grammar, char letter) {
        int count = 0;
        for (int i = 0; i < grammar.length(); i++) {
            if (grammar.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }

    // Replacer Remover
    public static String replacer_remover(String output) {
        String updatedOutput = "";

        // Grab first uppercase na makita nya sa loop tas break right after
        int index = -1;
        for (int i = 0; i < output.length(); i++) {
            if (Character.isUpperCase(output.charAt(i))) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            // tatanggalin lang yung unang Uppercase
            updatedOutput = output.substring(0, index) + output.substring(index + 1);
        } else {
            // pag walang nahanap edi same padin
            updatedOutput = output;
        }
        // removes parenthesis
        updatedOutput = updatedOutput.replace("(", "");
        updatedOutput = updatedOutput.replace(")", "");
        return updatedOutput;
    }

    // Checker if there's still Replacer
    public static String replacerChecker(String output) {

        // Grab first uppercase or replacer na makita nya sa loop
        int index = -1;
        for (int i = 0; i < output.length(); i++) {
            if (Character.isUpperCase(output.charAt(i))) {
                index = i;
                // return yung Uppercase kasama nung nasa left and right na lowecase
                doHaveReplacer = true;
                return String.valueOf(output.charAt(index - 1)) + String.valueOf(output.charAt(index))
                        + String.valueOf(output.charAt(index + 1));

            }
        }
        doHaveReplacer = false;

        // else return same output
        return output;
    }

    // Loop Replacer
    public static void loop_replacer(String rep_def_letters, String replacer, int specific_gramNum) {

        specific_gramNum = countLetters(grammar, replacer.charAt(0));

        System.out.println(replacer.charAt(1) + " -> " + replacer + " | E");
        while (countLetters(rep_def_letters, replacer.charAt(0)) != specific_gramNum) {
            System.out.println(replacer.charAt(1) + " -> " + replacer);
            rep_def_letters = rep_def_letters.replace(String.valueOf(replacer.charAt(1)), "(" + replacer + ")");
            System.out.println(replacer.charAt(1) + " -> " + rep_def_letters);
        }
        System.out.println(replacer.charAt(1) + " -> E");
        System.out.println(replacer.charAt(1) + " -> " + replacer_remover(rep_def_letters));

        replacer = replacerChecker(replacer_remover(rep_def_letters));
        if (doHaveReplacer) {
            System.out.println();
            loop_replacer(replacer_remover(rep_def_letters), replacer, 0);
        } else {
            System.out.println();
            System.out.println("Output: " + replacer_remover(rep_def_letters));
        }
    }

}