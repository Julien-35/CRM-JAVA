package com.example.application.views; 

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/main") // Route par défaut
public class MainView extends VerticalLayout {

    public MainView() {
        Button button = new Button("Cliquez ici", e -> {
            // Action à effectuer lors du clic sur le bouton
        });
        add(button); // Ajoutez le bouton à la vue
    }
}
