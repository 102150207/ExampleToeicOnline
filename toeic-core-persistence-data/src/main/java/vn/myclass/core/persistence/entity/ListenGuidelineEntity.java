package vn.myclass.core.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "listenguideline")
public class ListenGuidelineEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listenGuideId;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "contenr")
    private  String content;

    @Column(name = "createdate")
    private Timestamp createDate;

    @Column(name = "modifeddate")
    private Timestamp modifiedId;

    @OneToMany(mappedBy = "listenGuideline",fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList;

    public List<CommentEntity> getCommentEntityList() {
        return commentEntityList;
    }

    public void setCommentEntityList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }

    public Integer getListenGuideId() {
        return listenGuideId;
    }

    public void setListenGuideId(Integer listenGuideId) {
        this.listenGuideId = listenGuideId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Timestamp getModifiedId() {
        return modifiedId;
    }

    public void setModifiedId(Timestamp modifiedId) {
        this.modifiedId = modifiedId;
    }
}
