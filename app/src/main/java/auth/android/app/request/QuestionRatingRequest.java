package auth.android.app.request;

import java.util.List;

/**
 * Created by sudhirharit on 30/03/18.
 */

public class QuestionRatingRequest {

    private String token;

    private int uid;

    private String feedback;

    private int event_id;
    private String event_tab_id;

    private List<QuestionsRating> question;
    private String mobile;


    public QuestionRatingRequest(String token, int uid, List<QuestionsRating> questions, String feedback, String mobile, int event_id, String event_tab_id) {
        this.token = token;
        this.uid = uid;
        this.question = questions;
        this.feedback = feedback;
        this.mobile = mobile;
        this.event_id = event_id;
        this.event_tab_id = event_tab_id;
    }
}
