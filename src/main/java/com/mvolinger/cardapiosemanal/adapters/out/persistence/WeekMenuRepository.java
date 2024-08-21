package com.mvolinger.cardapiosemanal.adapters.out.persistence;

import com.mvolinger.cardapiosemanal.adapters.out.persistence.jpa.WeekMenuJpaRepository;
import com.mvolinger.cardapiosemanal.adapters.out.persistence.mapper.WeekMenuMapper;
import com.mvolinger.cardapiosemanal.adapters.out.persistence.models.WeekMenuJpa;
import com.mvolinger.cardapiosemanal.core.domain.models.WeekMenu;
import com.mvolinger.cardapiosemanal.core.port.out.DeleteWeekMenuOutputPort;
import com.mvolinger.cardapiosemanal.core.port.out.FindWeekMenuOutputPort;
import com.mvolinger.cardapiosemanal.core.port.out.SaveWeekMenuOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class WeekMenuRepository implements SaveWeekMenuOutputPort, FindWeekMenuOutputPort, DeleteWeekMenuOutputPort {

    private final WeekMenuJpaRepository weekMenuJpaRepository;
    private final WeekMenuMapper weekMenuMapper;

    @Override
    public WeekMenu save(WeekMenu weekMenu) {
        WeekMenuJpa weekMenuJpa = weekMenuMapper.toJpa(weekMenu);
        WeekMenuJpa weekMenuJpaSaved = weekMenuJpaRepository.save(weekMenuJpa);
        return weekMenuMapper.toModel(weekMenuJpaSaved);
    }

    @Override
    public WeekMenu findById(UUID id) {
        WeekMenuJpa weekMenuJpa = weekMenuJpaRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        //.orElseThrow(() -> new NotFoundException("meal not found"));
        return weekMenuMapper.toModel(weekMenuJpa);
    }

    @Override
    public List<WeekMenu> findByUserId(UUID userId) {
        List<WeekMenuJpa> weekMenuJpaList = weekMenuJpaRepository.findByUser(userId);
        if(weekMenuJpaList.isEmpty()) {
            throw new RuntimeException();
            //.orElseThrow(() -> new NotFoundException("meal not found"));
        }
        return weekMenuJpaList.stream()
                .map(weekMenuMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {
        weekMenuJpaRepository.deleteById(id);
    }
}