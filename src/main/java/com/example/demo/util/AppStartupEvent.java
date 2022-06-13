package com.example.demo.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.demo.data.Room;
import com.example.demo.data.RoomRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
	private final RoomRepository roomRepository;
	
	//need constructor to use final member variable
	public AppStartupEvent(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		Iterable<Room> rooms = this.roomRepository.findAll();
		rooms.forEach(System.out::println);
		
	}
}
