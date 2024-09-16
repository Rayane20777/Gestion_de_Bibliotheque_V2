package Resources;



public class Generators {

    public static String isbnGenerator() {
        StringBuilder isbn = new StringBuilder(13);
        for (int i = 0; i < 13; i++) {
            isbn.append((int) (Math.random() * 10));
        }
        return isbn.toString();

    }
}
