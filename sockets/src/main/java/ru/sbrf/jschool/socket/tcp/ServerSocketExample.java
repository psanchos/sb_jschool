package ru.sbrf.jschool.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {

    public static final int PORT = 2018;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println(String.format("Application started, and listening port: %d", PORT));
        System.out.println("Wait connect...");

        try (
                Socket socket = serverSocket.accept();
        ) {
            System.out.println(String.format("connect accepted, client ip %s", socket.getInetAddress()));
        }
    }
}
