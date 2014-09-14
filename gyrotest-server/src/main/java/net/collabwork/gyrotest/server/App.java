package net.collabwork.gyrotest.server;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.collabwork.gyrotest.server.view.AppViewImpl;

/**
 * Hello world!
 * 
 */
public class App {
    public static void main(String[] args) throws IOException {

        // Set the look and feel to users OS LaF.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                final AppModel appModel = new AppModelImpl();
                final AppView appView = new AppViewImpl();
                final AppPresenter appPresenter = new AppPresenterImpl(appModel, appView);

                appModel.setListeningAddress("Server off");
                appPresenter.setOnLogin(new Runnable() {

                    public void run() {
                        appModel.setConnectedUser("Coucou user connected");
                        appView.updateViewFromModel();
                    }
                });

                appPresenter.run();
            }
        });

        // System.out.println("Hello World!");
        // ServerSocket server = new ServerSocket(1337);
        // System.out.println("listening on " +
        // Inet4Address.getLocalHost().getHostAddress() + ":1337");
        // Socket client = server.accept();
        // System.out.println("Client connected: " +
        // client.getInetAddress().getHostAddress());
    }
}
