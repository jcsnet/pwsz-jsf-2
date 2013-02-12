package pl.itcrowd.jug.utils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean
@ApplicationScoped
public class RequestCounter {

    private int requestCount = 0;

    public RequestCounter()
    {
    }

    public int getRequestCount()
    {
        return ++requestCount;
    }

    public void setRequestCount(int requestCount)
    {
        this.requestCount = requestCount;
    }
}

