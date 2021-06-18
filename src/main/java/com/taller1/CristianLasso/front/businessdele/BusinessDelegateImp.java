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

import com.taller1.CristianLasso.front.model.Autotransition;
import com.taller1.CristianLasso.front.model.FevInstitution;
import com.taller1.CristianLasso.front.model.Localcondition;
import com.taller1.CristianLasso.front.model.Precondition;
import com.taller1.CristianLasso.front.model.Symptom;
import com.taller1.CristianLasso.front.model.Symptompoll;
import com.taller1.CristianLasso.front.model.Symptomquestion;
import com.taller1.CristianLasso.front.model.Threshold;

@Component
public class BusinessDelegateImp implements BusinessDelegate{

	public static final String URL = "http://localhost:8080/admin";
	
	private RestTemplate rest;
	
	public BusinessDelegateImp() {
		this.rest = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.rest.setMessageConverters(messageConverters);
	}
	
	// --- Autotransition ---
	
	@Override
	public List<Autotransition> autotranFindAll(){
		String url = URL + "/autotransition/";
		System.out.println(url);
		Autotransition[] auto = rest.getForObject(url, Autotransition[].class);
		List<Autotransition> result = Arrays.asList(auto);
		return result;
	}
	
	@Override
	public void autotranSave(Autotransition autotran) {
		String url = URL + "/autotransition/";
		rest.postForObject(url, autotran, Autotransition.class);
	}
	
	@Override
	public void autotranEdit(Autotransition autotran) {
		String url = URL + "/autotransition/edit/";
		rest.put(url, autotran, Autotransition.class);
	}
	
	@Override
	public Autotransition autotranFinById(long id) {
		String url = URL + "/autotransition/" + id;
		Autotransition auto = rest.getForObject(url, Autotransition.class);
		return auto;
	}
	
	@Override
	public void autotranDelete(long id) {
		String url = URL + "/autotransition/del/" + id;
		rest.delete(url);
	}
	
	// --- FevInstitution ---
	
	@Override
	public List<FevInstitution> instiFindAll(){
		String url = URL + "/fevInstitution/";
		System.out.println(url);
		FevInstitution[] auto = rest.getForObject(url, FevInstitution[].class);
		List<FevInstitution> result = Arrays.asList(auto);
		return result;
	}
	
	@Override
	public void instiSave(FevInstitution autotran) {
		String url = URL + "/fevInstitution/";
		rest.postForObject(url, autotran, FevInstitution.class);
	}
	
	@Override
	public void instiEdit(FevInstitution autotran) {
		String url = URL + "/fevInstitution/";
		rest.put(url, autotran, FevInstitution.class);
	}
	
	@Override
	public FevInstitution instiFinById(long id) {
		String url = URL + "/fevInstitution/" + id;
		FevInstitution auto = rest.getForObject(url, FevInstitution.class);
		return auto;
	}
	
	@Override
	public void instiDelete(long id) {
		String url = URL + "/fevInstitution/del/" + id;
		rest.delete(url);
	}
	
	// --- Localcondition ---
	
	@Override
	public List<Localcondition> localFindAll(){
		String url = URL + "/localcondition/";
		System.out.println(url);
		Localcondition[] auto = rest.getForObject(url, Localcondition[].class);
		List<Localcondition> result = Arrays.asList(auto);
		return result;
	}
	
	@Override
	public void localSave(Localcondition autotran) {
		String url = URL + "/localcondition/";
		rest.postForObject(url, autotran, Localcondition.class);
	}
	
	@Override
	public void localEdit(Localcondition autotran) {
		String url = URL + "/localcondition/";
		rest.put(url, autotran, Localcondition.class);
	}
	
	@Override
	public Localcondition localFinById(long id) {
		String url = URL + "/localcondition/" + id;
		Localcondition auto = rest.getForObject(url, Localcondition.class);
		return auto;
	}
	
	@Override
	public void localDelete(long id) {
		String url = URL + "/localcondition/del/" + id;
		rest.delete(url);
	}
	
	// --- Precondition ---
	
	@Override
	public List<Precondition> preconFindAll(){
		String url = URL + "/precondition/";
		System.out.println(url);
		Precondition[] auto = rest.getForObject(url, Precondition[].class);
		List<Precondition> result = Arrays.asList(auto);
		return result;
	}
	
	@Override
	public void preconSave(Precondition autotran) {
		String url = URL + "/precondition/";
		rest.postForObject(url, autotran, Precondition.class);
	}
	
	@Override
	public void preconEdit(Precondition autotran) {
		String url = URL + "/precondition/";
		rest.put(url, autotran, Precondition.class);
	}
	
	@Override
	public Precondition preconFinById(long id) {
		String url = URL + "/precondition/" + id;
		Precondition auto = rest.getForObject(url, Precondition.class);
		return auto;
	}
	
	@Override
	public void preconDelete(long id) {
		String url = URL + "/precondition/del/" + id;
		rest.delete(url);
	}
	
	// --- Threshold ---
	
	@Override
	public List<Threshold> thresFindAll(){
		String url = URL + "/threshold/";
		System.out.println(url);
		Threshold[] auto = rest.getForObject(url, Threshold[].class);
		List<Threshold> result = Arrays.asList(auto);
		return result;
	}
	
	@Override
	public void thresSave(Threshold autotran) {
		String url = URL + "/threshold/";
		rest.postForObject(url, autotran, Threshold.class);
	}
	
	@Override
	public void thresEdit(Threshold autotran) {
		String url = URL + "/threshold/";
		rest.put(url, autotran, Threshold.class);
	}
	
	@Override
	public Threshold thresFinById(long id) {
		String url = URL + "/threshold/" + id;
		Threshold auto = rest.getForObject(url, Threshold.class);
		return auto;
	}
	
	@Override
	public void thresDelete(long id) {
		String url = URL + "/threshold/del/" + id;
		rest.delete(url);
	}
	
	// --- Symptom ---
	
	@Override
	public List<Symptom> symptomFindAll(){
		String url = URL + "/symptom/";
		System.out.println(url);
		Symptom[] auto = rest.getForObject(url, Symptom[].class);
		List<Symptom> result = Arrays.asList(auto);
		return result;
	}
	
	@Override
	public void symptomSave(Symptom autotran) {
		String url = URL + "/symptom/";
		rest.postForObject(url, autotran, Symptom.class);
	}
	
	@Override
	public void symptomEdit(Symptom autotran) {
		String url = URL + "/symptom/";
		rest.put(url, autotran, Symptom.class);
	}
	
	@Override
	public Symptom symptomFinById(long id) {
		String url = URL + "/symptom/" + id;
		Symptom auto = rest.getForObject(url, Symptom.class);
		return auto;
	}
	
	@Override
	public void symptomDelete(long id) {
		String url = URL + "/symptom/del/" + id;
		rest.delete(url);
	}
	
	// --- Symptompoll ---
	
		@Override
		public List<Symptompoll> symptompollFindAll(){
			String url = URL + "/symptompoll/";
			System.out.println(url);
			Symptompoll[] auto = rest.getForObject(url, Symptompoll[].class);
			List<Symptompoll> result = Arrays.asList(auto);
			return result;
		}
		
		@Override
		public void symptompollSave(Symptompoll autotran) {
			String url = URL + "/symptompoll/";
			rest.postForObject(url, autotran, Symptompoll.class);
		}
		
		@Override
		public void symptompollEdit(Symptompoll autotran) {
			String url = URL + "/symptompoll/";
			rest.put(url, autotran, Symptompoll.class);
		}
		
		@Override
		public Symptompoll symptompollFinById(long id) {
			String url = URL + "/symptompoll/" + id;
			Symptompoll auto = rest.getForObject(url, Symptompoll.class);
			return auto;
		}
		
		@Override
		public void symptompollDelete(long id) {
			String url = URL + "/symptompoll/del/" + id;
			rest.delete(url);
		}
		
		// --- Symptomquestion ---
		
		@Override
		public List<Symptomquestion> symptomquestionFindAll(){
			String url = URL + "/symptomquestion/";
			System.out.println(url);
			Symptomquestion[] auto = rest.getForObject(url, Symptomquestion[].class);
			List<Symptomquestion> result = Arrays.asList(auto);
			return result;
		}
		
		@Override
		public void symptomquestionSave(Symptomquestion autotran) {
			String url = URL + "/symptomquestion/";
			rest.postForObject(url, autotran, Symptomquestion.class);
		}
		
		@Override
		public void symptomquestionEdit(Symptomquestion autotran) {
			String url = URL + "/symptomquestion/";
			rest.put(url, autotran, Symptomquestion.class);
		}
		
		@Override
		public Symptomquestion symptomquestionFinById(long id) {
			String url = URL + "/symptomquestion/" + id;
			Symptomquestion auto = rest.getForObject(url, Symptomquestion.class);
			return auto;
		}
		
		@Override
		public void symptomquestionDelete(long id) {
			String url = URL + "/symptomquestion/del/" + id;
			rest.delete(url);
		}
	
}
