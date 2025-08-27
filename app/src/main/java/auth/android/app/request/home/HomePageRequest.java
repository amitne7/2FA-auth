package auth.android.app.request.home;

public class HomePageRequest {
    private String token;
    private int deviceType=1;
    private int event_id;
    private String mobile;
    private int uid;

    public HomePageRequest(String token, int event_id, String mobile, int uid) {
        this.token = token;
        this.event_id = event_id;
        this.mobile = mobile;
        this.uid = uid;
    }
}
