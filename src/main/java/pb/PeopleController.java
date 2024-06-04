package pb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class PeopleController {
	@Autowired
	private PeopleRepo pr;
	
	@PostMapping
	public People savePeople(@RequestBody People people) {
		return pr.save(people);
	}
	
	@GetMapping
	public Page<People> getAllPeople(@PageableDefault(sort="person_id", direction=Sort.Direction.ASC) Pageable pageable) {
		return pr.findAll(pageable);
	}
	
	@GetMapping("/{id}")
	public People getPeople(@PathVariable("person_id") int id) {
		return pr.save(people);
	}
}
