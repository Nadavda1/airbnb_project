package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Apartment;
import java.io.FileNotFoundException;
import java.io.IOException;
import controller.Controller;
import exception.ClientAlreadyExistExc;
import exception.ClientNameExc;
import exception.PhoneNumberExc;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class View extends GridPane {

	private Controller controller;
	private Stage stage;
	private Scene mainMenuScene;
	Label label0 = new Label("Hello!! Wellcome to Afeka Office");
	Label label1 = new Label("Please choose one of the following option: ");
	Button button1 = new Button("Add apartment");
	Button button2 = new Button("Add client for specific apartment");
	Button button3 = new Button("Show all apartments");
	Button button4 = new Button("Show all apartments of specific type");
	Button button5 = new Button("Show the full price for specific apartment");
	Button button6 = new Button("Show the most expensive apartment for rent at the requested time");
	Button button7 = new Button("Show all clients for specific apartment");
	Button button8 = new Button("Show all clients for specific apartment by name");
	Button button9 = new Button("Show all apartment with commission");
	Button button10 = new Button("Choose apartment to clone");
	Button button11 = new Button("Save and Exit");

	public View(Controller controller, Stage stage) {
		this.controller = controller;
		this.stage = stage;
		init();
		addComponants();
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(10));
	}

	private void addComponants() {

		this.stage.setTitle("Afeka Office...");
		VBox hBox = new VBox(10);
		hBox.getChildren().addAll(label0,label1, button1, button2, button3, button4, button5, button6, button7, button8,
				button9, button10, button11);
		Scene mainMenuScene = new Scene(hBox, 500, 500);
		this.stage.setScene(mainMenuScene);
		this.mainMenuScene = mainMenuScene;
		addApartmentComponant(hBox, mainMenuScene);
		showAllApartment(hBox, mainMenuScene);
		AddClient(hBox, mainMenuScene);
		showAllSpecificApartment(hBox, mainMenuScene);
		showFullPriceOfSpecificApartment(hBox, mainMenuScene);
		getTheMostExpensiveApartment(hBox, mainMenuScene);
		ShowAllClientAfterSort(hBox, mainMenuScene);
		ShowAllclients(hBox, mainMenuScene);
		ShowAllApartmentWithCommission(hBox, mainMenuScene);
		ShowAndCloneApt(hBox, mainMenuScene);
		SaveAndExit(hBox, mainMenuScene);
		hBox.setAlignment(Pos.TOP_LEFT);
		hBox.setPadding(new Insets(30));

	}

	private void SaveAndExit(VBox hBox, Scene mainMenuScene2) {
		button11.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
			try {
				controller.saveDATA();
				stage.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

		});
	}

	private void addApartmentComponant(VBox hBox, Scene mainMenuScene) {
		VBox addApartmentHBox = new VBox(10);
		Scene addApartmentScene = new Scene(addApartmentHBox, 500, 500);
		// Case1.....................
		button1.setOnAction(e -> stage.setScene(addApartmentScene));
		{
			Label label = new Label("Please enter the apartment type do you want to add: ");
			Button purchaseApt = new Button("Apartment for purchase");
			Button regularApt = new Button("Regular apartment for rent");
			Button airBnbApt = new Button("Airbnb apartment");
			Button backToMainMenuBtn = new Button("back to main");
			addApartmentHBox.getChildren().addAll(label, purchaseApt, regularApt, airBnbApt, backToMainMenuBtn);
			addApartmentHBox.setPadding(new Insets(30));
			// add Purchase apartment.............
			VBox purchaseAptHBox = new VBox(10);
			Scene purchaseAptScene = new Scene(purchaseAptHBox, 550, 500);
			purchaseApt.setOnAction(e -> {
				this.stage.setScene(purchaseAptScene);

			});
			{
				TextField addressTextField = new TextField();
				Label addressLable = new Label("Address:");

				TextField areaTextField = new TextField();
				Label areaLable = new Label("Area:");

				TextField roomNumberTextField = new TextField();
				Label roomCntLable = new Label("Rooms number:");

				TextField mediatorRateTextField = new TextField();
				Label MediatorRate = new Label("Mediator rate:");

				TextField priceTextField = new TextField();
				Label priceLable = new Label("Price:");

				Button addApartmentBtn = new Button("Add !!");
				Label myLabel = new Label("Status:");
				TextField myTextField = new TextField();

				addApartmentBtn.setOnAction(e -> {
					try {
						controller.AddApartmentForPurchase(addressTextField.getText(),
								Double.parseDouble(areaTextField.getText()),
								Integer.parseInt(roomNumberTextField.getText()),
								Integer.parseInt(mediatorRateTextField.getText()),
								Integer.parseInt(priceTextField.getText()));
						this.stage.setScene(mainMenuScene);
						addressTextField.clear();
						areaTextField.clear();
						roomNumberTextField.clear();
						mediatorRateTextField.clear();
						priceTextField.clear();
						myTextField.clear();
					} catch (Exception exc) {
						myTextField.setText(exc.getMessage());
					}

				});

				purchaseAptHBox.getChildren().addAll(addressLable, addressTextField, areaLable, areaTextField,
						roomCntLable, roomNumberTextField, MediatorRate, mediatorRateTextField, priceLable,
						priceTextField, addApartmentBtn, myLabel, myTextField);
				purchaseAptHBox.setPadding(new Insets(30));
			}
			// add regular rent apartment.............
			VBox regularAptHBox = new VBox(10);
			Scene regularAptScene = new Scene(regularAptHBox, 650, 500);
			regularApt.setOnAction(e -> {
				this.stage.setScene(regularAptScene);
			});
			{
				TextField addressTextField2 = new TextField();
				Label addressLable2 = new Label("Address:");

				TextField areaTextField2 = new TextField();
				Label areaLable2 = new Label("Area:");

				TextField roomNumberTextField2 = new TextField();
				Label roomCntLable2 = new Label("Rooms number:");

				TextField mediatorRateTextField2 = new TextField();
				Label MediatorRate2 = new Label("Mediator rate:");

				TextField priceTextField2 = new TextField();
				Label priceLable2 = new Label("Price per mounth:");

				TextField rentTimeTextField2 = new TextField();
				Label rentTimeLable2 = new Label("Rent time by mounths:");

				Button addApartmentBtn2 = new Button("Add !!");
				Label myLabel2 = new Label("Status:");
				TextField myTextField2 = new TextField();

				addApartmentBtn2.setOnAction(e -> {
					try {
						controller.AddRegularApartmentForRent(addressTextField2.getText(),
								Double.parseDouble(areaTextField2.getText()),
								Integer.parseInt(roomNumberTextField2.getText()),
								Integer.parseInt(mediatorRateTextField2.getText()),
								Integer.parseInt(rentTimeTextField2.getText()),
								Integer.parseInt(priceTextField2.getText()));

						this.stage.setScene(mainMenuScene);
						addressTextField2.clear();
						areaTextField2.clear();
						roomNumberTextField2.clear();
						mediatorRateTextField2.clear();
						priceTextField2.clear();
						myTextField2.clear();
					} catch (Exception exc) {
						myTextField2.setText(exc.getMessage());
					}
				});

				regularAptHBox.getChildren().addAll(addressLable2, addressTextField2, areaLable2, areaTextField2,
						roomCntLable2, roomNumberTextField2, MediatorRate2, mediatorRateTextField2, rentTimeLable2,
						rentTimeTextField2, priceLable2, priceTextField2, addApartmentBtn2, myLabel2, myTextField2);
				regularAptHBox.setPadding(new Insets(30));
			}
			// add regular rent apartment.............
			VBox airBnbAptHBox = new VBox(10);
			Scene airBnbAptScene = new Scene(airBnbAptHBox, 650, 500);
			airBnbApt.setOnAction(e -> {
				this.stage.setScene(airBnbAptScene);
			});
			{
				TextField addressTextField3 = new TextField();
				Label addressLable3 = new Label("Address:");

				TextField areaTextField3 = new TextField();
				Label areaLable3 = new Label("Area:");

				TextField roomNumberTextField3 = new TextField();
				Label roomCntLable3 = new Label("Rooms number:");

				TextField mediatorRateTextField3 = new TextField();
				Label MediatorRate3 = new Label("Mediator rate:");

				TextField priceTextField3 = new TextField();
				Label priceLable3 = new Label("Price per day:");

				TextField rentTimeTextField3 = new TextField();
				Label rentTimeLable3 = new Label("Rent time by days:");

				Button addApartmentBtn3 = new Button("Add !!");
				Label myLabel3 = new Label("Status:");
				TextField myTextField3 = new TextField();

				addApartmentBtn3.setOnAction(e -> {
					try {
						controller.AddAirBnbApartment(addressTextField3.getText(),
								Double.parseDouble(areaTextField3.getText()),
								Integer.parseInt(roomNumberTextField3.getText()),
								Integer.parseInt(mediatorRateTextField3.getText()),
								Integer.parseInt(rentTimeTextField3.getText()),
								Integer.parseInt(priceTextField3.getText()));

						this.stage.setScene(mainMenuScene);
						addressTextField3.clear();
						areaTextField3.clear();
						roomNumberTextField3.clear();
						mediatorRateTextField3.clear();
						priceTextField3.clear();
						myTextField3.clear();
					} catch (Exception exc) {
						myTextField3.setText(exc.getMessage());
					}
				});

				airBnbAptHBox.getChildren().addAll(addressLable3, addressTextField3, areaLable3, areaTextField3,
						roomCntLable3, roomNumberTextField3, MediatorRate3, mediatorRateTextField3, rentTimeLable3,
						rentTimeTextField3, priceLable3, priceTextField3, addApartmentBtn3, myLabel3, myTextField3);
				airBnbAptHBox.setPadding(new Insets(30));
			}
			backToMainMenuBtn.setOnAction(e -> switchScenes(mainMenuScene));
		}
	}

	private void AddClient(VBox hBox, Scene mainMenuScene) {
		// case2................................................
		VBox addClientHBox = new VBox(10);
		Scene addClientScene = new Scene(addClientHBox, 500, 500);
		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				stage.setScene(addClientScene);
				addClientHBox.setPadding(new Insets(30));
				Label lb = new Label("Enter the apartment address:");
				TextField aptAddresTextField = new TextField();
				Label lb1 = new Label("Enter the Client name:");
				TextField clientNameTextField = new TextField();
				Label lb2 = new Label("Enter the Client phone Number:");
				TextField clientPNumberTextField = new TextField();
				Button pressApt = new Button("Press");
				Label myLabel4 = new Label("Status:");
				TextField myTextField4 = new TextField();
				Button backToMainMenuBtn5 = new Button("back to main");
				addClientHBox.getChildren().addAll(lb, aptAddresTextField, lb1, clientNameTextField, lb2,
						clientPNumberTextField, pressApt, myLabel4, myTextField4, backToMainMenuBtn5);

				backToMainMenuBtn5.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent ae) {
						addClientHBox.getChildren().clear();
						stage.setScene(mainMenuScene);
					}
				});

				pressApt.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent ae) {
						try {
							Apartment apt = controller.getApartmentByAddress(aptAddresTextField.getText());
							controller.AddClientToApartment(apt.getAddress(), clientNameTextField.getText(),
									clientPNumberTextField.getText());

							stage.setScene(mainMenuScene);
							addClientHBox.getChildren().clear();
							aptAddresTextField.clear();
							clientNameTextField.clear();
							clientPNumberTextField.clear();
							myTextField4.clear();
						} catch (ClientNameExc ex) {
							myTextField4.setText(ex.getMessage());
						} catch (PhoneNumberExc ex) {
							myTextField4.setText(ex.getMessage());
						} catch (ClientAlreadyExistExc ex) {
							myTextField4.setText(ex.getMessage());
						} catch (Exception ex) {
							myTextField4.setText("Apartment doesnt exist!!");
						}
					}
				});
			}
		});
	}

	private void showAllApartment(VBox hBox, Scene mainMenuScene) {
		VBox ShowAllApartmentHBox = new VBox(10);
		Scene ShowAllApartmentScene = new Scene(ShowAllApartmentHBox, 500, 500);
		button3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				stage.setScene(ShowAllApartmentScene);
				Label allApartLabel = new Label(controller.ShowAllApart());
				Button backToMainMenuBtn = new Button("back to main");
				ShowAllApartmentHBox.getChildren().addAll(allApartLabel, backToMainMenuBtn);
				ShowAllApartmentHBox.setPadding(new Insets(30));

				backToMainMenuBtn.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent ae) {
						ShowAllApartmentHBox.getChildren().clear();
						stage.setScene(mainMenuScene);
					}
				});
			}
		});
	}

	private void showAllSpecificApartment(VBox hBox, Scene mainMenuScene) {
		VBox ShowSpecificAptHBox = new VBox(10);
		Scene ShowSpecificAptScene = new Scene(ShowSpecificAptHBox, 500, 500);
		// Case1.....................
		button4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
			stage.setScene(ShowSpecificAptScene);
			Label label = new Label("Please enter the apartment type do you want to show: ");
			Button purchaseShowApt = new Button("Apartment for purchase");
			Button regularShowApt = new Button("Regular apartment for rent");
			Button airBnbShowApt = new Button("Airbnb apartment");
			Button backToMainMenuBtn = new Button("back to main");
			ShowSpecificAptHBox.getChildren().addAll(label, purchaseShowApt, regularShowApt, airBnbShowApt,
					backToMainMenuBtn);
			ShowSpecificAptHBox.setPadding(new Insets(30));
			// add Purchase apartment.............
			VBox purchaseAptShowHBox = new VBox(10);
			Scene purchaseAptShowScene = new Scene(purchaseAptShowHBox, 550, 450);
			purchaseShowApt.setOnAction(e -> stage.setScene(purchaseAptShowScene));
			{
				Label purchaseShowAptLabel = new Label(controller.getAllSpecificApartmentPurchase());
				Button backToMainMenuBtn2 = new Button("back to main");
				purchaseAptShowHBox.getChildren().addAll(purchaseShowAptLabel, backToMainMenuBtn2);
				purchaseAptShowHBox.setPadding(new Insets(30));

				backToMainMenuBtn2.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent ae) {
						ShowSpecificAptHBox.getChildren().clear();
						stage.setScene(mainMenuScene);
					}
				});
			}

			VBox RegularAptShowHBox = new VBox(10);
			Scene RgularAptShowScene = new Scene(RegularAptShowHBox, 550, 450);
			regularShowApt.setOnAction(e -> stage.setScene(RgularAptShowScene));
			{
				Label RegularShowAptLabel = new Label(controller.getAllSpecificRegApartmentForRent());
				Button backToMainMenuBtn2 = new Button("back to main");
				RegularAptShowHBox.getChildren().addAll(RegularShowAptLabel, backToMainMenuBtn2);
				RegularAptShowHBox.setPadding(new Insets(30));

				backToMainMenuBtn2.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent ae) {
						ShowSpecificAptHBox.getChildren().clear();
						stage.setScene(mainMenuScene);
					}
				});
			}

			VBox AirbnbAptShowHBox = new VBox(10);
			Scene AirbnbAptShowScene = new Scene(AirbnbAptShowHBox, 550, 450);
			airBnbShowApt.setOnAction(e -> stage.setScene(AirbnbAptShowScene));
			{
				Label airbnbShowAptLabel = new Label(controller.getAllSpecificApartmentAirbnb());
				Button backToMainMenuBtn2 = new Button("back to main");
				AirbnbAptShowHBox.getChildren().addAll(airbnbShowAptLabel, backToMainMenuBtn2);
				AirbnbAptShowHBox.setPadding(new Insets(30));

				backToMainMenuBtn2.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent ae) {
						ShowSpecificAptHBox.getChildren().clear();
						stage.setScene(mainMenuScene);
					}
				});
			}

			backToMainMenuBtn.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					ShowSpecificAptHBox.getChildren().clear();
					stage.setScene(mainMenuScene);
				}
			});
		}
		});
	}

	private void showFullPriceOfSpecificApartment(VBox hBox, Scene mainMenuScene) {
		VBox showFullPriceHBox = new VBox(10);
		Scene showFullPriceScene = new Scene(showFullPriceHBox, 500, 500);
		button5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				showFullPriceHBox.setPadding(new Insets(30));
				stage.setScene(showFullPriceScene);
				Label lb = new Label("Enter the apartment address:");
				Button pressApt = new Button("Press");
				TextField aptAddresTextField = new TextField();
				Label myLabel99 = new Label("Status:");
				TextField myTextField5 = new TextField();
				Button backToMainMenuBtn5 = new Button("back to main");
				showFullPriceHBox.getChildren().addAll(lb, aptAddresTextField, pressApt, myLabel99, myTextField5,
						backToMainMenuBtn5);
				VBox showFullPriceHBox2 = new VBox(10);
				Scene showFullPriceScene2 = new Scene(showFullPriceHBox2, 500, 500);
				backToMainMenuBtn5.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent ae) {
						showFullPriceHBox.getChildren().clear();
						aptAddresTextField.clear();
						myTextField5.clear();
						stage.setScene(mainMenuScene);
					}
				});
				pressApt.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent ae) {
						try {
							Apartment apt = controller.getApartmentByAddress(aptAddresTextField.getText());
							Label ShowPriceLabel = new Label("The price for this apartment is: " + apt.getPrice());
							stage.setScene(showFullPriceScene2);
							Button backToMainMenuBtn5 = new Button("back to main");
							showFullPriceHBox2.getChildren().addAll(ShowPriceLabel, backToMainMenuBtn5);
							showFullPriceHBox2.setPadding(new Insets(30));

							backToMainMenuBtn5.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent ae) {
									showFullPriceHBox2.getChildren().clear();
									showFullPriceHBox.getChildren().clear();
									aptAddresTextField.clear();
									myTextField5.clear();
									stage.setScene(mainMenuScene);
								}
							});

						} catch (Exception ex) {
							myTextField5.setText("Apartment doent exist!!");
						}
					}
				});
			}
		});
	}

	private void getTheMostExpensiveApartment(VBox hBox, Scene mainMenuScene) {
		VBox showMostExpensiveAptHBox = new VBox(10);
		Scene showMostExpensiveAptScene = new Scene(showMostExpensiveAptHBox, 500, 500);
		button6.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				showMostExpensiveAptHBox.setPadding(new Insets(30));
				stage.setScene(showMostExpensiveAptScene);
				Label lb = new Label("Enter the requested period in days:");
				Button pressApt = new Button("Press");
				TextField aptAddresTextField = new TextField();
				Label myLabel99 = new Label("Status:");
				TextField myTextField5 = new TextField();
				Button backToMainMenuBtn5 = new Button("back to main");
				showMostExpensiveAptHBox.getChildren().addAll(lb, (aptAddresTextField), pressApt, myLabel99,
						myTextField5, backToMainMenuBtn5);
				VBox showMostExpensiveAptHbox2 = new VBox(10);
				Scene showMostExpensiveAptScene2 = new Scene(showMostExpensiveAptHbox2, 400, 400);

				backToMainMenuBtn5.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent ae) {
						showMostExpensiveAptHBox.getChildren().clear();
						aptAddresTextField.clear();
						myTextField5.clear();
						stage.setScene(mainMenuScene);
					}
				});
				pressApt.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent ae) {
						try {
							int i = (Integer.parseInt(aptAddresTextField.getText()));
							Apartment apt = controller.getTheMostExpensiveApartmentForRent(i);
							Label ShowPriceLabel = new Label("The most expensive apartmet for this time id:\n" + apt
									+ "\n and the price is: " + apt.getPricePerDay() + " for day");
							stage.setScene(showMostExpensiveAptScene2);
							Button backToMainMenuBtn5 = new Button("back to main");
							showMostExpensiveAptHbox2.getChildren().addAll(ShowPriceLabel, backToMainMenuBtn5);
							showMostExpensiveAptHbox2.setPadding(new Insets(30));

							backToMainMenuBtn5.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent ae) {
									showMostExpensiveAptHbox2.getChildren().clear();
									showMostExpensiveAptHBox.getChildren().clear();
									aptAddresTextField.clear();
									myTextField5.clear();
									stage.setScene(mainMenuScene);
								}
							});

						} catch (Exception ex) {
							myTextField5.setText("Apartment doent exist!!");
						}
					}
				});
			}
		});
	}

	private void ShowAllclients(VBox hBox, Scene mainMenuScene) {
		VBox showClientHBox = new VBox(10);
		Scene showClientScene = new Scene(showClientHBox, 500, 500);
		button7.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
			showClientHBox.setPadding(new Insets(30));
			stage.setScene(showClientScene);
			Label lb = new Label("Enter the apartment address:");
			Button pressApt1 = new Button("Press");
			TextField aptAddresTextField = new TextField();
			Label myLabel4 = new Label("Status:");
			TextField myTextField5 = new TextField();
			Button backToMainMenuBtn5 = new Button("back to main");
			showClientHBox.getChildren().addAll(lb, aptAddresTextField, pressApt1, myLabel4, myTextField5,backToMainMenuBtn5);
			VBox showClientHBox2 = new VBox(10);
			Scene showClientScene2 = new Scene(showClientHBox2, 500, 500);

			backToMainMenuBtn5.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					showClientHBox.getChildren().clear();
					aptAddresTextField.clear();
					myTextField5.clear();
					stage.setScene(mainMenuScene);
				}
			});
			pressApt1.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					try {
						Apartment apt = controller.getApartmentByAddress(aptAddresTextField.getText());
						Label ShowClientLabel = new Label(controller.showAllClients(apt.getAddress()));
						stage.setScene(showClientScene2);
						Button backToMainMenuBtn5 = new Button("back to main");
						showClientHBox2.getChildren().addAll(ShowClientLabel, backToMainMenuBtn5);
						showClientHBox2.setPadding(new Insets(30));

						backToMainMenuBtn5.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent ae) {
								showClientHBox2.getChildren().clear();
								showClientHBox.getChildren().clear();
								aptAddresTextField.clear();
								myTextField5.clear();
								stage.setScene(mainMenuScene);
							}
						});

					} catch (Exception ex) {
						myTextField5.setText("Apartment doent exist!!");
					}
				}
			});
			}
			});
	}

	private void ShowAllClientAfterSort(VBox hBox, Scene mainMenuScene) {
		VBox showClientAfterSortHBox = new VBox(10);
		Scene showClientAfterSortScene = new Scene(showClientAfterSortHBox, 500, 500);
		button8.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
			showClientAfterSortHBox.setPadding(new Insets(30));
			stage.setScene(showClientAfterSortScene);
			Label lb = new Label("Enter the apartment address:");
			Button pressApt1 = new Button("Press");
			TextField aptAddresTextField = new TextField();
			Label myLabel4 = new Label("Status:");
			TextField myTextField5 = new TextField();
			Button backToMainMenuBtn5 = new Button("back to main");
			showClientAfterSortHBox.getChildren().addAll(lb, aptAddresTextField, pressApt1, myLabel4, myTextField5,backToMainMenuBtn5);
			VBox showClientAfterSortHBox2 = new VBox(10);
			Scene showClientAfterSortScene2 = new Scene(showClientAfterSortHBox2, 500, 500);

			backToMainMenuBtn5.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					showClientAfterSortHBox.getChildren().clear();
					aptAddresTextField.clear();
					myTextField5.clear();
					stage.setScene(mainMenuScene);
				}
			});
			pressApt1.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					try {
						Apartment apt = controller.getApartmentByAddress(aptAddresTextField.getText());
						controller.sortClientsByName(apt);
						Label ShowClientLabel = new Label(controller.showAllClients(apt.getAddress()));
						stage.setScene(showClientAfterSortScene2);
						Button backToMainMenuBtn5 = new Button("back to main");
						showClientAfterSortHBox2.getChildren().addAll(ShowClientLabel, backToMainMenuBtn5);
						showClientAfterSortHBox2.setPadding(new Insets(30));

						backToMainMenuBtn5.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent ae) {
								showClientAfterSortHBox2.getChildren().clear();
								showClientAfterSortHBox.getChildren().clear();
								aptAddresTextField.clear();
								myTextField5.clear();
								stage.setScene(mainMenuScene);
							}
						});

					} catch (Exception ex) {
						myTextField5.setText("Apartment doent exist!!");
					}
				}
			});
		}
		});

	}

	private void ShowAllApartmentWithCommission(VBox hBox, Scene mainMenuScene) {
		VBox ShowAllApartmentWithCommissionHBox = new VBox(10);
		Scene ShowAllApartmentWithCommissionScene = new Scene(ShowAllApartmentWithCommissionHBox,500, 500);
		button9.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				stage.setScene(ShowAllApartmentWithCommissionScene);
				Label allApartLabel = new Label(controller.showAllApartmentsWithCommission());
				Button backToMainMenuBtn = new Button("back to main");
				ShowAllApartmentWithCommissionHBox.getChildren().addAll(allApartLabel, backToMainMenuBtn);
				ShowAllApartmentWithCommissionHBox.setPadding(new Insets(30));

				backToMainMenuBtn.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent ae) {
						ShowAllApartmentWithCommissionHBox.getChildren().clear();
						stage.setScene(mainMenuScene);
					}
				});
			}
		});
	}

	private void ShowAndCloneApt(VBox hBox, Scene mainMenuScene2) {
		VBox cloneAptHBox = new VBox(10);
		Scene cloneAptScene = new Scene(cloneAptHBox, 500, 500);
		button10.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
			cloneAptHBox.setPadding(new Insets(30));
			stage.setScene(cloneAptScene);
			Label lb = new Label("Enter the apartment address:");
			Button pressApt1 = new Button("Press");
			TextField aptAddresTextField = new TextField();
			Label myLabel4 = new Label("Status:");
			TextField myTextField5 = new TextField();
			Button backToMainMenuBtn5 = new Button("back to main");
			cloneAptHBox.getChildren().addAll(lb, aptAddresTextField, pressApt1, myLabel4, myTextField5,backToMainMenuBtn5);
			VBox cloneAptHBox2 = new VBox(10);
			Scene cloneAptScene2 = new Scene(cloneAptHBox2, 500, 500);

			
			backToMainMenuBtn5.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					cloneAptHBox.getChildren().clear();
					aptAddresTextField.clear();
					myTextField5.clear();
					stage.setScene(mainMenuScene);
				}
			});
			pressApt1.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					try {
						Apartment apt = controller.getApartmentByAddress(aptAddresTextField.getText());
						apt.clone();
						Label ShowClientLabel = new Label(
								"The apartment after clone is \n" + apt + "\n" + apt.showAllClients());
						stage.setScene(cloneAptScene2);
						Button backToMainMenuBtn5 = new Button("back to main");
						cloneAptHBox2.getChildren().addAll(ShowClientLabel, backToMainMenuBtn5);
						cloneAptHBox2.setPadding(new Insets(30));

						backToMainMenuBtn5.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent ae) {
								cloneAptHBox.getChildren().clear();
								cloneAptHBox2.getChildren().clear();
								aptAddresTextField.clear();
								myTextField5.clear();
								stage.setScene(mainMenuScene);
							}
						});

					} catch (Exception ex) {
						myTextField5.setText("Apartment doesnt exist!!");
					}
				}
			});
		}
		});

	}

	public void switchScenes(Scene scene) {
		stage.setScene(scene);
	}

	private void init() {
	}

}
