package auth.android.app.request;

public class ScanRequest {
    private String mobile;
    private String token;
    private String value;
    private int uid;
    private int event_id;
    private int deviceType=1;

    public ScanRequest(String mobile, String token, String value, int uid, int event_id) {
        this.mobile = mobile;
        this.token = token;
        this.value = value;
        this.uid = uid;
        this.event_id = event_id;
    }
}
