package ru.sbrf.jschool.socket.tcp;

import java.net.Socket;

public class InTownGameSocketThread extends Thread {
    private Socket socket;

    public InTownGameSocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}
