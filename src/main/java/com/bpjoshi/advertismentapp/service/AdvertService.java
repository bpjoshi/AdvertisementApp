package com.bpjoshi.advertismentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpjoshi.advertismentapp.model.Advert;
import com.bpjoshi.advertismentapp.repository.AdvertRepository;

@Service
public class AdvertService {
	
	private final AdvertRepository advertRepository;
	
	@Autowired
	public AdvertService(AdvertRepository advertRepository){
		this.advertRepository=advertRepository;
	}
	
	public boolean createAdvert(Advert advert){
		return advertRepository.createAdvert(advert);
	}
	
	public int[] createAdverts(List<Advert> adverts){
		return advertRepository.createAdverts(adverts);
	}
	
	public Advert getAdvert(int id){
		return advertRepository.getAdvert(id);
	}
	
	public List<Advert> getAdverts(){
		return advertRepository.getAdverts();
	}
	
}
