package com.eviro.assessment.grad001.oratilemasipa;

import java.io.File;
import java.net.URI;

public interface FileParser {
    void parseCSV(File csvFile);
    File convertCSVDataToImage(String base64ImageData);
    //URI createImageLink(File fileImage);

    URI createImageLink(AccountProfile accountProfile, File fileImage);
}
