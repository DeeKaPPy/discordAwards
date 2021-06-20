package eu.dkcode.discordawards.spark;

import eu.dkcode.discordawards.spark.controllers.AwardController;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spark.Spark;

/**
 * @Author: Kacper 'DeeKaPPy' Horbacz
 * @Created 20.06.2021
 * @Class: WebServer
 **/

@NoArgsConstructor
public class WebServer {

    @Getter
    private static final String SECRET = "SUPER_TAJNY_KOD";
    @Getter
    private static final String IP_ADDRESS = "127.0.0.1";

    public void start(){
        Spark.port(8080); // Set the port to the same as in the discord bot.

        Spark.post("/award", AwardController::handle);
    }

}
