package kz.zhenismadiyar.cinema.cinema;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;

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
                orElseThrow(() -> new IllegalStateException("Cinema with id "+cinemaId+" not found"));
    }
}
