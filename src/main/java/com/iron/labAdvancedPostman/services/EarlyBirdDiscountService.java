package com.iron.labAdvancedPostman.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EarlyBirdDiscountService {

    private static final int HIGH_THRESHOLD = 30;
    private static final int MEDIUM_THRESHOLD = 15;
    private static final int LOW_THRESHOLD = 7;

    private static final double HIGH_DISCOUNT = 0.15;
    private static final double MEDIUM_DISCOUNT = 0.10;
    private static final double LOW_DISCOUNT = 0.05;

    public String discountPercentage(LocalDate bookingDate, LocalDate eventDate){

        if (!bookingDate.isBefore(eventDate))
            return "Fecha de reserva no válida. No puede ser posterior a la fecha del evento.";

        long daysBetween = ChronoUnit.DAYS.between(bookingDate, eventDate);

        if (daysBetween >= HIGH_THRESHOLD)
            return formatDiscount(HIGH_DISCOUNT);

        if (daysBetween >= MEDIUM_THRESHOLD)
            return formatDiscount(MEDIUM_DISCOUNT);

        if (daysBetween >= LOW_THRESHOLD)
            return formatDiscount(LOW_DISCOUNT);


        return "No discount available. Booking too late.";

    }

    private String formatDiscount(double discount) {
        return "Descuento aplicado " + (discount * 100) + "%.";
    }
}
