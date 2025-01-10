Hazelcast Operations

This repository contains Java code for interacting with a Hazelcast distributed map. 
The code is designed to handle operations required by the AOM (Account and Balance Management Function)
and TGF (Traffic Generator Function) developers. 
Hazelcast is used as a distributed data grid to store and retrieve MSISDN (Mobile Subscriber Numbers) data.

Features
Put Operation: Adds a key-value pair (MSISDN and associated value) to the Hazelcast map.

Get Operation: Retrieves the value associated with a specific MSISDN key.

Get All Keys Operation: Retrieves all MSISDN keys stored in the Hazelcast map.

For AOM Developers
Purpose
The put method is provided for AOM developers to add MSISDNs to the Hazelcast map. 
This allows the distributed map to store data that can later be accessed by other components, such as TGF.

For TGF Developers
Purpose
The getAllMsisdn method is provided for TGF developers to retrieve MSISDN data from the Hazelcast map. 
This operation ensures that all keys or specific values can be fetched as required for traffic generation.
