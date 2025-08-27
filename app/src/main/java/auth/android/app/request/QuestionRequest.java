package auth.android.app.request;

/**
 * Created by sudhirharit on 29/03/18.
 */

public class QuestionRequest {


    private String token;
    private String page_type;
    private int deviceType=1;
    private String mobile;
    private int event_id;
    private String content_type;
    private String event_tab_id;
    private int uid;
    private String question;
    private int type;
    private String question_type;


    public QuestionRequest(String token, int uid, String question, int type, int event_id, String page_type, String mobile, String content_type, String event_tab_id, String question_type) {
        this.token = token;
        this.uid = uid;
        this.question = question;
        this.type = type;
        this.event_id = event_id;
        this.content_type = content_type;
        this.event_tab_id = event_tab_id;
        this.page_type = page_type;
        this.mobile = mobile;
        this.question_type = question_type;
    }
}
