package org.example;

import java.util.HashMap;

// DataAggregator class focuses on aggregating the the data into a hashmap tha contains the mobile
// number as the "key" and the data usage information as the value
public class DataAggregator {

    public HashMap<String, DataUsage> aggregatedInfo;

    public DataAggregator() {
        this.aggregatedInfo = new HashMap<>();
    }

    public void addRecord(DataRecord record) {
        // This function add the record to the hashmap and also checks whether the
        // mobile number was previously present if present then
        // we update the values
        // else we create a new usage object and add to the aggregated map

        String mobileNumber = record.mobileNumber;
        DataUsage usage = aggregatedInfo.get(mobileNumber);
        if (usage == null) {
            usage = new DataUsage();
            aggregatedInfo.put(mobileNumber, usage);
        }
        usage.addUsage(record.isRoaming, record.fourG, record.fiveG);
    }

    public HashMap<String, DataUsage> getAggregatedInfo() {
        return aggregatedInfo;
    }

}
