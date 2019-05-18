package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class BotClient extends Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new BotClient().run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    public String getUserName() {
        return "date_bot_"+ (int)((Math.random()*100));
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("������ ������. � ���. ������� �������: ����, ����, �����, ���, �����, ���, ������, �������.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message.contains(":")) {
                String userName = message.split(":")[0].trim();
                String userMessage = message.split(":")[1].trim();
                Map<String, String> formats = new HashMap<>();
                formats.put("����", "d.MM.YYYY");
                formats.put("����", "d");
                formats.put("�����", "MMMM");
                formats.put("���", "YYYY");
                formats.put("�����", "H:mm:ss");
                formats.put("���", "H");
                formats.put("������", "m");
                formats.put("�������", "s");
                formats.keySet().stream().filter(usMsg -> usMsg.equals(userMessage))
                        .forEach(s -> sendTextMessage(String.format("���������� ��� %s: %s",
                                userName, new SimpleDateFormat(formats.get(s)).format(Calendar.getInstance().getTime())
                        )));
            }

        }
    }
}
