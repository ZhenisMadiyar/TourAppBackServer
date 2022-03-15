package kz.zhenismadiyar.cinema.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cinema")
public class CinemaController {

    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping()
    public List<Cinema> cinema() {
        return cinemaService.getCinemaList();
    }

    @GetMapping("/{cinema_id}")
    public Cinema getCinemaById(@PathVariable Long cinema_id) {
        return cinemaService.getCinemaById(cinema_id);
    }

    @PostMapping
    public void createCinema(@RequestBody Cinema cinema) {
        cinemaService.createCinema(cinema);
    }

    @PutMapping(path = {"{cinemaId}"})
    public void updateCinema(@PathVariable("cinemaId") Long cinemaId,
                             @RequestParam(required = false) String title,
                             @RequestParam(required = false) String address) {
        cinemaService.updateCinema(cinemaId, title, address);
    }
}