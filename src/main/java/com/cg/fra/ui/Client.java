package com.cg.fra.ui;

import java.util.ArrayList;
import java.util.Scanner;

import javax.activity.InvalidActivityException;

import com.cg.fra.dto.FlatRegistrationDTO;
import com.cg.fra.service.FlatRegistrationServiceImpl;
import com.cg.fra.service.IFlatRegistrationService;

public class Client {
	static FlatRegistrationDTO flat1 = new FlatRegistrationDTO();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		FlatRegistrationDTO flat = new FlatRegistrationDTO();
		IFlatRegistrationService flatRegistrationService = new FlatRegistrationServiceImpl();

		System.out.println("Enter 1.Register flat 2.Exit");

		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			ArrayList<Integer> a = new ArrayList<Integer>();
			a = flatRegistrationService.getAllOwnersIds();
			System.out.println("Existing owner id's are" + a);

			System.out.println("Enter owner id");
			flat.setOwnerId(sc.nextInt());
			if (a.contains(flat.getOwnerId())) {
				System.out.println("Enter flat type 1. 1BHK 2. 2BHK ");
				flat.setFlatType(sc.nextInt());
				if (flat.getFlatType() == 1 || flat.getFlatType() == 2) {
					System.out.println("Enter flat area");
					flat.setFlatArea(sc.nextInt());
					if (flat.getFlatArea() > 0) {
						System.out.println("Enter rent amount");
						flat.setRentAmount(sc.nextInt());
						if (flat.getRentAmount() > 0) {
							System.out.println("Enter deposit amount");
							flat.setDepositAmount(sc.nextInt());
							if (flat.getDepositAmount() > flat.getRentAmount()) {

								flat1 = flatRegistrationService.registerFlat(flat);

								System.out.println(
										"Registration successfully done. Registration Id :" + flat1.getFlatRegNo());
							} else {
								try {
									throw new InvalidActivityException();
								} catch (InvalidActivityException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}

						else {
							try {
								throw new InvalidActivityException();
							} catch (InvalidActivityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}

					else {
						try {
							throw new InvalidActivityException();
						} catch (InvalidActivityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				} else {
					try {
						throw new InvalidActivityException();
					} catch (InvalidActivityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
				}
			}
			break;
		case 2:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice");
		}

	}
}
