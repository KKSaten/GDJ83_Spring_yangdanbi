package com.winter.app.util;

public class Pager {
	// 컬럼종류
	private String kind;
	// 검색어
	private String search;
	private Long startRow;
	private Long lastRow;
	private Long page;

	// ---------------------
	private Long startNum;
	private Long lastNum;
	private boolean pre;
	private boolean next;

	private Long perPage = 10L;

	// rowNum을 계산하는 메서드
	public void makeRow() throws Exception {

		this.startRow = (this.getPage() - 1) * perPage + 1;
		this.lastRow = this.page * perPage;

	}

	// 페이징 처리 하는 메서드
	public void makeNum(long totalCount) throws Exception {

		// 1. 총갯수를 이용해서 총 페이지수 구하기
		long totalPage = totalCount / perPage;
		// 나머지가 0이 아니면 페이지를 1증가해서 모든 데이터를 보여줌
		if (totalCount % perPage != 0) {
			// totalPage = totalCount / perPage + 1;
			totalPage++;
		}

		System.out.println("test perPage " + perPage);
		System.out.println("test page " + page);

//
//		List<Long> ar = new ArrayList<Long>();
//
//		// ar.add(perPage);
//		ar.add(startRow);
//		ar.add(lastRow);

//		pager.setLastRow(page);
		// 2. 총 페이지 수로 총 블럭수 구하기
		long perBlock = 5L; // 한페이지에 보여질 페이번호의 갯수
		long totalBlock = 0; // 총 블럭의 수

		totalBlock = totalPage / perBlock;

		if (totalPage % perBlock != 0) {
			totalBlock++;
		}

		// 3. 현재 페이지 번호로 현재블럭 번호를 구하기
		// page 1 2 3 4 5 6 10 11
		// 블럭번호 1 1 1 1 1 2 2 3
		long curBlock = 0;
		curBlock = page / perBlock;

		if (page % perBlock != 0) {
			curBlock++;
		}

		// 4. 현재 블럭 번호로 시작번호와 끝 번호 구하기

		// curBLock 1 2 3 4
		// start 1 6 11 16
		// last 5 10 15 20
		this.startNum = (curBlock - 1) * perBlock + 1;
		this.lastNum = curBlock * perBlock;

		// page 1 2 3 4 5 6 7 10
		// start 1 1 1 1 1 6 6 6
		// last 5 5 5 5 5 10 10 10

		// 5. 이전블럭, 다음 블럭 유무 판단
		this.pre = true; // true면 이전블럭이 존재, false면 이전블럭이 존재x
		this.next = true;
		if (curBlock == 1) {
			pre = false;
		}
		if (curBlock == totalBlock) {// 현재 블럭이 마지막 블럭이라면
			next = false;
			lastNum = totalPage;
		}

		// map.put("totalPage", map.get("totalCount"));

	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if (this.search == null) {
			this.search = "";
		}

		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long stratRow) {
		this.startRow = stratRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getPage() {
		if (this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPerPage() {
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
}
