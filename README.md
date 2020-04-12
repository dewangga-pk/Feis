# FEIS (Food Equalization Information System)
# Setting JavaFx

### Requirement
- [x] Support Java JDK 11-13 [Download](https://www.oracle.com/java/technologies/javase-downloads.html)
- [x] Intellij 2019.3.4 [Download](https://www.jetbrains.com/idea/)
- [x] Scene Builder [Download](https://gluonhq.com/products/scene-builder/)
- [x] JavaFx SDK 11.0.2 [Download](https://gluonhq.com/products/javafx/)
- [x] Jfoenix 9.08 [Download](https://github.com/jfoenixadmin/JFoenix)


### Cara setting javaFx pada Intellij  di Windows

 *  #### Setting Library JavaFx
	* Open Intellij->klik File->Klik Project Structure->Global Libraries->Klik + >Java
	* >Arahkan pada folder lib javafx sdk contoh :
	* >>C:\Downloads\javafx-sdk-11.0.2\lib
	* Klik Ok,jika ada notifikasi ".... module...." pilih ok/yes.
	* Klik Apply
 * #### Setting Library jfoenix
 	* Open Intellij->klik File->Klik Project Structure->Libraries->Klik +- >Java
	* >Arahkan pada file jfoenix.jar contoh :
	* >>C:\Downloads\jfoenix-9.0.8.jar
	* Klik Ok
	* Klik Apply
 * #### Setting VM
  	* Open Intellij->Klik Run->Edit Configurations->Application->Main
	* Pada VM Options :
	copy paste tulisan ini 
	> --module-path ${PATH_TO_FX} --add-modules=javafx.controls,javafx.fxml,javafx.base
	* Klik Ok
	* Jika *error* bisa gunakan setting dibawah ini
	* Ubah **${PATH_TO_FX}** menuju ke lib javaFx,contoh
	> --module-path "C:\Downloads\javafx-sdk-11.0.2\lib" --addmodules=javafx.controls,javafx.fxml,javafx.base
	* Klik Ok

### Done silahkan di run
[Referensi Setting](https://taylorial.com/cs1021/Install.htm#installingjava11openjdkandjavafx)
