package InnerArch;

/**
 * Created by Нияз on 06.10.2014.
 */
public class NTimer
{
    private long interval;
    Thread worker;

    public NTimer(long interval)
    {
        this.interval=interval;
        Run();
    }

    public long getInterval()
    {
        return interval;
    }

    public void setInterval(long newProperty)
    {
        interval = newProperty;
    }

    public void Start()
    {
        worker.start();
    }

    public void Stop()
    {
        worker.stop();
    }

    public void Run()
    {
        worker = new Thread(new Runnable()
        {
            public void run()
            {
                //event
                while (true)
                {
                    //event...


                    try{Thread.sleep(interval);}
                    catch(InterruptedException e){}
                }
            }
        });
    }
}
