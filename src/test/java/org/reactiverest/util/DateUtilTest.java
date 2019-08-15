package org.reactiverest.util;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class DateUtilTest {


    @Test
    public void shouldParseWithoutTimeZone() {

        final String source = "2018-09-24T19:10:05";

        final Date output = DateUtil.parse(source);

        assertThat(org.assertj.core.util.DateUtil.yearOf(output), is(equalTo(2018)));
        assertThat(org.assertj.core.util.DateUtil.monthOf(output), is(equalTo(9)));
        assertThat(org.assertj.core.util.DateUtil.dayOfMonthOf(output), is(equalTo(24)));
        assertThat(org.assertj.core.util.DateUtil.hourOfDayOf(output), is(equalTo(19)));
        assertThat(org.assertj.core.util.DateUtil.minuteOf(output), is(equalTo(10)));
        assertThat(org.assertj.core.util.DateUtil.secondOf(output), is(equalTo(5)));
    }


    @Test
    public void shouldParseWithtTimeZone() {

        final String source = "2018-09-24T19:10:05+02:00";

        final Date output = DateUtil.parse(source);

        assertThat(org.assertj.core.util.DateUtil.yearOf(output), is(equalTo(2018)));
        assertThat(org.assertj.core.util.DateUtil.monthOf(output), is(equalTo(9)));
        assertThat(org.assertj.core.util.DateUtil.dayOfMonthOf(output), is(equalTo(24)));
        assertThat(org.assertj.core.util.DateUtil.hourOfDayOf(output), is(equalTo(19)));
        assertThat(org.assertj.core.util.DateUtil.minuteOf(output), is(equalTo(10)));
        assertThat(org.assertj.core.util.DateUtil.secondOf(output), is(equalTo(5)));
    }

    @Test
    public void shouldNotParse() {

        final String source = "2018-09-24";

        final Date output = DateUtil.parse(source);

        assertNull(output);
    }


    @Test
    public void shouldFormat() throws ParseException {

        final String source = "2018-09-24T19:10:05";
        final Date input = new SimpleDateFormat(DateUtil.YYYY_MM_DD_T_HH_MM_SS).parse(source);

        final String output = DateUtil.format(input);

        assertThat(output, Is.is(equalTo(source)));
    }

    @Test
    public void shouldFormatEmptyStringWhenInputDateIsNull() throws ParseException {

        final Date input = null;

        final String output = DateUtil.format(input);

        assertThat(output, Is.is(equalTo("")));
    }

    @Test
    public void shouldvalidateAndClearOfTimezone() {

        final String source = "2018-09-24T19:10:05+02:00";

        final String output = DateUtil.validateAndClearOfTimezone(source);

        assertThat(output, is(equalTo("2018-09-24T19:10:05")));
    }

    @Test
    public void shouldNotvalidateAndClearOfTimezone() {

        final String source1 = "2018-09-24";
        final String source2 = null;

        final String output1 = DateUtil.validateAndClearOfTimezone(source1);
        final String output2 = DateUtil.validateAndClearOfTimezone(source2);

        assertThat(output1, is(equalTo("")));
        assertThat(output2, is(equalTo("")));
    }

}