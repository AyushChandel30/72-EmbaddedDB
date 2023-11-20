package com.yoyo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoyo.entity.Player;
import com.yoyo.repo.PlayerRepository;

@Service
public class PlayerServiceImp implements PlayerService {
	
	private PlayerRepository pr;
	
	@Autowired
	public PlayerServiceImp(PlayerRepository pr) {
		this.pr = pr;
	}

	@Override
	public String upsert(Player p) {
		Integer id = p.getId();
		pr.save(p);
		if (id == null) {
			return "saved";
		} else {
			return "updated";
		}
	}

	@Override
	public Optional<Player> getPlayer(Integer i1) {
		Optional<Player> findById = pr.findById(i1);
		return findById;
	}

	@Override
	public String removePlayer(Integer i2) {
		pr.deleteById(i2);
		return "deleted";
	}

}
