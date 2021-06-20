package eu.dkcode.discordawards.spark.controllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import eu.dkcode.discordawards.spark.WebServer;
import org.apache.commons.codec.digest.DigestUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import spark.Request;
import spark.Response;

/**
 * @Author: Kacper 'DeeKaPPy' Horbacz
 * @Created 20.06.2021
 * @Class: AwardController
 **/

public class AwardController {

    public static Object handle(Request req, Response res) {
        res.header("Content-Type","application/json");
        JsonObject body = new JsonParser().parse(req.body()).getAsJsonObject();
        if(!body.has("hash") || !body.has("name"))
            return "{\"status\":500, \"message\":\"Invalid structure\"}";

        String hash = body.get("hash").getAsString(), name = body.get("name").getAsString();
        if(!hash.equals(DigestUtils.sha256Hex(WebServer.getSECRET() + name)))
            return "{\"status\":500, \"message\":\"Invalid hash\"}";

        if(!req.ip().equals(WebServer.getIP_ADDRESS()))
            return "{\"status\":500, \"message\":\"Invalid IP Address\"}";

        final Player player = Bukkit.getPlayer(name);
        if(player == null)
            return "{\"status\":500, \"message\":\"Player is offline\"}";

        // you can do what ever you wan't here!
        Bukkit.getServer().dispatchCommand(
                Bukkit.getConsoleSender(),
                "say " + name + " odebral nagrode za discorda!"
        );

        return "{\"status\":200, \"message\":\"Award given successfully\"}";
    }

}
