package org.noamichael.bank.thru;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.event.ReorderEvent;

/**
 *
 * @author Michael
 */
@Named
@SessionScoped
public class SessionValues implements Serializable {

    private List<Entry> payments;

    public SessionValues() {
        payments = new ArrayList();
        payments.add(new Entry("Amazon - $39.64", UUID.randomUUID().toString()));
        payments.add(new Entry("Lukoil - $42.75", UUID.randomUUID().toString()));
        payments.add(new Entry("Walmart - $12,093,238.06 ", UUID.randomUUID().toString()));
        payments.add(new Entry("Team Alpha Services - $987.23", UUID.randomUUID().toString()));
    }

    private int index = 0;

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    public void onPaymentDrop(ReorderEvent event) {
        int goalIndex = event.getToIndex();
        int oldIndex = event.getFromIndex();
        String movement = String.format("Trying to move %s to %s", payments.get(oldIndex), goalIndex);
        System.out.println(movement);
        if (oldIndex < goalIndex) {
            Collections.rotate(payments.subList(oldIndex, goalIndex + 1), -1);
        } else if (goalIndex < oldIndex) {
            Collections.rotate(payments.subList(goalIndex, oldIndex + 1), 1);
        }
        System.out.println("Results at " + goalIndex +": " + payments.get(goalIndex));
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    public List<Entry> getPayments() {
        return payments;
    }
    public void setPayments(List<Entry> payments){
        this.payments = payments;
    }
}
