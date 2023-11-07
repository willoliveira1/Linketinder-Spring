package br.com.linketinder.auxiliar.controller;

import br.com.linketinder.auxiliar.domain.entity.Benefit;
import br.com.linketinder.auxiliar.exception.BenefitNotFoundException;
import br.com.linketinder.auxiliar.service.interfaces.IBenefitService;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/beneficios")
public class BenefitController {

    private final IBenefitService service;

    public BenefitController(IBenefitService service) {
        this.service = service;
    }

    @GetMapping
    public List<Benefit> getAll() {
        return service.getAllBenefits();
    }

    @GetMapping("{id}")
    public Benefit getById(@PathVariable Integer id) {
        return service
                .getBenefitById(id)
                .orElseThrow(BenefitNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Benefit createBenefit(@RequestBody @Valid Benefit benefit) {
        return service.createBenefit(benefit);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid Benefit benefit) {
        Benefit existedBenefit = service.updateBenefit(id, benefit);

        if (existedBenefit == null) {
            throw new BenefitNotFoundException();
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        try {
            service.deleteBenefit(id);
        } catch (BenefitNotFoundException e) {
            throw new BenefitNotFoundException();
        }
    }

}
