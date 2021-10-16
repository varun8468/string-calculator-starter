package calculator;

class StringCalculator {

    public int add(String input) {
        String[] num = input.split(",");
        if(input.isEmpty())
            return 0;
        else if(input.contains(",") && input.length()==3)
            return convert(num[0]) + convert(num[1]);
        if(input.length()==1)
            return convert(input);
        return 0;
    }
    private boolean empty(String input){
        return input.isEmpty();
    }
    private int convert(String input){
        return Integer.parseInt(input);
    }

}