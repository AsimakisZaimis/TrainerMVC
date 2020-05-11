package com.asimakis.trainermvc.services;

import com.asimakis.trainermvc.entities.Trainer;
import java.util.List;

public interface ITrainer {

    public List<Trainer> findAllTrainers();

    public Trainer findById(int id);

    public boolean save(Trainer student);

    public boolean delete(int id);

    public boolean update(Trainer student);
}
