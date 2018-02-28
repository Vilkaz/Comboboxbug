package de.vilkas.Comboboxbug;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.Arrays;

/**
 * Created by Vilkas on 28/02/2018.
 */
@SpringUI
public class Test extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {

        ComboBox<Integer> numbers = new ComboBox<>();
        numbers.setItems(Arrays.asList(0, 1, 2, 3));

        Button reset = new Button("reset");
        reset.addClickListener(e -> {
            numbers.setValue(0);});

        HorizontalLayout buttons = new HorizontalLayout(numbers, reset);
        Label instruction = new Label("1: Enter not null Value (1-3)" +
                "\n2: Click the reset button (ComboboxValue goes to 0)" +
                "\n3: Click IN the combobox, and enter the previous (!!!) value by HAND ! (not selecting with mouse from the dropDown Menu)" +
                "\n4: Click TAB to switch from the Combobox to the 'show Values' button. The value from Combobox will be resetet to 0. If you enter OTHER Value then the previous, then everything is working fine.",
                ContentMode.PREFORMATTED);

        VerticalLayout mainLayout = new VerticalLayout(buttons, instruction);
        setContent(mainLayout);
    }
}
