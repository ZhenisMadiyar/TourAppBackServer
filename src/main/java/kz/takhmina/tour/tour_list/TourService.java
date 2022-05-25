package kz.takhmina.tour.tour_list;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Service
public class TourService {

    private final TourRepository tourRepository;

    @Value("${upload.path}")
    private String uploadPath;

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

    @Transactional
    public void uploadFile(Long tourId, MultipartFile file) {
        Tour tour = tourRepository.findById(tourId).
                orElseThrow(() -> new IllegalStateException("Tour with id \" + tourId + \" not found"));

        if (file != null) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            System.out.println(uploadPath);

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            try {
                file.transferTo(new File(uploadPath + "/" + resultFilename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            tour.setFilename(resultFilename);
        }
    }

}
