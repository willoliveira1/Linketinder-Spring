package br.com.linketinder.auxiliar.service.interfaces;

import br.com.linketinder.auxiliar.domain.entity.Benefit;
import java.util.List;
import java.util.Optional;

public interface IBenefitService {

    List<Benefit> getAllBenefits();
    Optional<Benefit> getBenefitById(int id);
    Benefit createBenefit(Benefit benefit);
    Benefit updateBenefit(int id, Benefit benefitDetails);
    void deleteBenefit(int id);

}
