package com.apigateway.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class GatewayController {

    @Autowired
    WebClient.Builder webClientBuilder;

    @GetMapping("/")
    public String greeting(@AuthenticationPrincipal OidcUser oidcUser, Model model,
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client) {
        model.addAttribute("username", oidcUser.getEmail());
        model.addAttribute("idToken", oidcUser.getIdToken());
        model.addAttribute("accessToken", client.getAccessToken());

        return "Authenticated, Welcome : " + oidcUser.getPreferredUsername();
    }

}
