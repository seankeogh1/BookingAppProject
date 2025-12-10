package ie.atu.week2.project.Booking;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data @AllArgsConstructor @NoArgsConstructor @Entity


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


    public Booking(Long id, @NotNull(message = "Customer ID cannot be null") Long customerId, @NotNull(message = "Room ID cannot be null") Long roomId, @NotNull(message = "Number of guests cannot be null") Integer numberOfGuests, BookingStatus status) {
        this.id = id;
        this.customerId = customerId;
        this.roomId = roomId;
        this.numberOfGuests = numberOfGuests;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
