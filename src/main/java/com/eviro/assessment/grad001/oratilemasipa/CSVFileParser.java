package com.eviro.assessment.grad001.oratilemasipa;
/*
public class CSVFileParser {
}*/
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Component
public class CSVFileParser implements FileParser {

    @Override
    public void parseCSV(File csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String name = data[0].trim();
                    String surname = data[1].trim();
                    String imageFormat = data[2].trim();
                    String base64ImageData = data[3].trim();

                    File imageFile = convertCSVDataToImage(base64ImageData);

                    AccountProfile accountProfile = new AccountProfile();
                    accountProfile.setAccountHolderName(name);
                    accountProfile.setAccountHolderSurname(surname);

                    createImageLink(accountProfile,imageFile);

                    // Save the accountProfile object to the database or perform any desired operations

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File convertCSVDataToImage(String base64ImageData) {
        /*// Implementation to convert Base64 image data to a physical file
        // ...

        return null; // Placeholder; replace with your implementation*/
        File imageFile = null;
        try {
            byte[] imageData = Base64.getDecoder().decode(base64ImageData);
            imageFile = File.createTempFile("image", ".temp");
            Files.write(Paths.get(imageFile.getAbsolutePath()), imageData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageFile;
    }
    /*
    @Override
    public URI createImageLink(File fileImage) {
        return null;
    }*/

    @Override
    public URI createImageLink(AccountProfile accountProfile, File fileImage) {
        /*// Implementation to create the HTTP image link
        // ...

        // Set the httpImageLink in the accountProfile object
       //accountProfile.setHttpImageLink("http://example.com/image/" + accountProfile.getId());
        return null;*/
        String httpImageLink = "http://example.com/image/" + accountProfile.getId();
        accountProfile.setHttpImageLink(httpImageLink);
        return URI.create(httpImageLink);
    }


}

   /*
        @Override
    public File convertCSVDataToImage(String base64ImageData) {
        File imageFile = null;
        try {
            byte[] imageData = Base64.getDecoder().decode(base64ImageData);
            imageFile = File.createTempFile("image", ".temp");
            Files.write(Paths.get(imageFile.getAbsolutePath()), imageData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageFile;
    }

    @Override
    public URI createImageLink(AccountProfile accountProfile, File fileImage) {
        String httpImageLink = "http://example.com/image/" + accountProfile.getId();
        accountProfile.setHttpImageLink(httpImageLink);
        return URI.create(httpImageLink);
    }
     */

