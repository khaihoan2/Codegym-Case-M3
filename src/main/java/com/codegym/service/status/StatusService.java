package com.codegym.service.status;

import com.codegym.dao.status.IStatusDao;
import com.codegym.dao.status.StatusDao;
import com.codegym.model.Status;

import java.util.List;

public class StatusService implements IStatusService{
    private IStatusDao statusDao = new StatusDao();

    @Override
    public List<Status> getAll() {
        return statusDao.getAll();
    }

    @Override
    public boolean save(Status status) {
        return false;
    }

    @Override
    public boolean update(int id, Status status) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Status findById(int id) {
        return null;
    }
}
