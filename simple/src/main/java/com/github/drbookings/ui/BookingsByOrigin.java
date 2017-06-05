package com.github.drbookings.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.github.drbookings.model.data.BookingOrigin;

public class BookingsByOrigin {

    public static Predicate<BookingEntry> BOOKING_FILTER = b -> "booking"
	    .equalsIgnoreCase(b.getElement().getBookingOrigin().getName());

    public static Predicate<BookingEntry> AIRBNB_FILTER = b -> "airbnb"
	    .equalsIgnoreCase(b.getElement().getBookingOrigin().getName());

    public static Predicate<BookingEntry> OTHER_FILTER = BOOKING_FILTER.negate().and(AIRBNB_FILTER.negate());

    private final Collection<BookingEntry> bookingEntries;

    public BookingsByOrigin(final Collection<? extends BookingEntry> bookingEntries) {
	this.bookingEntries = new ArrayList<>(bookingEntries);
    }

    public Collection<BookingEntry> getAirbnbBookings() {
	return bookingEntries.stream().filter(AIRBNB_FILTER).collect(Collectors.toList());
    }

    public Collection<BookingEntry> getAllBookings() {
	return bookingEntries;
    }

    public Collection<BookingEntry> getBookingBookings() {
	return bookingEntries.stream().filter(BOOKING_FILTER).collect(Collectors.toList());
    }

    public Collection<BookingEntry> getByOriginName(final String name) {
	return bookingEntries.stream().filter(b -> name.equalsIgnoreCase(b.getElement().getBookingOrigin().getName()))
		.collect(Collectors.toList());
    }

    public Map<BookingOrigin, Collection<BookingEntry>> getMap() {
	final Map<BookingOrigin, Collection<BookingEntry>> result = new LinkedHashMap<>();
	for (final BookingEntry be : bookingEntries) {
	    final Collection<BookingEntry> value = result.getOrDefault(be.getElement().getBookingOrigin(),
		    new ArrayList<>());
	    value.add(be);
	    result.put(be.getElement().getBookingOrigin(), value);
	}
	return result;
    }

    public Collection<BookingEntry> getOtherBookings() {
	return bookingEntries.stream().filter(OTHER_FILTER).collect(Collectors.toList());
    }

}
