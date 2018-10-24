import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Result;
import com.xiaomi.xmpush.server.Sender;

public class Main {

    //private static String APP_SECRET_KEY = "I2+lApzHdwDRw09sToKdSw==";
    //    private static String MY_PACKAGE_NAME = "com.jiang.tvlauncher";
    private static String UserAccount = "DG69H9D3BTA6";

    private static String APP_SECRET_KEY = "3cm5GM5ai3lPStqzuO4qaA==";
    private static String MY_PACKAGE_NAME = "com.china.gona";
    private static String regId = "0";

    public static void main(String[] args) {
        try {
            Constants.useOfficial();
            Sender sender = new Sender(APP_SECRET_KEY);
            String messagePayload = "Java Server first";
            String title = "Java Server first";
            String description = "Java Server first";
            Message message = new Message.Builder()
                    .title(title)
                    .description(description).payload(messagePayload)
                    .restrictedPackageName(MY_PACKAGE_NAME)
                    .notifyType(1)     // 使用默认提示音提示
                    .build();
        Result result = sender.send(message, regId,3);
//            Result result = sender.sendToUserAccount(message, UserAccount, 3);
            System.out.println("MessageId: " + result.getMessageId()
                    + " ErrorCode: " + result.getErrorCode().toString()
                    + " Reason: " + result.getReason());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
