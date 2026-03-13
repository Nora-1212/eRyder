public class Feedback {
    private String firstName;
    private String lastName;
    private String email;

    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public void analyzeFeedback(boolean isConcatenation, String sent1, String sent2, String sent3, String sent4, String sent5){
        if (isConcatenation =  true){
            completeFeedback = feedbackStringConcatenation(sent1, sent2, sent3, sent4, sent5);
            checkFeedbackLength(completeFeedback);
            createReviewID(firstName, lastName,completeFeedback);
        }else {
            completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
            createReviewID(firstName, lastName,completeFeedback);
            checkFeedbackLength(completeFeedback);
        }
    }
    private void feedbackUsingContenation(String sent1, String sent2, String sent3, String sent4, String sent5){
        String concatenatedFeedback = sent1 + " " + sent2 + " " + sent3 + " " + sent4 + " " + sent5;

    }
    private StringBuilder feedbackUsingStringBuilder(String sent1, String sent2, String sent3, String sent4, String sent5) {
        StringBuilder sb = new StringBuilder();
        sb.append(sent1).append(" ").append(sent2).append(" ").append(sent3).append(" ").append(sent4).append(" ").append(sent5);
        return sb;
    }
    private String feedbackUsingConcatenation(String sent1, String sent2, String sent3, String sent4, String sent5) {
        String concatenatedFeedback="";
        concatenatedFeedback = sent1+" "+sent2+" "+sent3+" "+sent4+" "+sent5;
        return concatenatedFeedback;
    }


    private void createReviewID(String firstName, String lastName, String completeFeedback) {
        reviewID=(firstName+lastName).substring(2,6).toUpperCase();
        reviewID+=completeFeedback.substring(10,15).toLowerCase();
        reviewID+=(completeFeedback.length());
        reviewID+="_";
        reviewID+=System.currentTimeMillis();
        reviewID=reviewID.replace(" ", "");
    }

    private boolean checkFeedbackLength(String completeFeedback) {
        System.out.println("Feedback length:" + completeFeedback.length());
        boolean longFeedback;
        if (completeFeedback.length() > 500) {
            longFeedback = true;
            return longFeedback;
        } else {
            longFeedback = false;
            return longFeedback;
        }
    }

    private String feedbackStringConcatenation(String sent1, String sent2, String sent3, String sent4, String sent5) {
        return sent1 + " " + sent2 + " " + sent3 + " " + sent4 + " " + sent5;
    }

    @Override
    public String toString(){
        return "Feedback from " + firstName+ " "+lastName+" {"+email+"}\n\n"+
                "Feedback: "+completeFeedback+"\n\nIf the feedback is long than 500? "+longFeedback+
                "\n\nThe review ID: "+reviewID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompleteFeedback() {
        return completeFeedback;
    }

    public void setCompleteFeedback(String completeFeedback) {
        this.completeFeedback = completeFeedback;
    }

    public String getReviewID() {
        return reviewID;
    }

    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }

    public boolean isLongFeedback() {
        return longFeedback;
    }

    public void setLongFeedback(boolean longFeedback) {
        this.longFeedback = longFeedback;
    }
}
