package com.example.hospitals_demo.repository;

import com.example.hospitals_demo.model.Medico;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MedicoRepository {

    @Select("SELECT * FROM medico")
    List<Medico> findAll();

    @Select("SELECT * FROM medico WHERE id = #{id}")
    Medico findById(Long id);

    @Insert("INSERT INTO medico(id, nombre, especialidad) VALUES(medico_seq.NEXTVAL, #{nombre}, #{especialidad})")
    void insert(Medico medico);

    @Update("UPDATE medico SET nombre=#{nombre}, especialidad=#{especialidad} WHERE id=#{id}")
    void update(Medico medico);

    @Delete("DELETE FROM medico WHERE id=#{id}")
    void delete(Long id);
}
