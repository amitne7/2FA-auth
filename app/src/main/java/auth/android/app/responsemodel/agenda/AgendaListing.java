package auth.android.app.responsemodel.agenda;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AgendaListing {
    @SerializedName("title")
    private List<String> titleList;

    @SerializedName("date")
    private List<String> dateList;

    @SerializedName("agenda")
    private List<ArrayList<AgendaData>> agendaArray;

    public List<String> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<String> titleList) {
        this.titleList = titleList;
    }

    public List<String> getDateList() {
        return dateList;
    }

    public void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }

    public List<ArrayList<AgendaData>> getAgendaArray() {
        return agendaArray;
    }

    public void setAgendaArray(List<ArrayList<AgendaData>> agendaArray) {
        this.agendaArray = agendaArray;
    }
}
