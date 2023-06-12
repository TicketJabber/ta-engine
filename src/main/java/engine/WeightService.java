package engine;

import org.springframework.stereotype.Service;

@Service
public interface WeightService {
    WeightResponse calculateWeight(WeightRequest weightRequest);
}
