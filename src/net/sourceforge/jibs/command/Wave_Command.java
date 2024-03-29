package net.sourceforge.jibs.command;

import net.sourceforge.jibs.gui.JibsTextArea;
import net.sourceforge.jibs.server.JibsServer;
import net.sourceforge.jibs.server.Player;
import net.sourceforge.jibs.util.JibsWriter;

/**
 * The Wave command.
 */
public class Wave_Command implements JibsCommand {
    /*
     * (non-Javadoc)
     *
     * @see command.JibsCommand#execute(server.JibsServer, server.Player,
     *      java.lang.String, java.lang.String[])
     */
    public boolean execute(JibsServer jibsServer, Player player,
                           String strArgs, String[] args) {
        int wavings = player.getWavings();

        wavings++;

        if (wavings == 1) {
            // m_wave_goodbye=%0 waves goodbye.
            Object[] obj = new Object[] { player.getName() };
            String msg = jibsServer.getJibsMessages()
                                   .convert("m_wave_goodbye", obj);

            player.informPlayers(msg, null);
            JibsTextArea.log(jibsServer, msg, true);

            JibsWriter out = player.getOutputStream();

            msg = jibsServer.getJibsMessages().convert("m_you_wave");
            out.println(msg);
            player.setWavings(wavings);

            return true;
        } else {
            // m_wave_goodbye_again=%0 waves goodbye again.
            Object[] obj = new Object[] { player.getName() };
            String msg = jibsServer.getJibsMessages()
                                   .convert("m_wave_goodbye_again", obj);

            player.informPlayers(msg, null);
            JibsTextArea.log(jibsServer, msg, true);
            player.setWavings(wavings);

            JibsWriter out = player.getOutputStream();

            msg = jibsServer.getJibsMessages()
                            .convert("m_you_wave_goodbye_again");
            out.println(msg);

            JibsCommand byeCommand = new Exit_Command();

            byeCommand.execute(jibsServer, player, "bye", null);

            return false;
        }
    }
}
