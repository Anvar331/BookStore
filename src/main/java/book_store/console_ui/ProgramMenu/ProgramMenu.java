package book_store.console_ui.ProgramMenu;

import book_store.console_ui.UIAction;
import book_store.console_ui.book.AddBookUIAction;
import book_store.core.services.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramMenu {

    private Map<Integer, UIAction> menuNumberToActionMap = new HashMap<>();

    @Autowired
    public ProgramMenu(List<UIAction> uiActionList) {
        menuNumberToActionMap.put(1, findUIAction(uiActionList, AddBookUIAction.class));
    }

    public void executeUIAction(int selectedMenuNumber) {
        menuNumberToActionMap.get(selectedMenuNumber).execute();
    }

    private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }

    public void printMenu() {

        System.out.println("\nAdministrator Menu\n\n" +
                "1   Add book\n" +
                "2   Get order list\n" +
                "*****************************");

    }
}
