package com.yoyo.service;

import java.util.Optional;

import com.yoyo.entity.Player;

public interface PlayerService {
	
	public String upsert (Player p);
	public Optional<Player> getPlayer (Integer i1);
	public String removePlayer (Integer i2);

}
