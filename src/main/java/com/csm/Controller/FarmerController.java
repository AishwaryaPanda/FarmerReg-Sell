package com.csm.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.csm.Bean.BankDetailsBean;
import com.csm.Bean.CouchBean;
import com.csm.Bean.FarmerDataBean;
import com.csm.Bean.FarmerSellBean;
import com.csm.Bean.Status;
import com.csm.Bean.TransitPassBean;
import com.csm.Model.Farmer;
import com.csm.Model.FarmerSell;
import com.csm.Model.TransitPass;
import com.csm.Repository.CouchDBRepository;
import com.csm.Repository.FarmerRepository;
import com.csm.Repository.FarmerSellRepository;
import com.csm.Repository.TransitPassRepository;
import com.csm.Utils.AadharValidation;
import com.csm.Utils.FarmerCodeGeneration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

@RestController
@CrossOrigin(origins = "*")
public class FarmerController {

	@Autowired
	private FarmerRepository farmerRepository;
	@Autowired
	private FarmerSellRepository farmerSellRepository;
	@Autowired
	private TransitPassRepository transitPassRepository;

	@PostMapping(value = "/saveFarmer")
	public List<Farmer> saveFarmer(@RequestBody Farmer farmer) {
		List<Farmer> farmerList;
		try {
			int maxId;
			try {
				maxId = farmerRepository.maxSlno();
			} catch (Exception e) {
				maxId = 0;
			}
			String userCode = FarmerCodeGeneration.FarmerCodeGenreationMethod(maxId);
			farmer.setFarmerCode(userCode);
			farmerRepository.save(farmer);
			farmerList = farmerRepository.findAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return farmerList;
	}

	@GetMapping(value = "/getFarmerList")
	public List<Farmer> getFarmerList() {
		List<Farmer> farmerList = null;
		try {
			farmerList = farmerRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return farmerList;
	}

	@PostMapping(value = "/saveFarmerSell")
	public List<FarmerSell> saveFarmerSell(@RequestBody FarmerSellBean farmerSellBean) {
		List<FarmerSell> farmerSellList;
		try {
			Farmer farmer = farmerRepository.getFarmerById(farmerSellBean.getFarmer());

			FarmerSell farmerSell = new FarmerSell();
			farmerSell.setFarmer(farmer);
			farmerSell.setAmmount(farmerSellBean.getAmmount());
			farmerSell.setQty(farmerSellBean.getQty());
			farmerSell.setDate(farmerSellBean.getDate());

			farmerSellRepository.save(farmerSell);
			farmerSellList = farmerSellRepository.findAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return farmerSellList;
	}

	@PostMapping(value = "/saveTransitPass")
	public List<TransitPass> saveTransitPass(@RequestBody TransitPassBean transitPassBean) {
		List<TransitPass> transitPassList;
		try {
			Farmer farmer = farmerRepository.getFarmerById(transitPassBean.getFarmer());
			FarmerSell farmerSell = farmerSellRepository.getFarmerSellByDateAndFarmer(transitPassBean.getDate(),
					farmer);
			TransitPass transitPass = new TransitPass();
			transitPass.setFarmer(farmer);
			transitPass.setVehicleNo(transitPassBean.getVehicleNo());
			transitPass.setTransStatus(transitPassBean.getTransStatus());
			transitPass.setTransQty(transitPassBean.getTransQty());
			transitPass.setDate(transitPassBean.getDate());
			transitPass.setFarmerSell(farmerSell);
			transitPassRepository.save(transitPass);
			transitPassList = transitPassRepository.findAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return transitPassList;
	}

	@GetMapping("/getAllData")
	public List<TransitPass> getAll() {
		return transitPassRepository.getAllTransitPass();
	}

	@GetMapping("/getAllBeanData")
	public List<FarmerDataBean> name() {
		List<TransitPass> tp = transitPassRepository.getAllTransitPass();
		List<FarmerDataBean> beans = new ArrayList<FarmerDataBean>();
		for (TransitPass transitPass : tp) {
			System.out.println(transitPass.toString());
			FarmerDataBean fBean = new FarmerDataBean();
			fBean.setSellAmount(Double.toString(transitPass.getFarmerSell().getAmmount()));
			fBean.setSellId(Integer.toString(transitPass.getFarmerSell().getSellId()));
			fBean.setSellDate(dateFormat.format(transitPass.getFarmerSell().getDate()));
			fBean.setSellQuantity(Double.toString(transitPass.getFarmerSell().getQty()));
			fBean.setAadhaarNo(transitPass.getFarmer().getAadhar());
			fBean.setAccountNo(transitPass.getFarmer().getAccountNumber());
			fBean.setBankName(transitPass.getFarmer().getBankName());
			fBean.setBranchName(transitPass.getFarmer().getBranch());
			fBean.setFarmerCode(transitPass.getFarmer().getFarmerCode());
			fBean.setFarmerName(transitPass.getFarmer().getName());
			fBean.setIfscCode(transitPass.getFarmer().getIfscCode());
			fBean.setMobileNo(transitPass.getFarmer().getMobile());
			fBean.setTransitPassDate(dateFormat.format(transitPass.getDate()));
			fBean.setTransitPassId(Integer.toString(transitPass.getTransId()));
			fBean.setTransitPassQuant(Double.toString(transitPass.getTransQty()));
			fBean.setAcceptanceStatus(Integer.toString(transitPass.getTransStatus()));
			fBean.setVehicleNO(transitPass.getVehicleNo());
			fBean.setFamrerId(Long.toString(transitPass.getFarmer().getId()));
			beans.add(fBean);
		}
		return beans;
	}

	@GetMapping("/test")
	public String test() {
		String urlString = "http://localhost:8088/getAllBeanData";
		RestTemplate restTemplate = new RestTemplate();
		FarmerDataBean[] farmerDataBean = restTemplate.getForObject(urlString, FarmerDataBean[].class);
		for (FarmerDataBean bean : farmerDataBean) {
			System.out.println(bean.toString());
			new FarmerController().insertFarmer(bean);
		}
		return "Data-Inserted";
	}

	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

	@PostMapping("/saveFarmerInCouch")
	public String insertFarmer(@RequestBody FarmerDataBean farmerDataBean) {
//		System.out.println("*******************************************************");
//		System.out.println(farmerDataBean);
		// List<TransitPass> tp= transitPassRepository.getAllTransitPass();
		// System.out.println(tp);

			CouchBean fBean = new CouchBean();
			fBean.setSellAmount(farmerDataBean.getSellAmount());
			fBean.setAadhaarNo(farmerDataBean.getAadhaarNo());
			fBean.setAcceptanceStatus(farmerDataBean.getAcceptanceStatus());
			fBean.setAccountNo(farmerDataBean.getAccountNo());
			fBean.setBankName(farmerDataBean.getBankName());
			fBean.setBranchName(farmerDataBean.getBranchName());
			fBean.setFarmerCode(farmerDataBean.getFarmerCode());
			fBean.setFarmerName(farmerDataBean.getFarmerName());
			fBean.setIfscCode(farmerDataBean.getIfscCode());
			fBean.setMobileNo(farmerDataBean.getMobileNo());
			fBean.setSellDate(farmerDataBean.getSellDate());
			fBean.setSellId(farmerDataBean.getSellId());
			fBean.setSellQuantity(farmerDataBean.getSellQuantity());
			fBean.setTransitPassDate(farmerDataBean.getTransitPassDate());
			fBean.setVehicleNO(farmerDataBean.getMobileNo());
			fBean.setFarmerId(farmerDataBean.getFamrerId());
			CouchDBRepository.saveData(fBean);


		return "inserted";
	}

	@GetMapping(value = "/validateAadhar/{aadhar}")
	public ResponseEntity<Status> validateAadhar(@PathVariable("aadhar") String aadhar, Status status) {
		if (AadharValidation.validateAadhar(aadhar))
			status.setStatus("Valid");
		else
			status.setStatus("Invalid");
		System.out.println(status);
		return ResponseEntity.ok(status);
	}

	@GetMapping(value = "/getBankUsingIFSCCode/{ifscCode}")
	public ResponseEntity<BankDetailsBean> getBankUsingIFSCCode(@PathVariable("ifscCode") String ifscCode) {
		System.out.println("Inside Get Bank Details Using IFSC Code----------------------->>");
		System.out.println("IFSC Code : " + ifscCode);
		Gson gson = new Gson();
		RestTemplate restTemplate = new RestTemplate();
		String bankDetails = restTemplate.getForObject("https://ifsc.razorpay.com/" + ifscCode, String.class);
		System.out.println(bankDetails);

		BankDetailsBean bankDetailsBean = gson.fromJson(bankDetails, BankDetailsBean.class);
		System.out.println("Bank Details are : " + bankDetailsBean);

		return ResponseEntity.ok(bankDetailsBean);
	}

	
}
