package com.taller1.CristianLasso;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import com.taller1.CristianLasso.back.model.Autotransition;
import com.taller1.CristianLasso.back.model.FevInstitution;
import com.taller1.CristianLasso.back.model.Localcondition;
import com.taller1.CristianLasso.back.model.Precondition;
import com.taller1.CristianLasso.back.model.Symptom;
import com.taller1.CristianLasso.back.model.Symptompoll;
import com.taller1.CristianLasso.back.model.Threshold;
import com.taller1.CristianLasso.back.model.Userr;
import com.taller1.CristianLasso.back.model.UserrType;
import com.taller1.CristianLasso.back.service.AutotransitionService;
import com.taller1.CristianLasso.back.service.FevInstitutionService;
import com.taller1.CristianLasso.back.service.LocalconditionService;
import com.taller1.CristianLasso.back.service.PreconditionService;
import com.taller1.CristianLasso.back.service.SymptomService;
import com.taller1.CristianLasso.back.service.SymptompollService;
import com.taller1.CristianLasso.back.service.ThresholdService;
import com.taller1.CristianLasso.back.service.UserrService;
import com.taller1.CristianLasso.front.businessdele.BusinessDelegate;
import com.taller1.CristianLasso.front.businessdele.BusinessDelegateImp;

@SpringBootApplication
public class Taller1Application {

	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}

	public static void main(String[] args) {
		//SpringApplication.run(Taller1Application.class, args);
		ApplicationContext app = SpringApplication.run(Taller1Application.class, args);
		BusinessDelegateImp businessDel = app.getBean(BusinessDelegateImp.class);
	}
	
	

	@Bean
	public CommandLineRunner dummy(UserrService usService, FevInstitutionService instService, PreconditionService preconService, AutotransitionService autotranService, LocalconditionService localService, ThresholdService thresService, SymptomService sympService, SymptompollService sympollService) {
		return (args) -> {
			Userr us1 = new Userr();
			us1.setUserName("user1");
			us1.setType(UserrType.admin);
			us1.setUserPassword("{noop}user1contra");
			usService.save(us1);

			Userr us2 = new Userr();
			us2.setUserName("user2");
			us2.setType(UserrType.operator);
			us2.setUserPassword("{noop}user2contra");
			usService.save(us2);
			
			FevInstitution inst = new FevInstitution();
			inst.setInstName("Insti");
			instService.save(inst);
			
			Autotransition autotran = new Autotransition();
			autotran.setAutotranName("Autotran");
			autotran.setInstInstId(inst.getInstId());
			autotran.setAutotranLogicaloperand("AND");
			autotran.setAutotranIsactive("Y");
			autotranService.save(autotran);
			
			Precondition precon = new Precondition();
			precon.setPreconLogicaloperand("OR");
			//precon.setAutotransition(autotran);
			preconService.save(precon);
			
			Threshold thres = new Threshold();
			thres.setThresName("Thres");
			thres.setThresValue("Val");
			thres.setInstInstId(inst.getInstId());
			thresService.save(thres);
			
			Localcondition local = new Localcondition();
			local.setLoconOperator("==");
			local.setLoconTablename("Local");
			//local.setPrecondition(precon);
			//local.setThreshold(thres);
			localService.save(local);
			
			Symptom symp = new Symptom();
			symp.setSympName("Symptom");
			symp.setSympIsactive("Y");
			sympService.save(symp);
			
			Symptompoll sympoll = new Symptompoll();
			sympoll.setSympollName("Sympoll");
			sympollService.save(sympoll);

		};
	}


}
