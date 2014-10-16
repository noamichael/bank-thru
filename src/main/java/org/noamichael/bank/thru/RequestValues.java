package org.noamichael.bank.thru;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;

/**
 *
 * @author Michael
 */
@Named
@RequestScoped
public class RequestValues {

    private static final List<DefaultMenuItem> links = new ArrayList();
    private static final DefaultMenuModel defaultMenuModel = new DefaultMenuModel();

    static {
        DefaultMenuItem dashboard = new DefaultMenuItem("Dashboard");
        dashboard.setUrl("dashboard");
        DefaultMenuItem currentBalance = new DefaultMenuItem("Current Balance");
        currentBalance.setUrl("currentBalance");
        DefaultMenuItem setupPayment = new DefaultMenuItem("Setup Payment");
        setupPayment.setUrl("setupPayment");
        DefaultMenuItem reminders = new DefaultMenuItem("Reminders");
        reminders.setUrl("reminders");
        DefaultMenuItem priorityPayment = new DefaultMenuItem("Priority Payment");
        priorityPayment.setUrl("priorityPayment");
        DefaultMenuItem spendingPattern = new DefaultMenuItem("Spending Pattern");
        spendingPattern.setUrl("spendingPattern");
        DefaultMenuItem transfers = new DefaultMenuItem("Transfers");
        transfers.setUrl("transfers");
        DefaultMenuItem logout = new DefaultMenuItem("Logout");
        logout.setUrl("logout");
        defaultMenuModel.addElement(dashboard);
        defaultMenuModel.addElement(setupPayment);
        defaultMenuModel.addElement(currentBalance);
        defaultMenuModel.addElement(priorityPayment);
        defaultMenuModel.addElement(reminders);
        defaultMenuModel.addElement(setupPayment);
        defaultMenuModel.addElement(transfers);
        defaultMenuModel.addElement(logout);
        links.add(dashboard);
        links.add(setupPayment);
        links.add(currentBalance);
        links.add(priorityPayment);
        links.add(reminders);
        links.add(setupPayment);
        links.add(transfers);
        links.add(logout);
    }

    /**
     * @return the links
     */
    public DefaultMenuModel getMenu() {
        return defaultMenuModel;
    }
    public List<DefaultMenuItem> getLinks(){
        return links;
    }
}
