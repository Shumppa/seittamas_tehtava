package javademo;

public class NonFictionBook extends Book{
    public NonFictionBook(String title, String author, int pages, int copies) {
        super(title, author, pages, copies);
    }

    @Override
    public String categorize() {
        return "Tietokirja";
    }
}

