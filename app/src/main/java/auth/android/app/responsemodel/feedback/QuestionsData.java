package auth.android.app.responsemodel.feedback;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import auth.android.app.responsemodel.others.OptionData;

/**
 * Created by sudhirharit on 29/03/18.
 */

public class QuestionsData {

    @SerializedName("event_id")
    private String eventId;

    @SerializedName("qqid")
    private String qqId;

    @SerializedName("qid")
    private String questionId;

    @SerializedName("question")
    private String question;

    @SerializedName("question_type")
    private String questionType;

    @SerializedName("placeholder")
    private String placeholder;

    @SerializedName("options")
    private List<OptionData> optionData;

    @SerializedName("question_view")
    private int questionView;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public List<OptionData> getOptionData() {
        return optionData;
    }

    public void setOptionData(List<OptionData> optionData) {
        this.optionData = optionData;
    }

    public int getQuestionView() {
        return questionView;
    }

    public void setQuestionView(int questionView) {
        this.questionView = questionView;
    }
}
