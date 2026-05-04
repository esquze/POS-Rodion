package at.bal.views.personal;

import at.bal.model.Mitarbeiter;
import at.bal.model.PersonalException;
import at.bal.model.Personalbuero;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");

        getContent().add(myLayout);
    }

    private void initComponents() {
        personalTable = new Grid<>(Mitarbeiter.class, true);
        myLayout = new VerticalLayout();
        personalbuero = new Personalbuero();
    }

    private void initPersonalTable() {
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

}
