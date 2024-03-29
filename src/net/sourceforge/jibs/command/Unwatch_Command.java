package net.sourceforge.jibs.command;

import net.sourceforge.jibs.gui.JibsMessages;
import net.sourceforge.jibs.server.JibsServer;
import net.sourceforge.jibs.server.Player;
import net.sourceforge.jibs.util.JibsWriter;

/**
 * The Unwatch command.
 */
public class Unwatch_Command implements JibsCommand {
    public boolean execute(JibsServer jibsServer, Player player,
                           String strArgs, String[] args) {
        JibsWriter out = player.getOutputStream();
        JibsMessages jibsMessages = jibsServer.getJibsMessages();
        String msg = null;

        if (!player.checkToggle("watch")) {
            // m_you_not_watch=** You're not watching.
            msg = jibsMessages.convert("m_you_not_watch");
            out.println(msg);

            return true;
        }

        Player playingPlayer = player.getWatchingPlayer();

        playingPlayer.stopWatching(player);
        player.changeToggle("watch", Boolean.FALSE);
        player.setWatchingPlayer(null);

        return true;
    }
}
