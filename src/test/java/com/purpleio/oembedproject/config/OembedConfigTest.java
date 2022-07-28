package com.purpleio.oembedproject.config;

import ac.simons.oembed.OembedResponse;
import ac.simons.oembed.OembedService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class OembedConfigTest {
    @Autowired
    OembedService oembedService;

    @Test
    @DisplayName("OembedService Bean 테스트")
    void oEmbedService_Bean() {
        Optional<OembedResponse> oembedResponseFor1 = oembedService.getOembedResponseFor("https://www.youtube.com/watch?v=3UhUYqJkWGw");
        Optional<OembedResponse> oembedResponseFor2 = oembedService.getOembedResponseFor("https://vimeo.com/20097015");
        Optional<OembedResponse> oembedResponseFor3 = oembedService.getOembedResponseFor("https://twitter.com/hellopolicy/status/867177144815804416");

        log.info(oembedResponseFor1.get().getAuthorName());
        log.info(oembedResponseFor2.get().getAuthorName());
        log.info(oembedResponseFor3.get().getAuthorName());

        Assertions.assertAll(() -> {
            Assertions.assertEquals(oembedService.getOembedResponseFor(""), Optional.empty());
        });
    }
}