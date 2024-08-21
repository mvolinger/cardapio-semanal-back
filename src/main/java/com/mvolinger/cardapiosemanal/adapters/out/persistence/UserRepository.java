package com.mvolinger.cardapiosemanal.adapters.out.persistence;

import com.mvolinger.cardapiosemanal.adapters.out.persistence.jpa.UserJpaRepository;
import com.mvolinger.cardapiosemanal.adapters.out.persistence.mapper.UserMapper;
import com.mvolinger.cardapiosemanal.adapters.out.persistence.models.UserJpa;
import com.mvolinger.cardapiosemanal.core.domain.models.User;
import com.mvolinger.cardapiosemanal.core.port.out.FindUserOutputPort;
import com.mvolinger.cardapiosemanal.core.port.out.SaveUserOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepository implements SaveUserOutputPort, FindUserOutputPort {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        UserJpa userJpa = userMapper.toJpa(user);
        UserJpa userJpaSaved = userJpaRepository.save(userJpa);
        return userMapper.toModel(userJpaSaved);
    }

    @Override
    public User findById(UUID id) {
        UserJpa userJpa = userJpaRepository.findById(id)
                .orElseThrow(RuntimeException::new);
                //.orElseThrow(() -> new NotFoundException("meal not found"));
        return userMapper.toModel(userJpa);
    }
}