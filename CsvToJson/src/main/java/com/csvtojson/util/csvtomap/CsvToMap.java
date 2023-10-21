package com.csvtojson.util.csvtomap;

import org.apache.commons.csv.*;
import java.io.*;
import java.util.*;

public class CsvToMap implements Usable{
    @Override
    public Map<Long, Map<String, String>> csvToMap(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withIgnoreEmptyLines().withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            debug(csvParser.getHeaderNames());
            Map<Long, Map<String, String>> map = new HashMap<>();
            List<String> headerList = csvParser.getHeaderNames();
            for (CSVRecord csvRecord : csvRecords) {
                map.put(csvRecord.getRecordNumber(), csvRecord.toMap());
                Map<String, String> temp = new HashMap<>();
                long rowNum = csvRecord.getRecordNumber();
                for (String headerName: headerList) {
                    try {
                        temp.put(headerName, csvRecord.get(headerName));
                        map.put(rowNum, temp);
                    }catch (Exception e) {
                        temp.put(headerName, "");
                        map.put(rowNum, temp);
                    }
                }
            }
            return map;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
    void debug(Object...obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}
