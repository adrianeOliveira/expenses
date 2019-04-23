package br.com.exactaworks.expenses.dao;

import br.com.exactaworks.expenses.pojo.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {
}
