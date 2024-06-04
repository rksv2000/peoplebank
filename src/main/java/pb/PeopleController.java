package pb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class PeopleController {
	@Autowired
	private PeopleRepository pr;
	
	@PostMapping
	public People savePeople(@RequestBody People people) {
		people.setBank(people.getBank());
		return pr.save(people);
	}
	
	@GetMapping
	public Page<People> getAllPeople(@PageableDefault(sort="id", direction=Sort.Direction.ASC) Pageable pageable) {
		return pr.findAll(pageable);
	}
	
	@GetMapping("/{id}")
	public People getPeople(@PathVariable("id") int id) {
		Optional<People> people = pr.findById(id);
		return people.orElse(null);
	}
	
	@PutMapping("/{id}")
	public People updatePeople(@PathVariable("id") int id, @RequestBody People people) {
		Optional<People> epeople = pr.findById(id);
		if(epeople.isPresent()) {
			People opeople = epeople.get();
			opeople.setFirstname(people.getFirstname());
			opeople.setLastname(people.getLastname());
			opeople.setBirthdate(people.getBirthdate());
			opeople.setBank(people.getBank());
			return pr.save(opeople);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public String deletePeople(@PathVariable("id") int id) {
		if(pr.findById(id).isPresent()) {
			pr.deleteById(id);
			People p = new People();
			p.setBank(null);		
			return "People Deleted";
		}
		return "No Such People";
	}
}
