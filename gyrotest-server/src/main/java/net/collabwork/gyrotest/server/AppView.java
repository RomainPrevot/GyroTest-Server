package net.collabwork.gyrotest.server;

public interface AppView {
    AppPresenter getPresenter();

    void setPresenter(AppPresenter appPresenter);

    void updateModelFromView();

    void updateViewFromModel();

    void open();

    void close();

    void userRejected();
}
