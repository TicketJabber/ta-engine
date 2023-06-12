package engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class WeightController {

	private final WeightService weightService;

	@Autowired
	public WeightController(WeightService weightService) {
		this.weightService = weightService;
	}

	@PostMapping("/weight")
	public ResponseEntity<WeightResponse> calculateWeight(@RequestBody WeightRequest weightRequest) {

		return new ResponseEntity<>(this.weightService.calculateWeight(weightRequest), HttpStatus.OK);
	}
}
