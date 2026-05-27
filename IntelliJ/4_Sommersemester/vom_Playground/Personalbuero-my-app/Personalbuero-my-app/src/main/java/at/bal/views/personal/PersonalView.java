package at.bal.views.personal;

import at.bal.model.*;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.ItemDoubleClickEvent;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Personal")
@Route("my-view")
@Menu(order = 0, icon = LineAwesomeIconUrl.TABLE_SOLID)
public class PersonalView extends Composite<VerticalLayout> {

    Grid<Mitarbeiter> personalTable;
    VerticalLayout myLayout;
    Personalbuero personalbuero;

    public PersonalView() {

        initComponents();
        initPersonalTable();
        addComponents();
        initListeners();

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");

        getContent().add(myLayout);
    }

    private void initComponents() {
        personalTable = new Grid<>(Mitarbeiter.class, false);
        myLayout = new VerticalLayout();
        personalbuero = new Personalbuero();
    }

    private void initPersonalTable() {

        personalTable.addColumn(new ValueProvider<Mitarbeiter, Object>() {
            @Override
            public Object apply(Mitarbeiter mitarbeiter) {
                return mitarbeiter.getClass().getSimpleName();
            }
        }).setHeader("Mitarbeiter").setSortable(true).setAutoWidth(true); // "fluent" API

        personalTable.addColumn( mitarbeiter -> mitarbeiter.getName()).setHeader("Name");
        personalTable.addColumn( mitarbeiter -> mitarbeiter.getGebJahr()).setHeader("Geburtsjahr");
        personalTable.addColumn( mitarbeiter -> mitarbeiter.getEintrJahr()).setHeader("Eintrittsjahr");

        // Freelancer/Arzt
        personalTable.addColumn( mitarbeiter -> {
            return switch (mitarbeiter) {
                case Freelancer freelancer -> freelancer.getStundenSatz();
                case Arzt arzt -> arzt.getFixum();
                case null, default -> null;
            };
        }).setHeader("Stunden");

        // Freelancer

        personalTable.addColumn( mitarbeiter -> {
            return switch (mitarbeiter) {
                case Freelancer freelancer -> freelancer.getStundenSatz();
                case null, default -> null;
            };
        }).setHeader("H-Satz");

        // Arzt

        personalTable.addColumn( mitarbeiter -> {
            return switch (mitarbeiter) {
                case Arzt arzt -> arzt.getFixum();
                case null, default -> null;
            };
        }).setHeader("Fixum");

        // Component-Column

        try {
            personalbuero.readPersonalFromCSV();
        } catch (PersonalException e) {
            Notification.show(e.getMessage());
        }
        personalTable.setItems(personalbuero.getMitarbeiterListeCopy());
    }

    private void addComponents() {
        myLayout.add(personalTable);
    }

    public void initListeners() {
        personalTable.addItemDoubleClickListener(new ComponentEventListener<ItemDoubleClickEvent<Mitarbeiter>>() {
            @Override
            public void onComponentEvent(ItemDoubleClickEvent<Mitarbeiter> mitarbeiterItemDoubleClickEvent) {
                Notification.show(mitarbeiterItemDoubleClickEvent.getItem().toCSVString());
            }
        });
    }

}
