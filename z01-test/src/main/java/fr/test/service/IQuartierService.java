package fr.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.test.model.Quartier;

public interface IQuartierService {

	public List<Quartier> getAll();

	public Quartier getById(int id);

	public Quartier getByName(String name);

	public void create(Quartier quartier);

	public void update(Quartier quartier);

	public void delete(int id);

}
