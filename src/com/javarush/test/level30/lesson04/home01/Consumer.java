package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Дмитрий on 10.11.2015.
 */
public class Consumer extends Thread
{
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try { Thread.sleep(500); } catch (InterruptedException e) {return;}

        while(true)
        {
            try
            {
                ShareItem item = queue.take();
                System.out.println("Processing " + item.toString());
            }
            catch (InterruptedException e) {return;}
        }
    }
}
