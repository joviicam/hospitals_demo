package com.example.hospitals_demo.service;

import com.example.hospitals_demo.model.Medico;
import com.example.hospitals_demo.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    public Medico getMedicoById(Long id) {
        return medicoRepository.findById(id);
    }

    public void saveMedico(Medico medico) {
        if (medico.getId() == null) {
            medicoRepository.insert(medico);
        } else {
            medicoRepository.update(medico);
        }
    }

    public void deleteMedico(Long id) {
        medicoRepository.delete(id);
    }
}
