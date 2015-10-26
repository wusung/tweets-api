package com.rga.service;

import com.rga.dao.UserDao;
import com.rga.model.Status;
import com.sun.jersey.api.spring.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by WinnieLin on 2015/10/22.
 */
@Service("statusService")
public class StatusService {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    UserDao userDao;

    private Map<Integer, Status> statuses = new HashMap<>();

    public List<Status> findAll() {
        List<Status> result = new ArrayList(statuses.values());
        for (Status it : result) {
            it.setUser(userDao.query(it.getUserId()));
        }
        return result;
    }

    public boolean addStatus(Status status) {
        status.setCreateDate(new Date());
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
