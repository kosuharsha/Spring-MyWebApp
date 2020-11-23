package net.code.java.MyWebApp;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class MyWebAppApplication {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
	@RequestMapping("/")
	String home() {
		return "<html><body><button type='button' onclick=\"fetch('/new', {\n" + 
				"  method: 'GET',\n" + 				
				"})"
				+ ".then(res=>{res.text().then(text=>{document.write(text);})})\">Hellow World Spring Boot!</button></body></html>";
	}
	//onclick=\"document.write('Harsha')\"
	@RequestMapping("/new")
	String newForm()
	{
		return "New Thing";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/second")
	String secondHome()
	{
		return "second";
	}
	
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
	public static void main(String[] args) {
		SpringApplication.run(MyWebAppApplication.class, args);
	}

}
