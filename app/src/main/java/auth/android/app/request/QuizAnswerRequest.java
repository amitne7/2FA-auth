package auth.android.app.request;

public class QuizAnswerRequest {
    private String token;
    private int uid;
    private String mobile;
    private String answer;
    private int event_id;
    private String qqid;
    private int deviceType=1;
    private String question_type;
    private String event_tab_id;

    public QuizAnswerRequest(String token, int uid, String answer, String qqid, int event_id, String question_type, String mobile, String event_tab_id) {
        this.answer= answer;
        this.event_id = event_id;
        this.qqid = qqid;
        this.token = token;
        this.uid = uid;
        this.question_type = question_type;
        this.event_tab_id = event_tab_id;
        this.mobile = mobile;
    }
}
