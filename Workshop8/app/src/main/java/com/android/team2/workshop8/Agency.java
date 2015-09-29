package com.android.team2.workshop8;

/**
 * Created by Adam on 9/26/2015.
 * Agency Entitiy class which provides a layout for an Agency Object
 */
public class Agency {
    private int AgencyId;
    private String AgncyAddress;
    private String AgncyCity;
    private String AgncyPhone;


    public int getAgencyId() {
        return AgencyId;
    }

    public void setAgencyId(int agencyId) {
        AgencyId = agencyId;
    }

    public String getAgncyAddress() {
        return AgncyAddress;
    }

    public void setAgncyAddress(String agncyAddress) {
        AgncyAddress = agncyAddress;
    }

    public String getAgncyCity() {
        return AgncyCity;
    }

    public void setAgncyCity(String agncyCity) {
        AgncyCity = agncyCity;
    }

    public String getAgncyPhone() {
        return AgncyPhone;
    }

    public void setAgncyPhone(String agncyPhone) {
        AgncyPhone = agncyPhone;
    }
}
