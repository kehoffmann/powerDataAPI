package com.baywa.powerDataAPI.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtils {

    public static String getNow() {
        return ZonedDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS).toString();
    }

}
