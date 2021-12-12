package com.nelluri.random;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShipmentAllocation {
    List<ShipmentRequest> shipmentRequests;

    private static final int TRUCK_CAPACITY = 5;

    /*
        Stores integer ranking for each vendor Id
     */
    Map<String, Integer> vendorRankings;

    /*
    stores integer capacity against each vendor Id
     */
    Map<String, Integer> vendorCapacity;

    ShipmentAllocation(ArrayList<ShipmentRequest> shipmentRequests) {
        this.shipmentRequests = shipmentRequests;

        vendorRankings = new LinkedHashMap<>();
        vendorRankings.put("v5", 1);
        vendorRankings.put("v4", 2);
        vendorRankings.put("v1", 3);
        vendorRankings.put("v3", 4);
        vendorRankings.put("v2", 5);

        vendorCapacity = new LinkedHashMap<>();
        vendorCapacity.put("v1",2);
        vendorCapacity.put("v2", 1);
        vendorCapacity.put("v3", 1);
        vendorCapacity.put("v4", 1);
        vendorCapacity.put("v5", 1);
    }
    /*
        print allocations made against each Shipment Request.
     */
    public void allocate() {
        String vendorId = getTruck();
        int truckCapacity = TRUCK_CAPACITY;

        for (ShipmentRequest sr : shipmentRequests ) {
            int shipmentSize = sr.getRequiredUnits();

            while(shipmentSize != 0) {
                if(shipmentSize < truckCapacity) {
                    System.out.println("Shipment with ID " + sr.getId() + " is allocated to vendor " + vendorId);
                    truckCapacity -= shipmentSize;
                    shipmentSize = 0;
                    if(truckCapacity == 0) {
                        vendorId = getTruck();
                        truckCapacity = TRUCK_CAPACITY;
                    }
                } else {
                    System.out.println("Shipment with ID " + sr.getId() + " is allocated to vendor " + vendorId);
                    shipmentSize -= truckCapacity;
                    vendorId = getTruck();
                    truckCapacity = TRUCK_CAPACITY;
                }
            }
        }
    }
    /*
        gets truck in round robin fashion from vendors based on ranking
     */
    int seq = 0;
    public String getTruck() {
        List<String> vendors = vendorRankings.keySet().stream().toList();
        while(true) {
            int vendor = seq % 5;
            String vendorId = vendors.get(vendor);
            if (vendorCapacity.get(vendorId) > 0) {
                vendorCapacity.put(vendorId, vendorCapacity.get(vendorId) - 1);
                seq++;
                return vendorId;
            }
            seq++;
        }
    }

    public static void main(String[] args) {
        ArrayList<ShipmentRequest> shipmentRequests = new ArrayList<>();
        ShipmentRequest sr1 = new ShipmentRequest("SE01",1);
        shipmentRequests.add(sr1);
        ShipmentRequest sr2 = new ShipmentRequest("SE01",2);
        ShipmentRequest sr3 = new ShipmentRequest("SE01",3);
        ShipmentRequest sr4 = new ShipmentRequest("SE01",4);
        ShipmentRequest sr5 = new ShipmentRequest("SE01",5);
        ShipmentRequest sr6 = new ShipmentRequest("SE01",6);
        ShipmentRequest sr7 = new ShipmentRequest("SE01",7);
        ShipmentRequest sr8 = new ShipmentRequest("SE01",8);
        shipmentRequests.add(sr2);shipmentRequests.add(sr3);shipmentRequests.add(sr4);
        shipmentRequests.add(sr5);shipmentRequests.add(sr6);shipmentRequests.add(sr7);
        shipmentRequests.add(sr8);
        ShipmentAllocation shipmentAllocation = new ShipmentAllocation(shipmentRequests);
        shipmentAllocation.allocate();
    }
}



