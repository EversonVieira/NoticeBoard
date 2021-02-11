package noticeboard.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;
/*
    This class represents the domain, or the model if this is more friendly to one who's reading this.
    There no Mystery about that, it's just the model that we will use to make the CRUD works.
*/
@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String description;

    private Date publishDate;

    private Date viewDate;

    public Notice(String title, String description, Date publishDate, Date viewDate) {
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
        this.viewDate = viewDate;
    }

    public Notice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getViewDate() {
        return viewDate;
    }

    public void setViewDate(Date viewDate) {
        this.viewDate = viewDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notice notice = (Notice) o;
        return Objects.equals(id, notice.id) &&
                Objects.equals(title, notice.title) &&
                Objects.equals(description, notice.description) &&
                Objects.equals(publishDate, notice.publishDate) &&
                Objects.equals(viewDate, notice.viewDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, publishDate, viewDate);
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publishDate=" + publishDate +
                ", viewDate=" + viewDate +
                '}';
    }
}
