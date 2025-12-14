package ie.atu.week2.project;

import ie.atu.week2.project.Booking.Booking;
import ie.atu.week2.project.Booking.BookingRepository;
import ie.atu.week2.project.Booking.BookingService;
import ie.atu.week2.project.Booking.BookingStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {
    @Mock
    private BookingRepository bookingRepository;


    @InjectMocks
    private BookingService bookingService;


    @Test
    void createBooking_success() {
        Booking booking = new Booking(1L, 10L, 20L, 2, BookingStatus.PENDING);
        when(bookingRepository.save(any())).thenReturn(booking);


        Booking saved = bookingService.createBooking(booking);


        assertEquals(BookingStatus.PENDING, saved.getStatus());
        verify(bookingRepository, times(1)).save(booking);
    }


    @Test
    void updateStatus_success() {
        Booking booking = new Booking(1L, 10L, 20L, 2, BookingStatus.PENDING);
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
        when(bookingRepository.save(any())).thenReturn(booking);


        Booking updated = bookingService.updateStatus(1L, BookingStatus.CONFIRMED);


        assertEquals(BookingStatus.CONFIRMED, updated.getStatus());
    }
}
