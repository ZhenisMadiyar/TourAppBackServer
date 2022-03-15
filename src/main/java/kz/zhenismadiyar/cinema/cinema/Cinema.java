package kz.zhenismadiyar.cinema.cinema;

import javax.persistence.*;

@Entity
@Table
public class Cinema {

    @Id
    @SequenceGenerator(
            name = "cinema_sequence",
            sequenceName = "cinema_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cinema_sequence"
    )

    private Long id;
    private String title;
    private String address;
    private Double rating;

    public Cinema() {

    }

    public Cinema(String title) {
        this.title = title;
    }

    public Cinema(Long id, String title, String address, Double rating) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.rating = rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }
}
