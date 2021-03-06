package com.group.approval.service;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.approval.dao.DocsWriteDAO;
import com.group.approval.dao.ProcessDocsDAO;
import com.group.approval.dto.Agreement;
import com.group.approval.dto.Approval;
import com.group.approval.dto.Reference;
import com.group.employee.dto.Employee;
import com.group.exception.FindException;
import com.group.exception.ModifyException;
import com.group.exception.UpdateException;

@Service
public class ProcessDocsService {
	@Autowired
	private ProcessDocsDAO dao;

	
	/**
	 * 참조자의 참조 승인 (Refrence-참조)
	 * @param R
	 * @throws UpdateException
	 */
	public void decisionMyRe(Reference re) throws UpdateException{
		dao.updateReference(re);
	}
	
	
	/**
	 * 승인, 반려를 선택하고 원하면 코멘트도 추가(Approval-결재용)
	 * @param ap
	 * @throws UpdateException
	 */
	public void decisionMyAp(Approval ap,String status) throws UpdateException{
		if(status.equals("audmit")) {
			dao.updateAudmitAp(ap);
		}else if(status.equals("refuse")) {
			dao.updateRefuseAp(ap);
		}
	}
	/**
	 * 승인, 반려를 선택하고 원하면 코멘트도 추가(Agreement-합의용)
	 * @param ag
	 * @throws UpdateException
	 */
	public void decisionMyAg(Agreement ag,String status) throws UpdateException{
		if(status.equals("audmit")) {
			dao.updateAudmitAg(ag);
		}else if(status.equals("refuse")) {
			dao.updateRefuseAg(ag);
		}
	}

//	/**
//	 * 결재자 전원이 승인 처리 시, 문서 상태 승인으로
//	 * @param document_no, id
//	 * @throws ModifyException
//	 */
//	public void FinalAudmit(String document_no,String id) throws ModifyException{
//		dao.documentAudmit(document_no, id);
//	}
//	/**
//	 * 결재자 중 한명이라도 반려 처리 시, 문서 상태 반려로
//	 * @param document_no, id
//	 * @throws ModifyException
//	 */
//	public void FinalRefuse(String document_no,String id) throws ModifyException{
//		dao.documentRefuse(document_no, id);
//	}
}
