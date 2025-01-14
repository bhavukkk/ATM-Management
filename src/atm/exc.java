package atm;
public class exc {
    public static void main(String[] args) {

            String s = "Bhavuk Moolchandani";
        System.out.println(s.split(" ")[0]);


//            String s = "Rose";
//        try {
//            check(s);
//        }catch (InvalidStringException e){
//            System.out.println("Caught "+ e);
//        }
    }
    static void check(String s) throws InvalidStringException{
        if(!s.equals("India")){
            throw new InvalidStringException(s);
        }else {
            System.out.println("Valid String");
        }
    }
}
class InvalidStringException extends Exception{
    String s;
    InvalidStringException(String str){
        s = str;
    }
    public String toString(){
        return "Invalid String";
    }
}
