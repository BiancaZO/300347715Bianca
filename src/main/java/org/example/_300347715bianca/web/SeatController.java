package org.example._300347715bianca.web;


import lombok.AllArgsConstructor;
import org.example._300347715bianca.entities.Seat;
import org.example._300347715bianca.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class SeatController {


    @Autowired
    private SeatRepository seatRepository;

    @GetMapping(path = "/")
    public String seat(Model model) {
        List<Seat> seats = seatRepository.findAll();
        int remainingSeats = 20 - seats.size(); // Calcular dinamicamente

        Map<String, String> seatMap = new HashMap<>();
        for (Seat s : seats) {
            seatMap.put(s.getSeatCode(), s.getCustomerName());
        }

        model.addAttribute("remainingSeats", remainingSeats);
        model.addAttribute("seats", seats);
        model.addAttribute("seatMap", seatMap); // Adiciona seatMap ao modelo
        return "main";
    }



    @PostMapping(path = "/reserveSeat")
    public String reserveSeat(@ModelAttribute Seat seat, Model model) {
        Seat existingSeat = seatRepository.findBySeatCode(seat.getSeatCode());
        if (existingSeat != null) {
            existingSeat.setCustomerName(seat.getCustomerName());
            seatRepository.save(existingSeat);
        } else {
            seatRepository.save(seat);
        }
        model.addAttribute("seats", seatRepository.findAll());
        return "redirect:/";
    }



    @GetMapping("/delete")
    public String delete(Long id) {

        seatRepository.deleteById(id);

        return "redirect:/";

    }
}
