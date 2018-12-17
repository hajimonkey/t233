package com.bdqn.pojo;

public class AppInfoPage extends AppInfo{
	private int startIndex;
	private int rows = 5;
	private int pageNow = 1;//当前页码
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getStartIndex() {
		return (pageNow-1)*rows;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
}
