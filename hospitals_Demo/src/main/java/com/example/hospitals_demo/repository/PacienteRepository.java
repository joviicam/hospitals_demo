package com.example.hospitals_demo.repository;

import com.example.hospitals_demo.model.Paciente;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PacienteRepository {

    @Select("SELECT * FROM paciente")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "nombre", column = "NOMBRE"),
            @Result(property = "edad", column = "EDAD"),
            @Result(property = "antecedentesMedicos", column = "ANTECEDENTES_MEDICOS")
    })
    List<Paciente> findAll();


    @Select("SELECT * FROM paciente WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "nombre", column = "NOMBRE"),
            @Result(property = "edad", column = "EDAD"),
            @Result(property = "antecedentesMedicos", column = "ANTECEDENTES_MEDICOS")
    })
    Paciente findById(Long id);

    @Select("SELECT * FROM paciente WHERE nombre = #{nombre}")
    Paciente findByNombre(String nombre);

    @Insert("INSERT INTO paciente(id, nombre, edad, antecedentes_medicos) " +
            "VALUES(paciente_seq.NEXTVAL, #{nombre}, #{edad}, #{antecedentesMedicos, jdbcType=VARCHAR})")
    void insert(Paciente paciente);



    @Update("UPDATE paciente SET nombre=#{nombre}, edad=#{edad}, antecedentes_medicos=#{antecedentesMedicos} " +
            "WHERE id=#{id}")
    void update(Paciente paciente);

    @Delete("DELETE FROM paciente WHERE id=#{id}")
    void delete(Long id);
}
