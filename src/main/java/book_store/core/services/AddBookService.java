package book_store.core.services;

import book_store.core.requests.book.AddBookRequest;
import book_store.core.response.CoreError;
import book_store.core.response.book.AddBookResponse;
import book_store.core.services.book.validators.AddBookRequestValidator;

import java.util.List;

public class AddBookService {

    @Autowired private BookRepository bookDatabase;
    @Autowired private AddBookRequestValidator addBookRequestValidator;

    public AddBookResponse execute(AddBookRequest addBookRequest){

        List<CoreError> errors = addBookRequestValidator.validate(addBookRequest);
        if (!errors.isEmpty()){
            return new AddBookResponse(errors);
        }

        bookDatabase.save(addBookRequest.getBook());
        return new AddBookResponse(addBookRequest.getBook());
    }

}
