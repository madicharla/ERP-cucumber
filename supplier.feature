Feature: validating supplier module
@supplierdata
Scenario Outline: As a admin user validate supplier
When Open browser
When Open application url "http://webapp.qedgetech.com/"
When wait for username with "name" and "username"
When click on reset button with "name" and "btnreset"
When enter username with "name" and "username"
When enter password with "id" and "password"
When click on login with "name" and "btnsubmit"
When wait for supplier link with "x-path" and "(//a[starts-with(text(),'Suppliers')])[2]" 
When click on supplier link with"x-Path" and "(//a[starts-with(text(),'Suppliers')])[2]"
When wait for addbutton with"x-Path" and "(//span[contains(@data-caption,'Add')])[1]" 
When click on addbutton with"x-path" and "(//span[contains(@data-caption,'Add')])[1]"
When wait for supplier number with "x-path" and "//input[@data-field='x_Supplier_Number']"
Then capture supplier number with "x-path" and"//input[@data-field='x_Supplier_Number']"
When enter supplier name "<Supplie name>" with "name" and"x_Supplier_Name"
When enter address "<address>" with "x-path" and "(//textarea[@id='x_Address']"
When enter city name "<city>" with "x-path" and "//input[@id='x_City']"
When enter country "<country>" with "x-path" and "//input[@id='x_Country']"
When enter contact person "<contact person>" with "x-path" and "//input[@id='x_Contact_Person']"
When enter phone number "<phone number>" wwith "x-path" and "//input[@id='x_Phone_Number']"
When enter email "<email>" with "x-path" and "//input[@id='x__Email']"
When enter mobile  number "<mobile number>"  with "-path" and "//input[@id='x_Mobile_Number']"
When enter notes "<notes>" with "x-path" and "//textarea[@id='x_Notes']"
When click on add button with "name" and "btnAction"
When wait for ok button with "x-path" and "(//button[contains(.,'OK!')]"
When click on ok button with "x-path" and "(//button[contains(.,'OK!')]"
When wait for ok button with "x-path" and "(//button[contains(text(),'OK')])[6]"
When click on ok button with "x-path" and "(//button[contains(text(),'OK')])[6]"
Then user validate supplier table
When  close the browser

Examples:
|supplier name |address|city name|country|contact person|phone number|email|mobile number|notes|
|ramya|hderabad|telangana|india|rgahndb|87666578|hbyydnd@gmail.com|67887898877|brought a phone|
|sree|hygderav|yrhebdms|india|dndhd|88789878|njjnhddhh@gmail.com|8768878899|brought a kes|