package com.umai.common.template;

import com.umai.common.model.vo.PageInfo;

public class Pagenation {
	
	public static PageInfo getPageInfo(int listCount, int currentPage, int pageLimit , int boardLimit ) {
		
		int maxPage = (int)Math.ceil((double)listCount / boardLimit); // 가장 마지막페이지(총 페이지의 수)
		int startPage = ((currentPage-1) / pageLimit)*pageLimit + 1; // 페이징 바의 시작 수
		int endPage = startPage + pageLimit - 1; // 페이징바의 끝 수
				

		endPage = endPage > maxPage ? maxPage : endPage;
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		

		return pi;
	}
}
