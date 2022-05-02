package com.example.FlightBookingCompanyBackend.daos;

import com.example.FlightBookingCompanyBackend.models.Reservation;
import com.example.FlightBookingCompanyBackend.models.Trip;
import com.example.FlightBookingCompanyBackend.repositories.ReservationRepository;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ReservationRestOrmDao {

  private static final double[] CLASS_MULTIPLIER = new double[]{0d, 1.2, 2.5, 4d};
  private static final char[] CODE_ARR = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8',
      '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
      'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

  @Autowired
  ReservationRepository reservationRepository;

  @GetMapping("/reservations/{code}")
  public Reservation findReservationByCode(@PathVariable("code") String code) {
    return reservationRepository.findReservationByCode(code);
  }

  @PostMapping("/reservations/{flightClass}")
  public Reservation createReservation(@RequestBody Trip trip,
      @PathVariable("flightClass") String flightClass) {
    String reservationCode = generateRandom6CharCode();
    double reservationCost = trip.getTotalCost() * CLASS_MULTIPLIER[getClassCode(flightClass)];
    Reservation reservation = new Reservation(null, reservationCode, flightClass, trip,
        reservationCost);
    return reservationRepository.save(reservation);
  }

  @PutMapping("/reservations/{code}/{flightClass}")
  public Reservation updateClass(@PathVariable("code") String code,
      @PathVariable("flightClass") String flightClass) {
    Reservation reservation = this.findReservationByCode(code);
    if (reservation == null) {
      return null;
    }
    String curClass = reservation.getFlightClass();
    int classCodeBeforeChange = this.getClassCode(curClass);
    int classCodeAfterChange = this.getClassCode(flightClass);
    if (classCodeAfterChange <= classCodeBeforeChange) {
      return reservation;
    }
    updateReservationCostAfterClassChange(reservation, classCodeBeforeChange, classCodeAfterChange);
    reservation.setFlightClass(flightClass);
    return reservationRepository.save(reservation);
  }

  @DeleteMapping("/reservations/{code}")
  public void deleteReservationByCode(@PathVariable("code") String code) {
    reservationRepository.deleteReservationByCode(code);
  }

  // basic 0
  // main 1
  // business 2
  // first 3
  private int getClassCode(String flightClass) {
    switch (flightClass) {
      case "BASIC":
        return 0;
      case "MAIN":
        return 1;
      case "BUSINESS":
        return 2;
      case "FIRST":
        return 3;
    }
    return -1;
  }

  private void updateReservationCostAfterClassChange(Reservation reservation,
      int classCodeBeforeChange, int classCodeAfterChange) {
    reservation.setReservationCost(
        reservation.getReservationCost() * CLASS_MULTIPLIER[classCodeAfterChange]
            / CLASS_MULTIPLIER[classCodeBeforeChange]);
  }

  // 6 character reservation code, i.e. X45WSD
  private String generateRandom6CharCode() {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < 6; i++) {
      int r = ThreadLocalRandom.current().nextInt(36);
      sb.append(CODE_ARR[r]);
    }
    return sb.toString();
  }
}
