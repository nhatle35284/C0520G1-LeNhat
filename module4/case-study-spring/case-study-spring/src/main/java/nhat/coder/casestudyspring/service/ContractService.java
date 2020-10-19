package nhat.coder.casestudyspring.service;

import nhat.coder.casestudyspring.model.Contract;
import nhat.coder.casestudyspring.model.Employee;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();

    void save(Contract contract);

    Contract findById(String id);

    void update(Contract contract);

    void remove(String id);
}
