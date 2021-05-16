public class Main {
    public static void main(String[]args) {
        
        StringBuilder sb = new StringBuilder("hello");
        
        //concatination
        sb.append(" world");
        
        System.out.println(sb);
        
        //get
        char ch = sb.charAt(3);
        System.out.println(ch);
        
        //set
        sb.setCharAt(0,'b');
        System.out.println(sb);
        
        //remove
        sb.deleteCharAt(5);
        System.out.println(sb);
        
    }   
}