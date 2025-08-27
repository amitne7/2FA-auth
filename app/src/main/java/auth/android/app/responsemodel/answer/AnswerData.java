package auth.android.app.responsemodel.answer;

import com.google.gson.annotations.SerializedName;

public class AnswerData {
    @SerializedName("uid")
    private int uid;

    @SerializedName("is_answer")
    private int isAnswer;

    @SerializedName("user_question")
    private String question;

    @SerializedName("reply")
    private String reply;

    @SerializedName("ques_datetime")
    private String dateTime;

    @SerializedName("date_added")
    private String time;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getIsAnswer() {
        return isAnswer;
    }

    public void setIsAnswer(int isAnswer) {
        this.isAnswer = isAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
