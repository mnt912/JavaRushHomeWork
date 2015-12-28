package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Дмитрий on 10.11.2015.
 */
public class Producer extends Thread
{
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        for (int i = 1; i <= 9 && !isInterrupted(); i++)
        {
            String descriptionString = "ShareItem-" + i;
            System.out.println(String.format("Элемент '%s' добавлен", descriptionString));
            queue.offer(new ShareItem(descriptionString, i));

            try { Thread.sleep(100); } catch (InterruptedException e) {return;}

            if (queue.hasWaitingConsumer()) System.out.println("Consumer в ожидании!");
        }
    }
}
