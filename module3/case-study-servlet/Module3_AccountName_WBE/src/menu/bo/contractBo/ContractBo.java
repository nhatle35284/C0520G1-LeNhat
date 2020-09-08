package menu.bo.contractBo;

import menu.dao.contractDao.ContractDao;
import menu.dao.contractDao.IContractDao;
import menu.model.Contract;

public class ContractBo implements IContractBo {
    IContractDao iContractDao = new ContractDao();

    @Override
    public void insertContract(Contract contract) {
        iContractDao.insertContract(contract);
    }
}
