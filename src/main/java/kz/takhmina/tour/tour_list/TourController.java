package kz.takhmina.tour.tour_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/tour")
public class TourController {

    private final TourService tourService;

    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping()
    public List<Tour> tour() {
        return tourService.getTourList();
    }

    @GetMapping("/{tour_id}")
    public Tour getTourById(@PathVariable Long tour_id) {
        return tourService.getTourById(tour_id);
    }

    @PostMapping
    public void createTour(@RequestBody Tour tour) {
        tourService.createTour(tour);
    }

    @PostMapping("/uploadFile")
    public void uploadFile(@RequestParam("tourId") Long tourId,
                           @RequestParam MultipartFile file) {
        tourService.uploadFile(tourId, file);
    }
}