package com.purpleio.oembedproject.dto;

import lombok.Data;

@Data
public class OembedDto {
    private String type;
    private String version;
    private String title;
    private String authorName;
    private String authorUrl;
    private String providerName;
    private Long cacheAge;
    private String thumbnailUrl;
    private Integer thumbnailWidth;
    private Integer thumbnailHeight;
    private String url;
    private String html;
    private Integer width;
    private Integer height;

    public OembedDto() {
    }

    public OembedDto(String type, String version, String title, String authorName,
                     String authorUrl, String providerName, Long cacheAge, String thumbnailUrl,
                     Integer thumbnailWidth, Integer thumbnailHeight, String url, String html,
                     Integer width, Integer height) {
        this.type = type;
        this.version = version;
        this.title = title;
        this.authorName = authorName;
        this.authorUrl = authorUrl;
        this.providerName = providerName;
        this.cacheAge = cacheAge;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
        this.url = url;
        this.html = html;
        this.width = width;
        this.height = height;
    }
}
