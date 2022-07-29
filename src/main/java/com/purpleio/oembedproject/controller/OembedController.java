package com.purpleio.oembedproject.controller;

import ac.simons.oembed.OembedResponse;
import ac.simons.oembed.OembedService;
import com.purpleio.oembedproject.common.UrlConstants;
import com.purpleio.oembedproject.dto.OembedDto;
import com.purpleio.oembedproject.dto.UrlDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
@RequestMapping(UrlConstants.OEMBED_BASE)
@RequiredArgsConstructor
public class OembedController {
    private final OembedService oembedService;

    @GetMapping(UrlConstants.INFO)
    public String oembedInfo(@ModelAttribute OembedDto oembedDto, Model model) {
        model.addAttribute("urlDto", new UrlDto());
        return "oembed/oembedList";
    }

    @PostMapping(UrlConstants.INFO)
    public String oembedParse(@Valid @ModelAttribute UrlDto urlDto, BindingResult result,
                              RedirectAttributes redirectAttributes) {
        OembedResponse response = oembedService.getOembedResponseFor(urlDto.getUrl())
                .orElse(null);
        if (response == null) {
            result.reject("notValidUrl", "유효하지 않은 url입니다.");
        }
        if(result.hasErrors()){
            return "home";
        }

        OembedDto oembedDto = new OembedDto(response.getType(), response.getVersion(), response.getTitle(),
                response.getAuthorName(), response.getAuthorUrl(), response.getProviderName(),
                response.getCacheAge(), response.getThumbnailUrl(), response.getThumbnailWidth(),
                response.getThumbnailHeight(), response.getUrl(), response.getHtml(), response.getWidth(),
                response.getHeight());

        redirectAttributes.addFlashAttribute("oembedDto", oembedDto);

        return UrlConstants.REDIRECT + UrlConstants.OEMBED_BASE + UrlConstants.INFO ;
    }

}
