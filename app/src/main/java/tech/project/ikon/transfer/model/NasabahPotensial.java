package tech.project.ikon.transfer.model;

import java.util.ArrayList;

public class NasabahPotensial {
    private String code;
    private String message;
    private NasabahPotensialList nasabahPotensialList;
    private ArrayList<NasabahPotensialItem> result;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public NasabahPotensialList getNasabahPotensialList() {
        return nasabahPotensialList;
    }

    public ArrayList<NasabahPotensialItem> getResult() {
        return result;
    }
}
