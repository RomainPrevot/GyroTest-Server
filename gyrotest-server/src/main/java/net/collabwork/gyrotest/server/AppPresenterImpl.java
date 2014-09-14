package net.collabwork.gyrotest.server;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class AppPresenterImpl implements AppPresenter {

    private AppModel appModel;
    private AppView appView;

    private Runnable onLogin;

    private Runnable onConnect;

    public AppPresenterImpl(AppModel model, AppView view) {
        appModel = model;
        appView = view;
    }

    public AppModel getModel() {
        return appModel;
    }

    public void setModel(AppModel appModel) {
        this.appModel = appModel;
    }

    public AppView getView() {
        return appView;
    }

    public void setView(AppView appView) {
        this.appView = appView;
    }

    public void setOnLogin(Runnable onLogin) {
        this.onLogin = onLogin;
    }

    public void run() {
        appModel.setConnectedUser("lol test");
        appView.setPresenter(this);
        appView.updateViewFromModel();
        appView.open();
    }

    public void login() {
        appView.updateModelFromView();

        System.out.println("LOGIN ASKED");
        onLogin.run();
    }

    public void setOnConnectClicked(Runnable onConnect) {
        this.onConnect = onConnect;
    }

    public void connect() {
        try {
            appModel.setListeningAddress(Inet4Address.getLocalHost().getHostAddress());
            appModel.setListeningPort(1337);

            appView.updateViewFromModel();
        } catch (UnknownHostException e) {
            appModel.setListeningAddress("problem setting up the server");
        }
    }

    public void disconnect() {
        appModel.setListeningAddress("Server off");
        appModel.setListeningPort(null);

        appView.updateViewFromModel();
    }

}
