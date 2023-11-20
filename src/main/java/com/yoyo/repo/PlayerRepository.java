package com.yoyo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoyo.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
