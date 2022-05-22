package kz.takhmina.tour.tour_list;

import javax.persistence.*;

@Entity
@Table
public class Tour {

    @Id
    @SequenceGenerator(
            name = "tour_sequence",
            sequenceName = "tour_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tour_sequence"
    )

    private Long id;
    private String title;
    private String address;
    private Double rating;

    public Tour() {

    }

    public Tour(String title) {
        this.title = title;
    }

    public Tour(Long id, String title, String address, Double rating, String filename) {
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
