package com.lams.api.service.impl.loan;

import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lams.api.domain.loan.LoanAgainstSecuritiesLoanDetails;
import com.lams.api.repository.ApplicationsRepository;
import com.lams.api.repository.loan.LoanAgainstSecuritiesLoanDetailsRepository;
import com.lams.api.repository.master.ApplicationTypeMstrRepository;
import com.lams.api.repository.master.LoanTypeMstrRepository;
import com.lams.api.service.loan.LoanAgainstSecuritiesLoanDetailsService;
import com.lams.model.loan.bo.LoanAgainstSecuritiesLoanDetailsBO;
import com.lams.model.utils.CommonUtils;
import com.lams.model.utils.CommonUtils.ApplicationType;
import com.lams.model.utils.CommonUtils.ApplicationTypeCode;

@Service
@Transactional
public class LoanAgainstSecuritiesLoanDetailsServiceImpl implements LoanAgainstSecuritiesLoanDetailsService {

	public static final Logger logger = Logger.getLogger(LoanAgainstSecuritiesLoanDetailsServiceImpl.class);

	@Autowired
	private LoanAgainstSecuritiesLoanDetailsRepository repository;
	
	@Autowired
	private LoanTypeMstrRepository loanTypeMstrRepository;
	
	@Autowired
	private ApplicationTypeMstrRepository applicationTypeMstrRepository;
	
	@Autowired 
	private ApplicationsRepository applicationsRepository;

	@Override
	public Long save(LoanAgainstSecuritiesLoanDetailsBO requestLoanDetailsBO) {
		LoanAgainstSecuritiesLoanDetails domainObj = null;
		if(!CommonUtils.isObjectNullOrEmpty(requestLoanDetailsBO.getId())) {
			domainObj = repository.findByIdAndIsActive(requestLoanDetailsBO.getId(), true);
		}
		if(CommonUtils.isObjectNullOrEmpty(domainObj)) {
			domainObj = new LoanAgainstSecuritiesLoanDetails();
			domainObj.setCreatedBy(requestLoanDetailsBO.getUserId());
			domainObj.setCreatedDate(new Date());
			domainObj.setIsActive(true);
			
			if(!CommonUtils.isObjectNullOrEmpty(requestLoanDetailsBO.getIsFromCP()) && requestLoanDetailsBO.getIsFromCP()) {
				//requestLoanDetailsBO.getLeadReferenceNo() Property Contains Code of Channel Partner
				String lastLeadReferenceNo = applicationsRepository.getLastLeadReferenceNoForCP(Long.valueOf(ApplicationType.LOAN_AGAINST_SECURITIS),requestLoanDetailsBO.getLeadReferenceNo());
				domainObj.setLeadReferenceNo(CommonUtils.generateRefNoFromCP(ApplicationTypeCode.LOAN_AGAINST_SECURITIS, lastLeadReferenceNo,requestLoanDetailsBO.getLeadReferenceNo()));
			}else {
				String lastLeadReferenceNo = applicationsRepository.getLastLeadReferenceNo(Long.valueOf(ApplicationType.LOAN_AGAINST_SECURITIS));
				domainObj.setLeadReferenceNo(CommonUtils.generateRefNo(ApplicationTypeCode.LOAN_AGAINST_SECURITIS, lastLeadReferenceNo));				
			}
			domainObj.setUserId(requestLoanDetailsBO.getUserId());
		} else {
			domainObj.setModifiedBy(requestLoanDetailsBO.getUserId());
			domainObj.setModifiedDate(new Date());
		}
		BeanUtils.copyProperties(requestLoanDetailsBO, domainObj,CommonUtils.skipFieldsForCreateApp);
		if(!CommonUtils.isObjectNullOrEmpty(requestLoanDetailsBO.getApplicationTypeId())) {
			domainObj.setApplicationTypeId(applicationTypeMstrRepository.findOne(requestLoanDetailsBO.getApplicationTypeId()));
		}
		if(!CommonUtils.isObjectNullOrEmpty(requestLoanDetailsBO.getLoanTypeId())) {
			domainObj.setLoanTypeId(loanTypeMstrRepository.findOne(requestLoanDetailsBO.getLoanTypeId()));
		}
		domainObj.setIsFromCP(requestLoanDetailsBO.getIsFromCP());
		domainObj = repository.save(domainObj);
		return domainObj.getId();
	}
	
	@Override
	public LoanAgainstSecuritiesLoanDetailsBO get(Long id) {
		LoanAgainstSecuritiesLoanDetails loanDetails = repository.findByIdAndIsActive(id, true);
		LoanAgainstSecuritiesLoanDetailsBO response = new LoanAgainstSecuritiesLoanDetailsBO();
		if(!CommonUtils.isObjectNullOrEmpty(loanDetails)) {
			BeanUtils.copyProperties(loanDetails, response);
			if(!CommonUtils.isObjectNullOrEmpty(loanDetails.getApplicationTypeId())) {
				response.setApplicationTypeId(loanDetails.getApplicationTypeId().getId());
				response.setApplicationTypeName(loanDetails.getApplicationTypeId().getName());	
			}
			if(!CommonUtils.isObjectNullOrEmpty(loanDetails.getLoanTypeId())) {
				response.setLoanTypeId(loanDetails.getLoanTypeId().getId());
				response.setLoanTypeName(loanDetails.getLoanTypeId().getName());	
			}
		}
		return response;
	}
}


