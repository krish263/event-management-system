package com.event.booking.system.project.events;

import com.event.booking.system.project.entity.movies.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEvent;
import org.springframework.web.util.UriComponentsBuilder;

public class PaginatedResultsRetrievedEvent<T> extends ApplicationEvent {

    private UriComponentsBuilder uriBuilder;

    private HttpServletResponse response;

    private int pageNo;

    private int totalPages;

    private int pageSize;


    public PaginatedResultsRetrievedEvent(Class<T> userClass, UriComponentsBuilder uriBuilder, HttpServletResponse response, int pageNo, int totalPages, int pageSize) {
        super(userClass);
        this.uriBuilder=uriBuilder;
        this.response=response;
        this.pageNo=pageNo;
        this.totalPages=totalPages;
        this.pageSize=pageSize;
    }

    public UriComponentsBuilder getUriBuilder() {
        return uriBuilder;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Class<T> getUserClass() {
        return (Class<T>) getSource();
    }
}
