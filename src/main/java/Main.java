public class Main {
    public static void main(String[] args) {
        Book book = new Book("Айвенго", 1819, new Author("Вальтер", "Скотт", 9), 528);
        System.out.println("Эта книга большая? " + book.isBig());
        System.out.println("В описании книги есть слово Скотт? " + book.matches("Скотт"));
        System.out.println("В описании книги есть слово Онегин? " + book.matches("Онегин"));
        System.out.println("Оценочная стоимость книги: " + book.estimatePrice() + " руб.");
    }
}
