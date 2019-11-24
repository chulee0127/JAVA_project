package org.kpu.ticketbox.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.kpu.ticketbox.payment.Receipt;

public class BackupWriter {
	
	// c:\\temp\\receipt.txt 파일에 전체 스크린 매출 영수증 출력하기
	public void backupFile(String filename, HashMap<Integer, Receipt> map) {
		
		try {
			BufferedWriter bWrite = new BufferedWriter(new FileWriter("c:\\temp\\receipt.txt", true));
			PrintWriter pWrite = new PrintWriter(bWrite, true);
			
			for (int ReservedId : map.keySet()) {

				Receipt receipt = map.get(ReservedId);
				
				pWrite.write("\nclient=" + receipt.getClient());
				pWrite.write(", productName=" + receipt.getProductName());
				pWrite.write(", payMethod=" +receipt.getPayMethod());
				pWrite.print(", subTotalAmount=" + receipt.getSubTotalAmount());
				pWrite.print(", totalAmount=" + receipt.getTotalAmount());
			}

			pWrite.flush();
			pWrite.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일 경로를 찾을 수 없습니다");
		} catch (IOException e) {
			System.out.println("파일 복사 오류");
		}
		
		System.out.println(filename + " 매출 백업 완료");
	}
	
}