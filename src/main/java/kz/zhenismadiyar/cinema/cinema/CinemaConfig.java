//package kz.zhenismadiyar.cinema.cinema;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class CinemaConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(CinemaRepository cinemaRepository) {
//        return args -> {
//            Cinema cinema1 = new Cinema( "Almaty cinema");
//            Cinema cinema2 = new Cinema("Astana cinema");
//
//            cinemaRepository.saveAll(List.of(cinema1, cinema2));
//        };
//    }
//}