package org.noamichael.bank.thru;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
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
    private static final BarChartModel barChart = new BarChartModel();
    private static final PieChartModel pieChart = new PieChartModel();

    static {
        DefaultMenuItem dashboard = new DefaultMenuItem("Dashboard");
        dashboard.setUrl("dashboard.xhtml");

        DefaultMenuItem setupPayment = new DefaultMenuItem("Setup Payment");
        setupPayment.setUrl("setupPayment.xhtml");

        DefaultMenuItem currentBalance = new DefaultMenuItem("Current Balance");
        currentBalance.setUrl("currentBalance.xhtml");

        DefaultMenuItem priorityPayment = new DefaultMenuItem("Priority Payment");
        priorityPayment.setUrl("priorityPayment.xhtml");

        DefaultMenuItem reminders = new DefaultMenuItem("Reminders");
        reminders.setUrl("reminders.xhtml");

        DefaultMenuItem spendingPattern = new DefaultMenuItem("Spending Pattern");
        spendingPattern.setUrl("spendingPattern.xhtml");

        DefaultMenuItem transfers = new DefaultMenuItem("Transfers");
        transfers.setUrl("transfers.xhtml");

        DefaultMenuItem logout = new DefaultMenuItem("Logout");
        logout.setUrl("index.xhtml");

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
        links.add(spendingPattern);
        links.add(transfers);
        links.add(logout);
        accounts.add(new Entry("0000001928", "$12,003.19"));
        accounts.add(new Entry("0000001926", "$502.57"));
        accounts.add(new Entry("2837772639", "$13.98"));
        accounts.add(new Entry("1414257899", "$3,216.23"));
        accounts.add(new Entry("1726362000", "$180.00"));

        ChartSeries amount = new ChartSeries();
        amount.setLabel("Amount");
        amount.set("Aug", 150.65);
        amount.set("Sep", 345.12);
        amount.set("Oct", 246.23);
        barChart.addSeries(amount);
        barChart.setTitle("Monthly Spending");
        Axis xAxis = barChart.getAxis(AxisType.X);
        xAxis.setLabel("Month");
        Axis yAxis = barChart.getAxis(AxisType.Y);
        yAxis.setLabel("Amount (Dollars)");
        yAxis.setMin(0);
        yAxis.setMax(1000);

        pieChart.set("Entertainment", 540);
        pieChart.set("Gas", 325);
        pieChart.set("Food", 702);
        pieChart.set("Misc.", 421);

        pieChart.setTitle("Spending Areas");
        pieChart.setLegendPosition("e");
        pieChart.setShowDataLabels(true);
        pieChart.setDiameter(130);

    }
    
    public Date getToday(){
        return new Date();
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

    public BarChartModel getMonthlySpending() {
        return barChart;
    }

    public PieChartModel getSpendingAreas() {
        return pieChart;
    }
}
