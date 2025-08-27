package auth.android.app.request;

/**
 * Created by sudhirharit on 30/03/18.
 */

public class QuestionsRating {

    private String qid;

    private String rate;

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public QuestionsRating(String qid, String rating) {

        this.qid = qid;
        this.rate = rating;
    }
}
