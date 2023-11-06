package br.com.linketinder.auxiliar.service;

import br.com.linketinder.auxiliar.domain.entity.Benefit;
import br.com.linketinder.auxiliar.domain.repository.BenefitRepository;
import br.com.linketinder.auxiliar.exception.BenefitNotFoundException;
import br.com.linketinder.auxiliar.service.interfaces.IBenefitService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BenefitService implements IBenefitService {

    private final BenefitRepository repository;

    public BenefitService(BenefitRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Benefit> getAllBenefits() {
        return repository.findAll();
    }

    @Override
    public Optional<Benefit> getBenefitById(int id) {
        return repository.findById(id);
    }

    @Override
    public Benefit createBenefit(Benefit benefit) {
        return repository.save(benefit);
    }

    @Override
    public Benefit updateBenefit(int id, Benefit benefitDetails) {
        Optional<Benefit> benefit = repository.findById(id);

        if (benefit.isPresent()) {
            Benefit existedBenefit = benefit.get();
            existedBenefit.setTitle(benefitDetails.getTitle());
            return repository.save(existedBenefit);
        }
        return null;
    }

    @Override
    public void deleteBenefit(int id) {
        Optional<Benefit> benefit = repository.findById(id);

        if (benefit.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new BenefitNotFoundException();
        }
    }

}
