package book_store.core.response.book;

import book_store.core.domain.Book;
import book_store.core.response.CoreError;

import java.util.List;

public class GetAllBooksResponse {

    private List<Book> books;

    public GetAllBooksResponse(List<Book>books){
        this.books = books;
    }

    public GetAllBooksResponse(List<CoreError> errors, List<Book>books){
        super(errors);
    }

    public List<Book> getProducts(){
        return books;
    }
}
