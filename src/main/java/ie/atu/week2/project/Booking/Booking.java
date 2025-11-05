package ie.atu.week2.project.Booking;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Customer ID cannot be null")
    private Long customerId;

    @NotNull(message = "Room ID cannot be null")
    private Long roomId;

    @NotNull(message = "Number of guests cannot be null")
    private Integer numberOfGuests;

    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.PENDING;

}
