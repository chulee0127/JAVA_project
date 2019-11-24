package org.kpu.ticketbox.payment;

public class MovieTicket {
	
	public static final char SEAT_EMPTY_MARK = '-';
	public static final char SEAT_RESERVED_MARK = 'R';
	public static final char SEAT_PAY_COMPLETION_MARK = '$';
	
	private int nRow; // 좌석 행
	private int nCol; // 좌석 열
	private char cStatus; // 좌석 상태 - EMPTY, RESERVED, PAY_COMPLETION
	
	private int nReservedId; // 예약 번호
	
	public void setnReservedId(int id) { // 예약번호저장
		this.nReservedId = id;
	}
	
	public int getnReservedId( ) {   // 예약번호 읽기
		return nReservedId;
	}
	
	public void setcStatus(char cStatus) { // 좌석 상태 변경
		this.cStatus = cStatus;
	}
	
	public char getcStatus() {
		return cStatus;
	}
	
	public void setSeat(int col, int row) { // 좌석번호저장
		this.nCol = col;
		this.nRow = row;
	}
	
	public int getRow() { // 추가기능 2번에서 사용
		return nRow;
	}
	
	public int getCol() { // 추가기능 2번에서 사용
		return nCol;
	}
	
}