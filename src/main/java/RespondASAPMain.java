public class RespondASAPMain {
    public static void main(String[] args) throws InterruptedException {
        RespondASAP respondASAP = new RespondASAP();
        respondASAP.init();
        respondASAP.homePage();
        respondASAP.propertiesFile();
        respondASAP.loginAdministrtor();
        /*Thread.sleep(5000);
        respondASAP.createAdmin();
        Thread.sleep(5000);
        respondASAP.viewAdmin();
        Thread.sleep(5000);
        respondASAP.createUser();
        Thread.sleep(5000);
        respondASAP.viewUser();
        Thread.sleep(5000);
        respondASAP.sendNotification();
        Thread.sleep(5000);
        respondASAP.viewNotifications();*/

    }
}
