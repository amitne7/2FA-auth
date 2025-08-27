package auth.android.app.request;

public class TokenRequest {
    private String token;
    private int event_id;
    private int deviceType=1;

    public TokenRequest(String token, int event_id) {
        this.token = token;
        this.event_id = event_id;
    }
}
