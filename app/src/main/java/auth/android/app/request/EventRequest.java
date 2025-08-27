package auth.android.app.request;

public class EventRequest {
    private String token;
    private String mobile;
    private int uid;
    private int deviceType = 1;

    public EventRequest(String token, String mobile, int uid) {
        this.mobile = mobile;
        this.token = token;
        this.uid = uid;
    }
}
