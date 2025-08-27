package auth.android.app.responsemodel.home;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import auth.android.app.responsemodel.others.OptionData;

public class PageDataList implements Serializable {
    @SerializedName("event_tab_id")
    private String eventTabId;

    @SerializedName("label")
    private String label;

    @SerializedName("color")
    private String color;

    @SerializedName("header_color")
    private String headerColor;

    @SerializedName("header_bg_color")
    private String headerBgColor;

    @SerializedName("sub_heading")
    private String subHeading;

    @SerializedName("page_type")
    private String pageType;

    @SerializedName("image")
    private String image;

    @SerializedName("order")
    private String order;

    @SerializedName("content_type")
    private String contentType;

    @SerializedName("bg_image")
    private String bgImage;

    @SerializedName("type")
    private int type;

    @SerializedName("width")
    private String width;

    @SerializedName("height")
    private String height;

    @SerializedName("title")
    private List<String> agendaTitleData;

    @SerializedName("date")
    private List<String> agendaDates;

    @SerializedName("notification")
    private String notification;

    @SerializedName("date_added")
    private String date;

    @SerializedName("notification_id")
    private String notificationId;

    @SerializedName("noty_type")
    private int notificationType;

    @SerializedName("notification_title")
    private String notificationTitle;

    @SerializedName("border_color")
    private String borderColor;

    @SerializedName("address")
    private String address;


    @SerializedName("lat")
    private String latitude;

    @SerializedName("lng")
    private String longitude;

    @SerializedName("button_color")
    private String btnColor;

    @SerializedName("button_id")
    private String btnId;

    @SerializedName("address_label")
    private String addressLabel;

    @SerializedName("button_bg_color")
    private String btnBgColor;

    @SerializedName("header_visible")
    private int headerVisible;

    @SerializedName("top")
    private String top;

    @SerializedName("prompt")
    private int prompt;

    @SerializedName("prompt_msg")
    private String promptMessage;

    @SerializedName("notification_video")
    private String notificationVideo;

    @SerializedName("notification_img")
    private String notificationImage;

    @SerializedName("question")
    private String question;

    @SerializedName("udid")
    private String udid;

    @SerializedName("placeholder")
    private String placeholder;

    @SerializedName("user_question")
    private String askedQuestion;

    @SerializedName("member_name")
    private String askedBy;

    @SerializedName("id")
    private int employeeId;

    @SerializedName("company_name")
    private String companyName;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("email")
    private String email;

    @SerializedName("designation")
    private String designation;

    @SerializedName("name")
    private String name;

    @SerializedName("webview_html")
    private String webviewHtml;

    @SerializedName("webview_url")
    private String webviewUrl;

    @SerializedName("album_id")
    private int albumId;

    @SerializedName("album_name")
    private String albumName;

    @SerializedName("album_img")
    private String albumImg;

    @SerializedName("grid_count")
    private int gridCount;

    @SerializedName("slider_view")
    private int sliderView;

    @SerializedName("ques_id")
    private int quesId;

    @SerializedName("ques_name")
    private String quesName;

    @SerializedName("options")
    private List<OptionData> optionData;

    @SerializedName("sub_heading_color")
    private String subHeadingColor;

    @SerializedName("sub_heading_fontsize")
    private int subHeadingFontSize;

    @SerializedName("label_visible")
    private String labelVisible;

    @SerializedName("selected_btn_text_color")
    private String selectedBtnTextColor;

    @SerializedName("extra_btn_text_color")
    private String extraBtnTextColor;

    @SerializedName("user_image")
    private String userImage;

    @SerializedName("followed")
    private int followed;

    @SerializedName("gst_no")
    private String gstNo;

    @SerializedName("website")
    private String website;

    @SerializedName("description")
    private String description;

    @SerializedName("facebook_url")
    private String facebookUrl;

    @SerializedName("instagram_url")
    private String instagramUrl;

    @SerializedName("twitter_url")
    private String twitterUrl;

    @SerializedName("linkedin_url")
    private String linkedinUrl;

    @SerializedName("stall_no")
    private String stallNo;

    @SerializedName("company_logo")
    private String companyLogo;

    @SerializedName("brochure")
    private String brochure;

    @SerializedName("event_id")
    private String eventId;

    @SerializedName("qqid")
    private String qqId;

    @SerializedName("qid")
    private String questionId;

    @SerializedName("question_type")
    private String questionType;

    @SerializedName("question_view")
    private int questionView;


    @SerializedName("icon_image")
    private String iconImage;

    @SerializedName("icon_visible")
    private int iconVisible;

    @SerializedName("speaker_id")
    private int speakerId;

    @SerializedName("speaker_name")
    private String speakerName;


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



    public String getEventTabId() {
        return eventTabId;
    }

    public void setEventTabId(String eventTabId) {
        this.eventTabId = eventTabId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHeaderColor() {
        return headerColor;
    }

    public void setHeaderColor(String headerColor) {
        this.headerColor = headerColor;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getBgImage() {
        return bgImage;
    }

    public void setBgImage(String bgImage) {
        this.bgImage = bgImage;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public List<String> getAgendaTitleData() {
        return agendaTitleData;
    }

    public void setAgendaTitleData(List<String> agendaTitleData) {
        this.agendaTitleData = agendaTitleData;
    }

    public List<String> getAgendaDates() {
        return agendaDates;
    }

    public void setAgendaDates(List<String> agendaDates) {
        this.agendaDates = agendaDates;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public int getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getBtnColor() {
        return btnColor;
    }

    public void setBtnColor(String btnColor) {
        this.btnColor = btnColor;
    }

    public String getBtnId() {
        return btnId;
    }

    public void setBtnId(String btnId) {
        this.btnId = btnId;
    }

    public String getAddressLabel() {
        return addressLabel;
    }

    public void setAddressLabel(String addressLabel) {
        this.addressLabel = addressLabel;
    }

    public String getBtnBgColor() {
        return btnBgColor;
    }

    public void setBtnBgColor(String btnBgColor) {
        this.btnBgColor = btnBgColor;
    }

    public int getHeaderVisible() {
        return headerVisible;
    }

    public void setHeaderVisible(int headerVisible) {
        this.headerVisible = headerVisible;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public int getPrompt() {
        return prompt;
    }

    public void setPrompt(int prompt) {
        this.prompt = prompt;
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }

    public String getNotificationVideo() {
        return notificationVideo;
    }

    public void setNotificationVideo(String notificationVideo) {
        this.notificationVideo = notificationVideo;
    }

    public String getNotificationImage() {
        return notificationImage;
    }

    public void setNotificationImage(String notificationImage) {
        this.notificationImage = notificationImage;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getAskedQuestion() {
        return askedQuestion;
    }

    public void setAskedQuestion(String askedQuestion) {
        this.askedQuestion = askedQuestion;
    }

    public String getAskedBy() {
        return askedBy;
    }

    public void setAskedBy(String askedBy) {
        this.askedBy = askedBy;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebviewHtml() {
        return webviewHtml;
    }

    public void setWebviewHtml(String webviewHtml) {
        this.webviewHtml = webviewHtml;
    }

    public String getWebviewUrl() {
        return webviewUrl;
    }

    public void setWebviewUrl(String webviewUrl) {
        this.webviewUrl = webviewUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumImg() {
        return albumImg;
    }

    public void setAlbumImg(String albumImg) {
        this.albumImg = albumImg;
    }

    public int getGridCount() {
        return gridCount;
    }

    public void setGridCount(int gridCount) {
        this.gridCount = gridCount;
    }

    public String getHeaderBgColor() {
        return headerBgColor;
    }

    public void setHeaderBgColor(String headerBgColor) {
        this.headerBgColor = headerBgColor;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }

    public int getSliderView() {
        return sliderView;
    }

    public void setSliderView(int sliderView) {
        this.sliderView = sliderView;
    }

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public String getQuesName() {
        return quesName;
    }

    public void setQuesName(String quesName) {
        this.quesName = quesName;
    }

    public List<OptionData> getOptionData() {
        return optionData;
    }

    public void setOptionData(List<OptionData> optionData) {
        this.optionData = optionData;
    }

    public String getSubHeadingColor() {
        return subHeadingColor;
    }

    public void setSubHeadingColor(String subHeadingColor) {
        this.subHeadingColor = subHeadingColor;
    }

    public int getSubHeadingFontSize() {
        return subHeadingFontSize;
    }

    public void setSubHeadingFontSize(int subHeadingFontSize) {
        this.subHeadingFontSize = subHeadingFontSize;
    }

    public String getLabelVisible() {
        return labelVisible;
    }

    public void setLabelVisible(String labelVisible) {
        this.labelVisible = labelVisible;
    }

    public String getSelectedBtnTextColor() {
        return selectedBtnTextColor;
    }

    public void setSelectedBtnTextColor(String selectedBtnTextColor) {
        this.selectedBtnTextColor = selectedBtnTextColor;
    }

    public String getExtraBtnTextColor() {
        return extraBtnTextColor;
    }

    public void setExtraBtnTextColor(String extraBtnTextColor) {
        this.extraBtnTextColor = extraBtnTextColor;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public int getFollowed() {
        return followed;
    }

    public void setFollowed(int followed) {
        this.followed = followed;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getStallNo() {
        return stallNo;
    }

    public void setStallNo(String stallNo) {
        this.stallNo = stallNo;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getBrochure() {
        return brochure;
    }

    public void setBrochure(String brochure) {
        this.brochure = brochure;
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

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public int getQuestionView() {
        return questionView;
    }

    public void setQuestionView(int questionView) {
        this.questionView = questionView;
    }

    public String getIconImage() {
        return iconImage;
    }

    public void setIconImage(String iconImage) {
        this.iconImage = iconImage;
    }

    public int getIconVisible() {
        return iconVisible;
    }

    public void setIconVisible(int iconVisible) {
        this.iconVisible = iconVisible;
    }

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
