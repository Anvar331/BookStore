package book_store.core.services.book.validators;

import book_store.core.requests.book.GetAllBooksRequest;
import book_store.core.response.CoreError;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAllBooksValidator {

    public List<CoreError> validate (GetAllBooksRequest getAllBooksRequest){

        return new ArrayList<>();

    }
}
