package menu.bo.contractDetailBo;

import menu.dao.contractDetailDao.ContractDetailDao;
import menu.dao.contractDetailDao.IContractDetailDao;
import menu.model.ContractDetail;

public class ContractDetailBo implements IContractDetailBo {
    IContractDetailDao iContractDetailDao = new ContractDetailDao();

    @Override
    public void insertContractDetail(ContractDetail contractDetail) {
        iContractDetailDao.insertContractDetail(contractDetail);
    }
}
