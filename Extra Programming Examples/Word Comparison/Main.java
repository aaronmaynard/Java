public class Main {

    public static void main(String[] args) {

        String[] words = { "fast", "furious", "fart", "gocart" };

        // Word begins with
        for (String w: words) {
            if (w.startsWith("fa")) {
                System.out.println(w + " starts with fa");
            }
        }

        // Word ends with
        for (String w: words) {
            if (w.endsWith("rt")) {
                System.out.println(w + " ends with rt");
            }
        }
    }
}
