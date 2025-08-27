package auth.android.app.responsemodel.feedback;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sudhirharit on 29/03/18.
 */

public class QuestionsResponse {


    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<QuestionsData> questionsDataList;

    @SerializedName("code")
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<QuestionsData> getQuestionsDataList() {
        return questionsDataList;
    }

    public void setQuestionsDataList(List<QuestionsData> questionsDataList) {
        this.questionsDataList = questionsDataList;
    }
}
