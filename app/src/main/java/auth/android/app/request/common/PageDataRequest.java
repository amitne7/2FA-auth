package auth.android.app.request.common;

public class PageDataRequest {
    private int deviceType=1;
    private String token;
    private String page_type;
    private String content_type;
    private int uid;
    private String mobile;
    private int event_id;
    private String event_tab_id;
    private Double lat;
    private Double lng;
    private int page;
    private String type;
    private String  button_id;
    private int album_id;

    public PageDataRequest(String token, String page_type, String content_type, int uid, String mobile, int event_id, String event_tab_id) {
        this.token = token;
        this.page_type = page_type;
        this.content_type = content_type;
        this.uid = uid;
        this.mobile = mobile;
        this.event_id = event_id;
        this.event_tab_id = event_tab_id;
    }

    public PageDataRequest(String token, String page_type, String content_type, int uid, String mobile, int event_id, String event_tab_id, String button_id) {
        this.token = token;
        this.page_type = page_type;
        this.content_type = content_type;
        this.uid = uid;
        this.mobile = mobile;
        this.event_id = event_id;
        this.event_tab_id = event_tab_id;
        this.button_id = button_id;
    }

    public PageDataRequest(String token, String page_type, String content_type, int uid, String mobile, int event_id, String event_tab_id, Double lat, Double lng) {
        this.token = token;
        this.page_type = page_type;
        this.content_type = content_type;
        this.uid = uid;
        this.mobile = mobile;
        this.event_id = event_id;
        this.event_tab_id = event_tab_id;
        this.lat = lat;
        this.lng = lng;
    }

    public PageDataRequest(String token, String page_type, String content_type, int uid, String mobile, int event_id, String event_tab_id, int page, String type, int album_id) {
        this.token = token;
        this.page_type = page_type;
        this.content_type = content_type;
        this.uid = uid;
        this.mobile = mobile;
        this.event_id = event_id;
        this.event_tab_id = event_tab_id;
        this.page = page;
        this.type = type;
        this.album_id = album_id;
    }
}
