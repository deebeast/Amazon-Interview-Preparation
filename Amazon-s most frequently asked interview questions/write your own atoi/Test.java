import java.util.Scanner;

class Test {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = "";
    while(s != "exit") {
      System.out.print("Enter String : ");
      s = scan.next();
      if(s.equals("exit")){
        System.out.println("The Program is exiting......");
        System.out.println();
        return;
      }
      else {
        try{
          System.out.println("The result is " + Test.atoi(s));
          System.out.println("\n");
        }
        catch(Exception e) {System.out.println("Exception occured: " + e);}
      }
    }
}
  public static int atoi(String s) throws InputError,IntgerLimitExceeded, NumberFormatException {
    if(s == null) {
      return 0;
    }
    if(s.contains(".")){
      throw new NumberFormatException("double values not allowed");
    }
    else{
      if(s.length() >= 10) {
        throw new IntgerLimitExceeded("The String Size should be less than or equal to 10 characters\nAs it uses Intger Limit 10^9 ");
      }
      else{
        int i = 0;
        int sign = 1;
        if(s.charAt(i) == '-') {
          s = s.substring(1);
          sign = -1;
        }
        else if(s.charAt(i) == '+') {
          s = s.substring(1);
        }
        int number = 0;

        boolean isNumericChar = isNumericChar(s.charAt(0));
        while(i < s.length()) {
          if(isNumericChar(s.charAt(i)) == false) {
            throw new InputError("Input String contains a non numeric character");
          }
          // char value for integers starts at 48 so minus '0'
          number = number * 10 + s.charAt(i) - '0';
           i++;
        }
        return number * sign;
      }
    }
  }

// A utility function to check whether x is numeric
  private static boolean isNumericChar(char x)
  {
    if((x >= '0' && x <= '9')) return true;
    else return false;
}

  public static class InputError extends Exception{
    InputError(String s){
      super(s);
    }
  }
  public static class IntgerLimitExceeded extends Exception {
    IntgerLimitExceeded(String s){
      super(s);
    }
  }
}
