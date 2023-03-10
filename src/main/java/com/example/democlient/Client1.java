package com.example.democlient;
import javax.imageio.plugins.tiff.TIFFDirectory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class Client1 {
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;

    public Client1(String ip, int port) {
        try {
            // 서버에 요청 보내기
            socket = new Socket(ip, port);
            System.out.println(socket.getInetAddress().getHostAddress() + "에 연결됨");
            String str = null;
            while (true) {
                // 메시지 받기
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                pw = new PrintWriter(socket.getOutputStream());

                // 메세지 전달
                String msg = LocalDateTime.now().plusHours(9) + " " + UUID.randomUUID().toString();
                System.out.println(msg);
                pw.println(msg);
                pw.flush();

                if ((str = br.readLine()) != null) {
                    // 응답 출력
                    System.out.println(str);
                } else {
                    System.out.println("수신 실패");
                    break;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // 소켓 닫기 (연결 끊기)
            try {
                if(socket != null) { socket.close(); }
                if(br != null) { br.close(); }
                if(pw != null) { pw.close(); }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
