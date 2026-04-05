import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

class BookTest {

    public static int minPrice = 250;
    private Book book;

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка размера книги < 500 стр")
    void givenSmallNumber_testIsBig_thenReturnFalse() {
        book = new Book("Игрок", 1866, new Author("Фёдор", "Достоевский", 8), 224);

        boolean result = book.isBig();

        Assertions.assertFalse(result);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка размера книги > 500 стр")
    void givenBigNumber_testIsBig_thenReturnTrue() {
        book = new Book("Империя вампиров", 2021, new Author("Джей", "Кристофф", 7), 800);

        boolean result = book.isBig();

        Assertions.assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Поиск слова, если оно есть в названии и авторе книги")
    void givenFittingWord_whenFindMatches_thenReturnTrue() {
        book = new Book("Айвенго", 1819, new Author("Вальтер", "Скотт", 9), 520);
        String word = "Вальтер";

        boolean result = book.matches(word);

        Assertions.assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Поиск слова, если его нет в названии и авторе книги")
    void givenUnfittingWord_whenFindMatches_thenReturnFalse() {
        book = new Book("Айвенго", 1819, new Author("Вальтер", "Скотт", 9), 520);
        String word = "Пушкин";

        boolean result = book.matches(word);

        Assertions.assertFalse(result);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Подсчёт цены книги выше минимальной")
    void givenExpensiveBook_whenCalculatePrice_thenReturnCorrectAnswer() {
        book = new Book("Игрок", 1866, new Author("Фёдор", "Достоевский", 8), 224);

        int result = book.estimatePrice();

        Assertions.assertEquals(1900, result);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Подсчёт цены книги ниже минимальной")
    void givenCheapBook_whenCalculatePrice_thenReturnMinPrice() {
        book = new Book("Айвенго", 1819, new Author("Вальтер", "Скотт", 4), 41);

        int result = book.estimatePrice();

        Assertions.assertEquals(250, result);
    }
}