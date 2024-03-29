package net.sourceforge.jibs.gui;

import net.sourceforge.jibs.server.JibsServer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JibsConsole extends JPanel {
    private static final long serialVersionUID = -8314892544066996598L;
    private JTextArea txtPane;

    public JibsConsole(JibsServer jibsServer) {
        txtPane = jibsServer.getJibsGUI().getTextArea();
    }

    public JTextArea getTxtPane() {
        return txtPane;
    }
}
