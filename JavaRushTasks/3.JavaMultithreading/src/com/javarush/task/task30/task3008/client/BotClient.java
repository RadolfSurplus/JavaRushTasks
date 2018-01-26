package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            if (message != null) {
                ConsoleHelper.writeMessage(message);
                SimpleDateFormat format = null;
                if (message.contains(": ")) {
                    String[] input = message.split(": ");
                    if (input.length == 2 && input[1] != null) {
                        String name = input[0];
                        String text = input[1];
                        switch (text) {
                            case "дата":
                                format = new SimpleDateFormat("d.MM.YYYY");
                                break;
                            case "день":
                                format = new SimpleDateFormat("d");
                                break;
                            case "месяц":
                                format = new SimpleDateFormat("MMMM");
                                break;
                            case "год":
                                format = new SimpleDateFormat("YYYY");
                                break;
                            case "время":
                                format = new SimpleDateFormat("H:mm:ss");
                                break;
                            case "час":
                                format = new SimpleDateFormat("H");
                                break;
                            case "минуты":
                                format = new SimpleDateFormat("m");
                                break;
                            case "секунды":
                                format = new SimpleDateFormat("s");
                                break;
                        }
                        if (format != null) {
                            sendTextMessage(String.format("Информация для %s: %s", name, format.format(Calendar.getInstance().getTime())));
                        }
                    }
                }
            }

        }
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(Math.random() * 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String args[]) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}