package org.noamichael.bank.thru;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private static final List<Entry> accounts = new ArrayList();

    static {
        DefaultMenuItem dashboard = new DefaultMenuItem("Dashboard");
        dashboard.setCommand("#{sessionValues.setIndex(0)}");
        
        DefaultMenuItem setupPayment = new DefaultMenuItem("Setup Payment");
        setupPayment.setCommand("#{sessionValues.setIndex(1)}")
                ;
        DefaultMenuItem currentBalance = new DefaultMenuItem("Current Balance");
        currentBalance.setCommand("#{sessionValues.setIndex(2)}");
        
        DefaultMenuItem priorityPayment = new DefaultMenuItem("Priority Payment");
        priorityPayment.setCommand("#{sessionValues.setIndex(3)}");
        
        DefaultMenuItem reminders = new DefaultMenuItem("Reminders");
        reminders.setCommand("#{sessionValues.setIndex(4)}");
        
        DefaultMenuItem spendingPattern = new DefaultMenuItem("Spending Pattern");
        spendingPattern.setCommand("#{sessionValues.setIndex(5)}");
        
        DefaultMenuItem transfers = new DefaultMenuItem("Transfers");
        transfers.setCommand("#{sessionValues.setIndex(6)}");
        
        DefaultMenuItem logout = new DefaultMenuItem("Logout");
        logout.setCommand("logout");
        
        defaultMenuModel.addElement(dashboard);
        defaultMenuModel.addElement(setupPayment);
        defaultMenuModel.addElement(currentBalance);
        defaultMenuModel.addElement(priorityPayment);
        defaultMenuModel.addElement(reminders);
        defaultMenuModel.addElement(spendingPattern);
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
        accounts.add(new Entry("0000001928", "$12,003.19"));
        accounts.add(new Entry("0000001926", "$502.57"));
        accounts.add(new Entry("2837772639", "$13.98"));
        accounts.add(new Entry("1414257899", "$3,216.23"));
        accounts.add(new Entry("1726362000", "$180.00"));
    }

    public List<Entry> getAccounts() {
        return accounts;
    }

    /**
     * @return the links
     */
    public DefaultMenuModel getMenu() {
        return defaultMenuModel;
    }

    public List<DefaultMenuItem> getLinks() {
        return links;
    }
}
