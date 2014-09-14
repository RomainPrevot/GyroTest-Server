package net.collabwork.gyrotest.server;

public class AppModelImpl implements AppModel {

    private String user;

    private String address;

    private Integer port;

    public String getConnectedUser() {
        return user;
    }

    public void setConnectedUser(String user) {
        this.user = user;
    }

    public Integer getListeningPort() {
        return port;
    }

    public void setListeningPort(Integer listeningPort) {
        port = listeningPort;
    }

    public String getListeningAddress() {
        return address;
    }

    public void setListeningAddress(String listeningAddress) {
        address = listeningAddress;
    }

}
