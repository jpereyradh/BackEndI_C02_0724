package C2_BackendI.HolaMundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //que no voy a necesitar en este caso una tecnologia de vista
public class HolaMundoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolaMundoApplication.class, args);
	}
	//para poder comunicar necesita http
	@GetMapping("/1")
	public String saludo1(){
		return "Bienvenidos a Backend I";
	}@GetMapping("/2")
	public String saludo2(){
		return "Bienvenidos a Camada 2";
	}

}
