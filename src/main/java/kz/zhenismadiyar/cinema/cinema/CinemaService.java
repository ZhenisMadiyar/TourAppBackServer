package kz.zhenismadiyar.cinema.cinema;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public List<Cinema> getCinemaList() {
        return cinemaRepository.findAll();
    }

    public Cinema createCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Transactional
    public void updateCinema(Long cinemaId, String title, String address) {
        Cinema cinema = cinemaRepository.findById(cinemaId).
                orElseThrow(() -> new IllegalStateException("Cinema with id " + cinemaId + " does not exist"));

        if (title != null && title.length() > 0 && !Objects.equals(title, cinema.getTitle())) {
            cinema.setTitle(title);
        }

        if (address != null && address.length() > 0 && !Objects.equals(address, cinema.getAddress())) {
            cinema.setAddress(address);
        }
    }

    public Cinema getCinemaById(Long cinemaId) {
        return cinemaRepository.findById(cinemaId).
                orElseThrow(() -> new IllegalStateException("Cinema with id " + cinemaId + " not found"));
    }

    @Transactional
    public void uploadFile(Long cinemaId, MultipartFile file) {
        Cinema cinema = cinemaRepository.findById(cinemaId).
                orElseThrow(() -> new IllegalStateException("Cinema with id \" + cinemaId + \" not found"));

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
            cinema.setFilename(resultFilename);
        }
    }
}
