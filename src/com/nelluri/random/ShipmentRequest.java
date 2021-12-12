package com.nelluri.random;

public class ShipmentRequest {
    ShipmentRequest(String shipmentType, int id) {
        this.shipmentType = shipmentType;
        this.id = id;
        // default constructor.
    }
    int id;
    String shipmentType;

    int getId() {
        return id;
    }

    int getRequiredUnits() {

        if(this.shipmentType == "SE01") {
            return 10;
        } else if(this.shipmentType == "SE02") {
            return 4;
        } else if(this.shipmentType == "SE03") {
            return 3;
        } else if(this.shipmentType == "SE04") {
            return 2;
        } else if(this.shipmentType == "SE05") {
            return 1;
        }
        return -1;
    }

}
