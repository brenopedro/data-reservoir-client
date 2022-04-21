package com.reservoir.datareservoir.client.domain.model;

public enum UrlEnum {

    COLLECTION_CUBE("http://localhost/v1/cube-data"),
    COLLECTION_DRONE("http://localhost:8080/v1/drone-data"),
    COLLECTION_ROCKET("http://localhost:8080/v1/rocket-data");

    private final String url;

    UrlEnum(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
