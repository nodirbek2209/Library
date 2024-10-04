public class BookIDGenerator {
    public String generateBookID() {
        String bookID = "";
        for (int i = 0; i < 6; i++) {
            int random = (int) ((Math.random() * 9 + 1)%25);
            bookID += (char) ('A'+random);
        }
        return bookID;
    }
}
