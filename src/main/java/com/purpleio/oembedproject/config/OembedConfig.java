package com.purpleio.oembedproject.config;

import ac.simons.oembed.OembedEndpoint;
import ac.simons.oembed.OembedService;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static ac.simons.oembed.OembedResponse.*;


@Configuration
@RequiredArgsConstructor
public class OembedConfig {

    private final HttpClient httpClient;

    private OembedEndpoint youTubeEndPoint() {
        return endpoint("youtube","https://www.youtube.com/oembed",
                Arrays.asList("https://www\\.youtube\\.com/watch\\?v=.*", "http://.*youtube\\.com/watch.*",
                        "https?:.*youtube\\.com.*", "https?:.*youtu\\.be\\.com.*"));
    }

    private OembedEndpoint vimeoEndPoint() {
        return endpoint("vimeo", "https://vimeo.com/api/oembed.json",
                Arrays.asList("https://player\\.vimeo\\.com/.*", "http://player\\.vimeo\\.com/.*"
                        , "http://vimeo\\.com/m/#/.*", "https://vimeo\\.com/.*",
                        "http://vimeo\\.com/.*", "http://vimeo\\.com/groups/.*/videos/.*",
                        "https://www\\.vimeo\\.com/.*", "http://www\\.vimeo\\.com/.*",
                        "http://www\\.vimeo\\.com/groups/.*/videos/.*"));
    }

    private OembedEndpoint twitterEndPoint() {
        return endpoint("twitter", "https://publish.twitter.com/oembed",
                Arrays.asList("https?://www\\.twitter\\.com.*", "https?://.*twitter\\.com.*",
                        "https://www\\.twitter\\.com/.*/status/.*"));
    }

    private OembedEndpoint endpoint(String name, String endPointUrl, List<String> schemes ) {
        final OembedEndpoint endpoint = new OembedEndpoint();
        endpoint.setName(name);
        endpoint.setFormat(Format.json);
        endpoint.setMaxWidth(480);
        endpoint.setEndpoint(endPointUrl);
        endpoint.setUrlSchemes(schemes);

        return endpoint;
    }

    private List<OembedEndpoint> endpoints() {
        List<OembedEndpoint> endpoints = new ArrayList<>();
        endpoints.add(youTubeEndPoint());
        endpoints.add(vimeoEndPoint());
        endpoints.add(twitterEndPoint());
        return endpoints;
    }

    @Bean
    public OembedService oembedService() {
        final OembedService oembedService = new OembedService(httpClient, null,
                endpoints(), "oembed-app");
        oembedService.setAutodiscovery(false);
        return oembedService;
    }
}
