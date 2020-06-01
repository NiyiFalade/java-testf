package Ibm.urls;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Urls {
    getPetStatus("/v2/pet/findByStatus");

    private final String path;

    public String path() { return path; }
}
