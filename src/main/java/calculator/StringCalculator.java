package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCalculator {
    private final String delimiter = ",|\n";

    public int add(String input) {
        if(empty(input))
            return 0;
        else if(isCustomDelimiter(input)){
            String[] numbers = getInputsForCustomDelimiters(input);
            return getAddition(numbers);
        }
        else if(isDelimiterNewLineOrComma(input)){
            String[] numbers = getInputForNonCustomDelimiters(input);
            return getAddition(numbers);
        }
        else return Integer.parseInt(input);
    }


//    private String[] getInputsForCustomDelimiter(String input) {
//        String[] numbers = null;
//
//    }

//    private boolean isCustomDelimiter(String input) {
//        return input.startsWith("//");
//    }
    private String [] getInputsForCustomDelimiters(String input){
        String[] numbers = null;
        Matcher m1 = Pattern.compile("//(.+)\n(.*)").matcher(input);
        Matcher m2 = Pattern.compile("//\\[(.+)\\]\n(.*)").matcher(input);
        if(m1.matches()){
            String delimiter = m1.group(1);
            String toSplit = m1.group(2);
            String regex = String.format("[%s]{1,}",delimiter);
            numbers = toSplit.split(regex);
        }else if(m2.matches()){
            String delimiter1 = m2.group(1);
            String str = m2.group(2);
            String regex = String.format("[%s]{1,}",delimiter1);
            numbers = str.split(regex);
        }
        return numbers;
    }
    private String[] getInputForNonCustomDelimiters(String numbers){
        String[] input = null;
        input = numbers.split(",|\n");
        return input;
    }
    private int getAddition(String[] numbers){
        int sum = 0;
        for(String n : numbers){
            sum += Integer.parseInt(n);
        }
        return sum;
    }
    private boolean isCustomDelimiter(String numbers){
        return numbers.startsWith("//");
    }
    private boolean empty(String input){
        return input.isEmpty();
    }
    private int convert(String input){
        return Integer.parseInt(input);
    }

    private boolean isDelimiterNewLineOrComma(String numbers){
        return numbers.contains(",")||numbers.contains("\n");
    }

}