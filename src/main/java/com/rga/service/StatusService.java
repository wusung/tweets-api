package com.rga.service;

import com.rga.model.Status;
import com.sun.jersey.api.spring.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WinnieLin on 2015/10/22.
 */
@Service("statusService")
public class StatusService {

    @Autowired
    private AuthenticationService authenticationService;

    private Map<Integer, Status> statuses = new HashMap<>();

    public List<Status> findAll() {
        return new ArrayList(statuses.values());
  }

    public boolean addStatus(Status status) {
        statuses.put(status.getId(), status);
        return true;
    }

    public Status find(Integer id) {
        return statuses.get(id);
    }

    public List<Status> findById(Integer id) {
        List<Status> results = new ArrayList<>();
        for (Status s : statuses.values()) {
            if (id == s.getUserId())
                results.add(s);
        }
        return results;
    }
}
