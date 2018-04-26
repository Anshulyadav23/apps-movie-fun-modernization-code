package org.superbiz.moviefun.moviesapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class AlbumInfo implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String artist;
    private String title;
    private int year;
    private int rating;

    public AlbumInfo() {
    }

    public AlbumInfo(String artist, String title, int year, int rating) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean hasId() {
        return id != null;
    }

    public boolean isEquivalent(AlbumInfo other) {
        if (year != other.year) return false;
        if (!isEqual(title, other.title)) return false;
        if (!isEqual(artist, other.artist)) return false;

        return true;
    }

    private static <T> boolean isEqual(T one, T other) {
        if (one != null ? !one.equals(other) : other != null) return false;
        return true;
    }

    @Override
    public String toString() {
        return "AlbumInfo{" +
                "id=" + id +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlbumInfo)) return false;
        AlbumInfo albumInfo = (AlbumInfo) o;
        return getYear() == albumInfo.getYear() &&
                getRating() == albumInfo.getRating() &&
                Objects.equals(getId(), albumInfo.getId()) &&
                Objects.equals(getArtist(), albumInfo.getArtist()) &&
                Objects.equals(getTitle(), albumInfo.getTitle());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getArtist(), getTitle(), getYear(), getRating());
    }
}
