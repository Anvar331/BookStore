package book_store.console_ui.book;

import book_store.core.services.Autowired;

public class GetAllBooksUIAction {

    @Autowired
    private GetAllBooksService getAllBooksService;

    @Override
    public void execute(){

        GetAllBooksRequest getProductsRequest = new GetAllBooksRequest();
        GeAllBooksResponse getProductsResponse = getAllBooksService.execute(getAllBooksRequest);

        if (getAllBooksResponse.hasErrors()){
            getProductsResponse.getErrors().forEach(System.out::println);
        }else
            getProductsResponse.getBooks().forEach(System.out::println);
    }
}
