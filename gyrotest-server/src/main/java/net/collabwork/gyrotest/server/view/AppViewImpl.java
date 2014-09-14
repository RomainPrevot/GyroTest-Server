package net.collabwork.gyrotest.server.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.collabwork.gyrotest.server.AppModel;
import net.collabwork.gyrotest.server.AppPresenter;
import net.collabwork.gyrotest.server.AppView;
import net.collabwork.gyrotest.server.resources.Resources;

import java.awt.Window.Type;

import javax.swing.JToggleButton;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

public class AppViewImpl extends JFrame implements AppView {

    private AppPresenter appPresenter;
    private JLabel lblUser;
    private JLabel lblServerStatus;
    private JPanel panel;
    private JToggleButton tglConnect;

    public AppViewImpl() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setPreferredSize(new Dimension(800, 600));

        JPanel userConnectionPanel = new GradientPanel();
        userConnectionPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        userConnectionPanel.setForeground(Color.LIGHT_GRAY);
        userConnectionPanel.setBackground(new Color(100, 100, 100));
        getContentPane().add(userConnectionPanel, BorderLayout.NORTH);
        userConnectionPanel.setLayout(new BorderLayout(5, 5));

        lblUser = new JLabel("No User Connected");
        lblUser.setFont(Resources.openSansLight().deriveFont(12f));
        lblUser.setForeground(Color.LIGHT_GRAY);
        lblUser.setBackground(Color.WHITE);
        lblUser.setIcon(new ImageIcon(AppViewImpl.class
                .getResource("/net/collabwork/gyrotest/server/resources/cross.png")));
        userConnectionPanel.add(lblUser, BorderLayout.WEST);

        panel = new JPanel();
        panel.setOpaque(false);
        userConnectionPanel.add(panel, BorderLayout.EAST);

        lblServerStatus = new JLabel("New label");
        lblServerStatus.setFont(Resources.openSansLight().deriveFont(12f));
        lblServerStatus.setForeground(Color.LIGHT_GRAY);
        panel.add(lblServerStatus);

        tglConnect = new JToggleButton("");
        tglConnect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tglConnect.isSelected()) {
                    getPresenter().connect();
                } else {
                    getPresenter().disconnect();
                }
            }
        });
        tglConnect.setBorderPainted(false);
        tglConnect.setContentAreaFilled(false);
        tglConnect.setPreferredSize(new Dimension(16, 16));
        tglConnect.setIcon(new ImageIcon(AppViewImpl.class
                .getResource("/net/collabwork/gyrotest/server/resources/disconnect.png")));
        tglConnect.setSelectedIcon(new ImageIcon(AppViewImpl.class
                .getResource("/net/collabwork/gyrotest/server/resources/connect.png")));
        panel.add(tglConnect);

    }

    public void updateModelFromView() {
        // TODO Auto-generated method stub

    }

    public void updateViewFromModel() {
        AppModel model = getPresenter().getModel();
        lblUser.setText(model.getConnectedUser());

        if (model.getListeningPort() != null) {
            lblServerStatus.setText("listening on " + model.getListeningAddress() + ":" + model.getListeningPort());
        } else {
            lblServerStatus.setText(model.getListeningAddress());
        }

    }

    public void open() {
        pack();
        setVisible(true);
    }

    public void close() {
        dispose();
    }

    public void userRejected() {
        // TODO Auto-generated method stub

    }

    public AppPresenter getPresenter() {
        return appPresenter;
    }

    public void setPresenter(AppPresenter appPresenter) {
        this.appPresenter = appPresenter;
    }

}
