package com.sample.project.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String isPrivate;
    @Column
    private Instant createDateOn;
    @Column
    private Instant updateDateOn;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "location_id")
    private Location location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreateDateOn() {
        return createDateOn;
    }

    public void setCreateDateOn(Instant createDateOn) {
        this.createDateOn = createDateOn;
    }

    public Instant getUpdateDateOn() {
        return updateDateOn;
    }

    public void setUpdateDateOn(Instant updateDateOn) {
        this.updateDateOn = updateDateOn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
