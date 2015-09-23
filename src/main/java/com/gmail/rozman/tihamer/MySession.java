package com.gmail.rozman.tihamer;

import com.gmail.rozman.tihamer.POJOs.User;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * Created by trozman on 2015. 09. 23..
 */
public class MySession extends WebSession {

    private User user = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Constructor. Note that {@link RequestCycle} is not available until this constructor returns.
     *
     * @param request The current request
     */
    public MySession(Request request) {
        super(request);

    }



}
