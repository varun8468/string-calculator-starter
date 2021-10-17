package calculator;

class StringCalculator {
    private final String delimiter = ",|\n";

    public int add(String input) {
        String[] numbers = input.split(delimiter);
        if(input.isEmpty())
            return 0;
        else if(input.contains(",") && input.length()==3)
            return getAddition(numbers);
        else if (input.length() == 1)
            return convert(input);
        else{
            return getAddition(numbers);
        }
    }


//    private String[] getInputsForCustomDelimiter(String input) {
//        String[] numbers = null;
//
//    }

//    private boolean isCustomDelimiter(String input) {
//        return input.startsWith("//");
//    }

    private int getAddition(String[] numbers){
        int sum = 0;
        for(String curr: numbers){
            sum = sum + Integer.parseInt(curr);
        }
        return sum;
    }
    private boolean empty(String input){
        return input.isEmpty();
    }
    private int convert(String input){
        return Integer.parseInt(input);
    }

}