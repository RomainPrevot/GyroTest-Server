package net.collabwork.gyrotest.server;

public interface AppModel {
    String getConnectedUser();

    void setConnectedUser(String user);

    Integer getListeningPort();

    void setListeningPort(Integer listeningPort);

    String getListeningAddress();

    void setListeningAddress(String listeningAddress);
}
