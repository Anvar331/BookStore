package book_store.console_ui.book;

import book_store.console_ui.UIAction;
import book_store.core.domain.Book;
import book_store.core.requests.book.AddBookRequest;
import book_store.core.response.book.AddBookResponse;
import book_store.core.services.AddBookService;
import book_store.core.services.Autowired;

import java.util.Scanner;

public class AddBookUIAction implements UIAction {

    @Autowired
    private AddBookService addBookService;

    @Override
    public void execute(){

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter title of the book: ");
        String title = in.nextLine();

        System.out.println("Please enter name of the author");
        String author = in.nextLine();

        System.out.println("Please enter date of publishing");
        Integer dateOfPublishing = in.nextInt();

        Book newBook = new Book(title, author, dateOfPublishing);

        AddBookRequest addProductRequest = new AddBookRequest(newBook);
        AddBookResponse addProductResponse = addBookService.execute(addProductRequest);
        if (addProductResponse.hasErrors()){
            addProductResponse.getErrors().forEach(System.out::println);
        }else {
            System.out.println("Book was successfully added");
        }
    }
}
