package recursion.recursion.recursion.recursion.recursion;

public class ReverseString {

    public static String reverse(String input){
        if(input.equals("")){
            return "";
        }
        return reverse(input.substring(1 )) + input.charAt(0);
    }
    public static void main(String[] args) {
//        System.out.println(reverse("Hello, I am playing with recursion"));
        System.out.println(reverse("salah"));
    }
}
