package com.cts.company.service;

import java.text.SimpleDateFormat;

import javax.transaction.Transactional;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cts.company.entity.StockPrice;
import com.cts.company.repo.StockPriceRepo;

@Service
public class ImportServiceImpl implements ImportService {

	@Autowired
	StockPriceRepo stockPriceRepo;

	@Transactional
	@Override
	public String addStockPrice(MultipartFile readExcelFile) {
//		List<StockPrice> stockPriceList = new ArrayList<StockPrice>();
		String timeStamp = null;
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(readExcelFile.getInputStream());
			XSSFSheet sheet = workbook.getSheetAt(0);
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				StockPrice stockPrice = new StockPrice();
				XSSFRow row = sheet.getRow(i);
				stockPrice.setCompCode((int) Double.parseDouble(row.getCell(0).toString()));
				stockPrice.setStockExchangeName(row.getCell(1).toString());
				stockPrice.setCurrentPrice(Double.parseDouble(String.valueOf(row.getCell(2))));
				stockPrice.setDate(row.getCell(3).toString());
//				stockPrice.setTime(row.getCell(4).toString());
//				System.out.println(stockPrice);
				SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				if (row.getCell(4).toString().contains("31-Dec-1899")) {
					timeStamp = format.format(row.getCell(4).getDateCellValue());
					System.out.println("TImeStamp "+timeStamp );
				}
				stockPrice.setTime(timeStamp);
				stockPriceRepo.save(stockPrice);
			}
			workbook.close();
			return "added";
		} catch (Exception exception) {
			return "error";
		}

	}
}
