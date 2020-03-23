package com.balena.dronerealtime.model;


import com.balena.dronerealtime.utils.GeneralUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationModel {

    @Id
    @Column
    private String uniqueId;

    @Column
    private String currLocation;

    @Column
    private String prevLocation;

    public String getSpeed() {
        String[] currentLocationArray = this.currLocation.split(",");
        double currLat = Double.valueOf(currentLocationArray[0]);
        double currLong =  Double.valueOf(currentLocationArray[1]);

        String[] prevLocationArray = this.prevLocation.split(",");

        double prevLat = Double.valueOf(prevLocationArray[0]);
        double prevLong = Double.valueOf(prevLocationArray[1]);

        double distance = GeneralUtils.distance(prevLat, currLat, prevLong, currLong, 0.0, 0.0);

        return String.valueOf(distance);
    }

    @Override
    public String toString() {

        return "{ \"uniqueId\": " + this.uniqueId + ", \"prevLocation\": " + this.prevLocation + ", \"currLocation\": " + this.currLocation + "}";
    }
}
