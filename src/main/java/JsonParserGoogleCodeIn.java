import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.util.Scanner;

/**
 * Adi Sidapara
 * Mr. Truong
 * AP CS
 * 12/26/15
 */
public class JsonParserGoogleCodeIn {

        public static void main(String[] args) throws UnirestException {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What user number (1-100)?");
            int userNum = scanner.nextInt();
            while(userNum < 1 || userNum > 100){
                System.out.println("Must be between 1-100!");
                userNum = scanner.nextInt();
            }
            String url = "http://jsonplaceholder.typicode.com/posts/" + userNum;
            HttpResponse<JsonNode> obj = Unirest.get(url).asJson();
            JSONObject obj2 = obj.getBody().getObject();
            int userId = obj2.getInt("userId");
            int id = obj2.getInt("id");
            String title = obj2.getString("title");
            String body = obj2.getString("body");
            System.out.println("userId: "+ userId);
            System.out.println("id: " + id);
            System.out.println("title: " + title);
            System.out.println("body: " + body);
        }
    }


