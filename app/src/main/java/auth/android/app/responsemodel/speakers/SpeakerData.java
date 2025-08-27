package auth.android.app.responsemodel.speakers;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SpeakerData implements Serializable {
    @SerializedName("speaker_id")
    private int speakerId;

    @SerializedName("speaker_name")
    private String speakerName;

    @SerializedName("company_name")
    private String companyName;

    @SerializedName("designation")
    private String designation;

    @SerializedName("speaker_img")
    private String speakerImg;

    @SerializedName("about_speaker")
    private String aboutSpeaker;

    @SerializedName("is_click")
    private int isClick;

    @SerializedName("is_round")
    private int isRound;

    @SerializedName("button_label")
    private String button_label;

    @SerializedName("button_url")
    private String button_url;

    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSpeakerImg() {
        return speakerImg;
    }

    public void setSpeakerImg(String speakerImg) {
        this.speakerImg = speakerImg;
    }

    public String getAboutSpeaker() {
        return aboutSpeaker;
    }

    public void setAboutSpeaker(String aboutSpeaker) {
        this.aboutSpeaker = aboutSpeaker;
    }

    public int getIsClick() {
        return isClick;
    }

    public void setIsClick(int isClick) {
        this.isClick = isClick;
    }

    public int getIsRound() {
        return isRound;
    }

    public void setIsRound(int isRound) {
        this.isRound = isRound;
    }

    public String getButton_label() {
        return button_label;
    }

    public void setButton_label(String button_label) {
        this.button_label = button_label;
    }

    public String getButton_url() {
        return button_url;
    }

    public void setButton_url(String button_url) {
        this.button_url = button_url;
    }
}
