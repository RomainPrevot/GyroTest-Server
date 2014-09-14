package net.collabwork.gyrotest.server;

public interface AppPresenter {
    AppModel getModel();

    void setModel(AppModel appModel);

    AppView getView();

    void setView(AppView appView);

    void setOnLogin(Runnable onLogin);

    void setOnConnectClicked(Runnable onConnect);

    void run();

    void login();

    void connect();

    void disconnect();
}
