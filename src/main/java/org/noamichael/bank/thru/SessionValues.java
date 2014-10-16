package org.noamichael.bank.thru;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Michael
 */
@Named
@SessionScoped
public class SessionValues implements Serializable {

    private int index = 0;

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     * @return
     */
    public void setIndex(int index) {
        this.index = index;
        getPageForIndex(index);
    }

    public void getPageForIndex(int index) {
        FacesContext context = FacesContext.getCurrentInstance();
        NavigationHandler nh = context.getApplication().getNavigationHandler();
        switch (index) {
            case 0:
                nh.handleNavigation(context, null, "dashboard.xhtml?faces-redirect=true");
                break;
            case 1:
                nh.handleNavigation(context, null, "setupPayment.xhtml?faces-redirect=true");
                break;
            case 2:
                nh.handleNavigation(context, null, "currentBalance.xhtml?faces-redirect=true");
                break;
            case 3:
                nh.handleNavigation(context, null, "priorityPayment.xhtml?faces-redirect=true");
                break;
            case 4:
                nh.handleNavigation(context, null, "reminders.xhtml?faces-redirect=true");
                break;
            case 5:
                nh.handleNavigation(context, null, "spendingPattern.xhtml?faces-redirect=true");
                break;
            case 6:
                nh.handleNavigation(context, null, "transfers.xhtml?faces-redirect=true");
                break;
            default:
                nh.handleNavigation(context, null, "index.xhtml?faces-redirect=true");
                break;
        }
    }
}
