package auth.android.app.request.survey;

import java.util.List;

import auth.android.app.responsemodel.home.PageDataList;

public class SurveyQuestions {
    private int uid;
    private String token;
    private String mobile;
    private int event_id;
    private String event_tab_id;
    private List<PageDataList> data;

    public SurveyQuestions(int uid, String token, String mobile, int event_id, String event_tab_id, List<PageDataList> data) {
        this.uid = uid;
        this.token = token;
        this.mobile = mobile;
        this.data = data;
        this.event_id = event_id;
        this.event_tab_id = event_tab_id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<PageDataList> getOptions() {
        return data;
    }

    public void setOptions(List<PageDataList> data) {
        this.data = data;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_tab_id() {
        return event_tab_id;
    }

    public void setEvent_tab_id(String event_tab_id) {
        this.event_tab_id = event_tab_id;
    }
}
