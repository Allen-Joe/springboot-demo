package com.plateno.common.pager;

import java.util.List;

public class Pager<T> {
	
	private int pageNo=1;      //当前页数
	private int pageSize=5;    //每页显示的最大记录数
	private int startIndex;  //每页的起始行数
	private int rowCount;    //总记录数
	private List<T> resultList; //要显示的记录集合

	public Pager() {
		// TODO Auto-generated constructor stub
	}
	
	public Pager(int pageNo, int pageSize,int rowCount,
			List<T> resultList) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.startIndex=this.pageSize*(this.pageNo-1);
		this.rowCount = rowCount;
		this.resultList = resultList;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	
}
