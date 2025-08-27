package auth.android.app.request;

/**
 * Created by sudhirharit on 29/03/18.
 */

public class NotePadRequest {


    private String token;
    private String page_type;
    private int deviceType=1;
    private String mobile;
    private int event_id;
    private String content_type;
    private String event_tab_id;
    private int uid;
    private String notepad_text;



    public NotePadRequest(String token, int uid, String notepad_text, int event_id, String page_type, String mobile, String content_type, String event_tab_id) {
        this.token = token;
        this.uid = uid;
        this.notepad_text = notepad_text;
        this.event_id = event_id;
        this.content_type = content_type;
        this.event_tab_id = event_tab_id;
        this.page_type = page_type;
        this.mobile = mobile;;
    }
}
