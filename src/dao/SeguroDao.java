package dao;

import java.util.List;

import entidades.Seguro;

public interface SeguroDao {
	public boolean insert(Seguro seguro);
	public List<Seguro> readAll();
}
