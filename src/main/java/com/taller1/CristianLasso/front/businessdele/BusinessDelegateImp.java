package com.taller1.CristianLasso.front.businessdele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.taller1.CristianLasso.back.model.Autotransition;
import com.taller1.CristianLasso.back.model.FevInstitution;
import com.taller1.CristianLasso.back.model.Localcondition;
import com.taller1.CristianLasso.back.model.Precondition;
import com.taller1.CristianLasso.back.model.Threshold;

@Component
public class BusinessDelegateImp implements BusinessDelegate{

	public static final String URL = "http://localhost:8080/admin";
	
	private RestTemplate rest;
	
	public BusinessDelegateImp() {
		this.rest = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        this.rest.setMessageConverters(messageConverters);
	}
	
	// --- Autotransition ---
	
	public List<Autotransition> autotranFindAll(){
		String url = URL + "/autotransition/";
		System.out.println(url);
		Autotransition[] auto = rest.getForObject(url, Autotransition[].class);
		List<Autotransition> result = Arrays.asList(auto);
		return result;
	}
	
	public void autotranSave(Autotransition autotran) {
		String url = URL + "/autotransition/add-autotransition";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		url = builder.toUriString();
		
		HttpEntity<Autotransition> request = new HttpEntity<>(autotran);
		rest.postForObject(url, request, Autotransition.class);
	}
	
	public void autotranEdit(Autotransition autotran) {
		String url = URL + "/autotransition/edit/" + autotran.getAutotranId();
		rest.put(url, autotran, Autotransition.class);
	}
	
	public Autotransition autotranFinById(long id) {
		String url = URL + "/autotransition/" + id;
		Autotransition auto = rest.getForObject(url, Autotransition.class);
		return auto;
	}
	
	public void autotranDelete(long id) {
		String url = URL + "/users/del/" + id;
		rest.delete(url);
	}
	
	// --- FevInstitution ---
	
	public List<FevInstitution> instiFindAll(){
		String url = URL + "/fevInstitution/";
		System.out.println(url);
		FevInstitution[] auto = rest.getForObject(url, FevInstitution[].class);
		List<FevInstitution> result = Arrays.asList(auto);
		return result;
	}
	
	public void instiSave(FevInstitution autotran) {
		String url = URL + "/fevInstitution/add-fevInstitution";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		url = builder.toUriString();
		
		HttpEntity<FevInstitution> request = new HttpEntity<>(autotran);
		rest.postForObject(url, request, FevInstitution.class);
	}
	
	public void instiEdit(FevInstitution autotran) {
		String url = URL + "/fevInstitution/edit/" + autotran.getInstId();
		rest.put(url, autotran, FevInstitution.class);
	}
	
	public FevInstitution instiFinById(long id) {
		String url = URL + "/fevInstitution/" + id;
		FevInstitution auto = rest.getForObject(url, FevInstitution.class);
		return auto;
	}
	
	public void instiDelete(long id) {
		String url = URL + "/fevInstitution/del/" + id;
		rest.delete(url);
	}
	
	// --- Localcondition ---
	
	public List<Localcondition> localFindAll(){
		String url = URL + "/localcondition/";
		System.out.println(url);
		Localcondition[] auto = rest.getForObject(url, Localcondition[].class);
		List<Localcondition> result = Arrays.asList(auto);
		return result;
	}
	
	public void localSave(Localcondition autotran) {
		String url = URL + "/localcondition/add-localcondition";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		url = builder.toUriString();
		
		HttpEntity<Localcondition> request = new HttpEntity<>(autotran);
		rest.postForObject(url, request, Localcondition.class);
	}
	
	public void localEdit(Localcondition autotran) {
		String url = URL + "/localcondition/edit/" + autotran.getLoconId();
		rest.put(url, autotran, Localcondition.class);
	}
	
	public Localcondition localFinById(long id) {
		String url = URL + "/localcondition/" + id;
		Localcondition auto = rest.getForObject(url, Localcondition.class);
		return auto;
	}
	
	public void localDelete(long id) {
		String url = URL + "/localcondition/del/" + id;
		rest.delete(url);
	}
	
	// --- Precondition ---
	
	public List<Precondition> preconFindAll(){
		String url = URL + "/precondition/";
		System.out.println(url);
		Precondition[] auto = rest.getForObject(url, Precondition[].class);
		List<Precondition> result = Arrays.asList(auto);
		return result;
	}
	
	public void preconSave(Precondition autotran) {
		String url = URL + "/precondition/add-precondition";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		url = builder.toUriString();
		
		HttpEntity<Precondition> request = new HttpEntity<>(autotran);
		rest.postForObject(url, request, Precondition.class);
	}
	
	public void preconEdit(Precondition autotran) {
		String url = URL + "/precondition/edit/" + autotran.getPreconId();
		rest.put(url, autotran, Precondition.class);
	}
	
	public Precondition preconFinById(long id) {
		String url = URL + "/precondition/" + id;
		Precondition auto = rest.getForObject(url, Precondition.class);
		return auto;
	}
	
	public void preconDelete(long id) {
		String url = URL + "/precondition/del/" + id;
		rest.delete(url);
	}
	
	// --- Threshold ---
	
	public List<Threshold> thresFindAll(){
		String url = URL + "/threshold/";
		System.out.println(url);
		Threshold[] auto = rest.getForObject(url, Threshold[].class);
		List<Threshold> result = Arrays.asList(auto);
		return result;
	}
	
	public void thresSave(Threshold autotran) {
		String url = URL + "/threshold/add-threshold";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		url = builder.toUriString();
		
		HttpEntity<Threshold> request = new HttpEntity<>(autotran);
		rest.postForObject(url, request, Threshold.class);
	}
	
	public void thresEdit(Threshold autotran) {
		String url = URL + "/threshold/edit/" + autotran.getThresId();
		rest.put(url, autotran, Threshold.class);
	}
	
	public Threshold thresFinById(long id) {
		String url = URL + "/threshold/" + id;
		Threshold auto = rest.getForObject(url, Threshold.class);
		return auto;
	}
	
	public void thresDelete(long id) {
		String url = URL + "/threshold/del/" + id;
		rest.delete(url);
	}
	
}
