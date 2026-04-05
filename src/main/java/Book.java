public class Book {
    public String title;
    public int releaseYear;
    public Author author;
    public int pages;

    public boolean isBig() {
        return pages > 500;
    }

    public boolean matches(String word) {
        return (title.contains(word) || author.name.contains(word) || author.surname.contains(word));
    }

    public static int minPrice = 250;
    public int estimatePrice() {
        int price = (int) Math.floor(3 * pages * (Math.sqrt(author.rating)));
        return Math.max(minPrice, price);
    }

    public Book(String title, int releaseYear, Author author, int pages){
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
        this.pages = pages;
    }
}
