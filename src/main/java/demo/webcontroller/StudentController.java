package demo.webcontroller;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.bean.Book;
import demo.bean.Student;
import demo.service.StudentService;

@Controller
public class StudentController {
	@Value(value = "${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;
	@Autowired
	private Book book;
	@Resource
	private StudentService studentService;
	@Resource
	private List<String> names;
//	@RequestMapping("/")
//	@ResponseBody
//	String home() {
//		System.out.println(bookAuthor+":"+bookName);
//		System.out.println(book.getAuthor()+":"+book.getName()+":"+book.getPrice());
//		return "Hello World";
//	}
	@RequestMapping("/spring")
	@ResponseBody
	String spring(){
		List<Student> stus=studentService.findAll();
		return stus.get(0).getId()+","+stus.get(0).getName();
	}
	@RequestMapping("/meng/{name}")
	@ResponseBody
	String hellname(@PathVariable String name){
		return "Hello "+name;
	}
	@ResponseBody
	@RequestMapping("/bean")
	String getBean(){
		return names.get(0);
	}
	@RequestMapping("/web")
	String web(){
		return "index";
	}
	@RequestMapping("/login")
	String tologin(){
		return "login";
	}
	@RequestMapping("/home")
	String home(){
		return "home";
	}
	@RequestMapping("/hello")
	String hello(){
		return "hello";
	}
}
