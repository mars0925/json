package shd.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**練習Gson的使用方法*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Staff staff = createDummyObject();//產生model的資料
        //1. Convert object to JSON string
        Gson gson = new Gson();
        String jsonString = gson.toJson(staff);//直接把model的資料變成json格式的字串
        JsonObject jsonO = gson.fromJson(jsonString, JsonObject.class);//使用json字串變成json物件
        System.out.println(jsonO);
        System.out.println(jsonString);

        /*也可以逐一放入物件*/
        JsonObject jsonObject1 = new JsonObject();

        jsonObject1.addProperty("name","mars");
        jsonObject1.addProperty("age",2);
        jsonObject1.addProperty("wie",2.5);
        System.out.println(jsonObject1);
    }

    /*產生model的資料*/
    private static Staff createDummyObject() {

        Staff staff = new Staff();

        staff.setName("mkyong");
        staff.setAge(35);
        staff.setPosition("Founder");
        staff.setSalary(new BigDecimal("10000"));

        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");
        skills.add("shell");

        staff.setSkills(skills);

        return staff;

    }
}
