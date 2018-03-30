/*
 * DrBookings
 *
 * Copyright (C) 2016 - 2018 Alexander Kerner
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 */

package com.github.drbookings.ui;

import com.github.drbookings.model.BookingEntry;

import java.util.Collection;

public class BookingEntryView {

    protected final Collection<BookingEntry> bookingEntries;

    public BookingEntryView(final Collection<BookingEntry> bookingEntries) {
	super();
	this.bookingEntries = bookingEntries;
    }

    @Override
    public String toString() {
	return bookingEntries.toString();
    }

}
