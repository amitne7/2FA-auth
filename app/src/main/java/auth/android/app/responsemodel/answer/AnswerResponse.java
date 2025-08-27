package auth.android.app.responsemodel.answer;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AnswerResponse {
    @SerializedName("code")
    private String code;

    @SerializedName("status")
    private boolean status;

    @SerializedName("data")
    private List<AnswerData> answerData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<AnswerData> getAnswerData() {
        return answerData;
    }

    public void setAnswerData(List<AnswerData> answerData) {
        this.answerData = answerData;
    }
}
