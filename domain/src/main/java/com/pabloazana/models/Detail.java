package com.pabloazana.models;

import java.util.List;

public class Detail {

    private String description;
    private String videoUri;
    private List<String> imageUriList;

    public Detail(String description, String videoUri, List<String> imageUriList) {
        this.description = description;
        this.videoUri = videoUri;
        this.imageUriList = imageUriList;
    }

    public String getDescription() {

        return description;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public List<String> getImageUriList() {
        return imageUriList;
    }
}
