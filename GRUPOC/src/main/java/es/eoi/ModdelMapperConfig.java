package es.eoi;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModdelMapperConfig {

	@Bean
	public ModelMapper modelMapperBean(){
		return new ModelMapper();
	}
	
}
