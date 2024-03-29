package net.sourceforge.jibs.command;

import net.sourceforge.jibs.server.JibsServer;
import net.sourceforge.jibs.server.Player;

import java.io.PrintWriter;

/**
 * The Adress command.
 */
public class Address_Command implements JibsCommand {
    public boolean execute(JibsServer jibsServer, Player player,
                           String strArgs, String[] args) {
        String playername = player.getName();
        PrintWriter out = player.getOutputStream();

        if (args.length == 2) {
            String email_address = args[1];

            if (player.changeAddress(email_address)) {
                out.println(playername + "'s adress changed to " +
                            email_address);
            } else {
                out.println("Error: " + playername + "'s adress unchanged");
            }
        } else {
            out.println("Wrong parameters");
        }

        out.flush();

        return true;
    }
}
