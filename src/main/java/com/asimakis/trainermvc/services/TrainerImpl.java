package com.asimakis.trainermvc.services;

import com.asimakis.trainermvc.dao.TrainerDaoImpl;
import com.asimakis.trainermvc.entities.Trainer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("trainerService")
@Transactional
public class TrainerImpl implements ITrainer {

    @Autowired
    TrainerDaoImpl dao;

    @Override
    public List<Trainer> findAllTrainers() {
        List<Trainer> trainers = dao.findAllTrainers();
        return trainers;
    }

    @Override
    public Trainer findById(int id) {
        return dao.findById(id);
    }

    @Override
    public boolean save(Trainer trainer) {
        return dao.save(trainer);
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public boolean update(Trainer trainer) {
        return dao.update(trainer);
    }

}
