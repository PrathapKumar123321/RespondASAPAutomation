public class RespondASAPMain {
    public static void main(String[] args) throws InterruptedException {
        RespondASAP respondASAP = new RespondASAP();
        respondASAP.init();
        respondASAP.homePage();
        respondASAP.propertiesFile();
        respondASAP.loginAdministrtor();
        //respondASAP.createAdmin();
        //respondASAP.viewAdmin();
        //respondASAP.createUser();
        //respondASAP.viewUser();
        Thread.sleep(5000);
        respondASAP.viewNotifications();

    }
}
