package com.thetemz.desiaustralia.model.eventscalender;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.thetemz.desiaustralia.model.newsletter.DataItems;

import java.util.ArrayList;

public class CalenderData {

    @SerializedName("calendar")
    @Expose
    private ArrayList<DataItems> arrayList;

    public ArrayList<DataItems> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<DataItems> arrayList) {
        this.arrayList = arrayList;
    }
}
