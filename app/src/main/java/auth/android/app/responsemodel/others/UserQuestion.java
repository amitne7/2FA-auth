package auth.android.app.responsemodel.others;

import com.google.gson.annotations.SerializedName;

public class UserQuestion {
    @SerializedName("user_question")
    private String question;

    @SerializedName("asked")
    private String askedBy;

    @SerializedName("company_name")
    private String companyName;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAskedBy() {
        return askedBy;
    }

    public void setAskedBy(String askedBy) {
        this.askedBy = askedBy;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
