package org.example._300347715bianca;

import org.example._300347715bianca.repositories.SeatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(SeatRepository seatRepository){
//        return args -> {
////            seatRepository.save(new SeatRepository("seatCode"));
////            seatRepository.findAll().forEach(p ->      {
////                System.out.println(p.getSeatCode());
//            });
//        };
//    }




}
