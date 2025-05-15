package com.iron.labAdvancedPostman.controllers;

import com.iron.labAdvancedPostman.services.EarlyBirdDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/")
public class DiscountController {

    @Autowired
    private EarlyBirdDiscountService earlyBirdDiscountService;

    @GetMapping("/discount")
    public String getMessageDiscount(@RequestParam LocalDate bookingDate, @RequestParam LocalDate eventDate){
        return earlyBirdDiscountService.discountPercentage(bookingDate, eventDate);
    }
}
