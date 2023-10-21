package com.csvtojson.util.csvtomap;

import java.io.InputStream;
import java.util.Map;

public interface Usable {
     Map<Long, Map<String, String>> csvToMap(InputStream is);
}
