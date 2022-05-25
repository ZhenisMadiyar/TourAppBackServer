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
    private String price;
    private Double rating;
    private String filename;

    public Tour() {

    }

    public Tour(String title) {
        this.title = title;
    }

    public Tour(Long id, String title, String price, Double rating, String filename) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.rating = rating;
        this.filename = filename;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
