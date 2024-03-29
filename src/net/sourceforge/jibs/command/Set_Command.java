package net.sourceforge.jibs.command;

import net.sourceforge.jibs.gui.JibsMessages;
import net.sourceforge.jibs.server.JibsServer;
import net.sourceforge.jibs.server.Player;
import net.sourceforge.jibs.util.JibsSet;

/**
 * The Set command.
 */
public class Set_Command implements JibsCommand {
    /*
     * (non-Javadoc)
     *
     * @see command.JibsCommand#execute(server.JibsServer, server.Player,
     *      java.lang.String, java.lang.String[])
     */
    public boolean execute(JibsServer jibsServer, Player player,
                           String strArgs, String[] args) {
        JibsMessages jibsMessages = jibsServer.getJibsMessages();
        JibsSet jibsSet = player.getJibsSet();

        // m_you_set=Value of '%0' set to %1.
        Object[] obj = { args[1], args[2] };
        String msg = jibsMessages.convert("m_you_set", obj);

        player.getOutputStream().println(msg);
        jibsSet.getSetMap().put(args[1], args[2]);

        return true;
    }
}
