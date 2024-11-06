package tech.project.ikon.transfer.model;

import java.util.ArrayList;

public class NasabahPotensialList {
    private String sumOfMaturityAll;
    private String sumOfMaturityM0;
    private String sumOfMaturityM1;
    private String sumOfMaturityM2;
    private String sumOfMaturityM3;
    private String sumOfTopUp;
    private String sumOfDropOut;
    private String sumOfMaturityAllNotVisited;
    private String sumOfTopUpNotVisited;
    private String sumOfDropOutNotVisited;
    private String sumOfSwScheduled;
    private String sumOfSwNotScheduled;
    private String sumOfAll;
    private ArrayList<NasabahPotensialItem> customerMaturityAll;
    private ArrayList<NasabahPotensialItem> customerMaturityM0;
    private ArrayList<NasabahPotensialItem> customerMaturityM1;
    private ArrayList<NasabahPotensialItem> customerMaturityM2;
    private ArrayList<NasabahPotensialItem> customerMaturityM3;
    private ArrayList<NasabahPotensialItem> customerTopUp;
    private ArrayList<NasabahPotensialItem> customerDropOut;
    private ArrayList<NasabahPotensialItem> customerProspek;

    public String getSumOfMaturityAll() {
        return sumOfMaturityAll;
    }

    public String getSumOfMaturityM0() {
        return sumOfMaturityM0;
    }

    public String getSumOfMaturityM1() {
        return sumOfMaturityM1;
    }

    public String getSumOfMaturityM2() {
        return sumOfMaturityM2;
    }

    public String getSumOfMaturityM3() {
        return sumOfMaturityM3;
    }

    public String getSumOfTopUp() {
        return sumOfTopUp;
    }

    public String getSumOfDropOut() {
        return sumOfDropOut;
    }

    public String getSumOfMaturityAllNotVisited() {
        return sumOfMaturityAllNotVisited;
    }

    public String getSumOfTopUpNotVisited() {
        return sumOfTopUpNotVisited;
    }

    public String getSumOfDropOutNotVisited() {
        return sumOfDropOutNotVisited;
    }

    public ArrayList<NasabahPotensialItem> getCustomerMaturityAll() {
        return customerMaturityAll;
    }

    public ArrayList<NasabahPotensialItem> getCustomerMaturityM0() {
        return customerMaturityM0;
    }

    public ArrayList<NasabahPotensialItem> getCustomerMaturityM1() {
        return customerMaturityM1;
    }

    public ArrayList<NasabahPotensialItem> getCustomerMaturityM2() {
        return customerMaturityM2;
    }

    public ArrayList<NasabahPotensialItem> getCustomerMaturityM3() {
        return customerMaturityM3;
    }

    public ArrayList<NasabahPotensialItem> getCustomerTopUp() {
        return customerTopUp;
    }

    public ArrayList<NasabahPotensialItem> getCustomerDropOut() {
        return customerDropOut;
    }

    public ArrayList<NasabahPotensialItem> getCustomerProspek() {
        return customerProspek;
    }

    public String getSumOfSwScheduled() {
        return sumOfSwScheduled;
    }

    public String getSumOfSwNotScheduled() {
        return sumOfSwNotScheduled;
    }

    public String getSumOfAll() {
        return sumOfAll;
    }
}
