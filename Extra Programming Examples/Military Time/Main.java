public class Main {
    public static void main(String[] args) {
        Format formatObject = new Format();
        System.out.println(formatObject.toMilitary());
        System.out.println(formatObject.toString());
        
        formatObject.setTime(13, 27, 6);
        System.out.println(formatObject.toMilitary());
        System.out.println(formatObject.toString());
    }
}
