package book_store.core.services;

import book_store.core.domain.Book;
import book_store.core.requests.book.GetAllBooksRequest;
import book_store.core.response.CoreError;
import book_store.core.response.book.GetAllBooksResponse;
import book_store.core.services.book.validators.GetAllBooksValidator;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class GetAllBooksService {

    @Autowired private BookRepository bookDatabase;
    @Autowired private GetAllBooksValidator getAllBooksValidator;

    public GetAllBooksResponse execute(GetAllBooksRequest getAllBooksRequest){
        List<CoreError> errors = getAllBooksValidator.validate(getAllBooksRequest);

        if (bookDatabase.findAll().isEmpty()){
            errors.add(new CoreError("database", "Database is empty"));
            return new GetAllBooksResponse(errors, new ArrayList<>());
        }
        List<Book>books = bookDatabase.findAll();
        return new GetAllBooksResponse(books);
    }
}
