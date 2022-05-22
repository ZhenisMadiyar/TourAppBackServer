package kz.takhmina.tour.tour_list;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TourService {

    private final TourRepository tourRepository;

    @Autowired
    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tour> getTourList() {
        return tourRepository.findAll();
    }

    public Tour createTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public Tour getTourById(Long tourId) {
        return tourRepository.findById(tourId).
                orElseThrow(() -> new IllegalStateException("Tour with id " + tourId + " not found"));
    }

}
