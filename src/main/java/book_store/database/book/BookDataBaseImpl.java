package book_store.database.book;

import book_store.core.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDataBaseImpl implements BookDataBase {

    private Long id= 1L;
    private final List<Book> bookList = new ArrayList<>();

    @Override
    public List <Book> getBooks(){
        return bookList;
    }

    @Override
    public void add(Book book) {
        book.setId(id);
        bookList.add(book);
        id++;
    }

}
