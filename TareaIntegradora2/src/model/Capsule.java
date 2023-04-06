package model;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
public class Capsule {
    private String name;
    private String id;

    private CapsuleType type;
    private String description;
    private String lessonLearned;
    private String hashtag;
    private Boolean published;
    private Boolean approved;
    private String dateOfApproval;

    public Capsule(String name,String id, CapsuleType type, String description, String lessonLearned, String hashtag, Boolean published, String dateOfApproval, Boolean approved) {
        this.name=name;
        this.id = id;
        this.type = type;
        this.description = description;
        this.lessonLearned = lessonLearned;
        this.hashtag = hashtag;
        this.published = published;
        this.dateOfApproval = dateOfApproval;
        this.approved = approved;
    }

    public String toString() {
        return "Capsule{" +
                "[Capsule ID]:'" + id + '\'' + "[Capsule Type]: '" + type + '\'' +
                "[Capsule description]:'" + description + '\'' +
                "[Lesson Learned]:'" + lessonLearned + '\'' + "[#Hashtag#]:" + hashtag + '\'' + "[Publishing State]:" + published + '\'' + "[State of approval]:" + approved + '\'' +
                "[Date of Approval]: " + dateOfApproval;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and setter methods for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and setter methods for lessonLearned
    public String getLessonLearned() {
        return lessonLearned;
    }

    public void setLessonLearned(String lessonLearned) {
        this.lessonLearned = lessonLearned;
    }

    // Getter and setter methods for hashtag
    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    // Getter and setter methods for published
    public Boolean isPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    // Getter and setter methods for dateOfApproval
    public String getDateOfApproval() {
        return dateOfApproval;
    }

    public void setDateOfApproval(String dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }

    // Getter and setter methods for approved
    public Boolean isApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }


}
