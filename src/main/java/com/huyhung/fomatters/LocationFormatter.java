/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.fomatters;

import com.huyhung.pojo.Location;
import java.text.ParseException;
import org.springframework.format.Formatter;
import java.util.Locale;

/**
 *
 * @author TIM
 */
public class LocationFormatter implements Formatter<Location> {
    @Override
    public String print(Location location, Locale locale) {
        return String.valueOf(location.getId());
    }

    @Override
    public Location parse(String locationId, Locale locale) throws ParseException {
        Location c = new Location();
        c.setId(Integer.parseInt(locationId));
        
        return c;
    }
}
