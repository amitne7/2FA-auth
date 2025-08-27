package auth.android.app.responsemodel.chat;

public class Chat {
    public String question;
    public String reply;
    public int isAnswer;

    public Chat(String question, String reply, int isAnswer) {
        this.question = question;
        this.reply = reply;
        this.isAnswer = isAnswer;
    }

    public Chat() {
    }
}
