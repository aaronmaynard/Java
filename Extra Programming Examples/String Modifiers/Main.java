public class Main {
    public static void main(String[] args) {

        String s = "aaronmaynardaaronmaynard";

        System.out.println(s.indexOf("may", 10));

        String a = "BACON ";
        String b = "burger";
        String c = "     cheese        ";

        System.out.println(a.concat(b));
        System.out.println(a.replace('A', 'E'));
        System.out.println(b.toUpperCase());
        System.out.println(a.toLowerCase());
        System.out.println(c.trim());
    }
}
