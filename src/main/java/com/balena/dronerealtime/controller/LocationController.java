package com.balena.dronerealtime.controller;

import com.balena.dronerealtime.model.LocationModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class LocationController {

    @MessageMapping("/loc.update")
    @SendTo("/topic/loc")
    public LocationModel sendToFrontend(@Payload LocationModel locationModel, SimpMessageHeaderAccessor  headerAccessor) {
        headerAccessor.getSessionAttributes().put("username",locationModel.getPrevLocation());
        System.out.println("lovely men");
        return locationModel;
    }

}
