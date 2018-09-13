package vn.myclass.core.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(name = "content")
    private String content;

    @Column(name = "createdate")
    private Timestamp createDate;

    @ManyToOne
    @JoinColumn(name = "listenguidelineid")
    private ListenGuidelineEntity listenGuideline;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;


    public ListenGuidelineEntity getListenGuideline() {
        return listenGuideline;
    }

    public void setListenGuideline(ListenGuidelineEntity listenGuideline) {
        this.listenGuideline = listenGuideline;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}
