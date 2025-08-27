package auth.android.app.responsemodel.others;

import com.google.gson.annotations.SerializedName;

public class OptionData {
    @SerializedName("option_id")
    private String optionId;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    @SerializedName("value")
    private String value;

    @SerializedName("rating")
    private float rating = 0f;

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
