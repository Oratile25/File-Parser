package com.eviro.assessment.grad001.oratilemasipa;

import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/image")
public class ImageController {

    @GetMapping(value = "/{name}/{surname}/{\\w\\.\\w}")
    public FileSystemResource gethttpImageLink(@PathVariable String name, @PathVariable String surname){
        //
        AccountProfile accountProfile = new AccountProfile(name, surname,"");
        if (accountProfile != null) {
            String httpImageLink = accountProfile.getHttpImageLink();
            // Assuming the HTTP image link contains the absolute file path
            return new FileSystemResource(httpImageLink);
        }
        return null; // Or return a default image or appropriate error response
    }

}

