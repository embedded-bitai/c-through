package com.example.demo.controller;
import com.example.demo.nativeinterface.array.ArrayReturnTest;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
@Log
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ThreejsController {
    float[] dist = new float[1024];
    float[] angle = new float[1024];
    ArrayList<Float> arr_angl_B = new ArrayList<Float>();
    ArrayList<Float> arr_dist_B = new ArrayList<Float>();
    HashMap<String, Integer> people = new HashMap<String, Integer>();
    @GetMapping("/opencv/{place2}")
    public String opencv(@PathVariable String place2) throws Exception {
        log.info("place :" + place2);
        return "opencv";
    }
    @GetMapping("/testurl")
    public String testurl() throws Exception {
        log.info("testurl");
        return "lidar";
    }
    @ResponseBody
    @PostMapping("CVpeople")
    public void testurl(@RequestBody HashMap<String, String> values) throws Exception {
        int people = Integer.valueOf(values.get("value"));
        String place = values.get("plack");
        log.info(String.valueOf(people));
        log.info(place);
        this.people.put(place, people);
    }
    @GetMapping("/setlidartest")
    public String setlidartest() throws InterruptedException {
        log.info("setlidartest");
        ArrayReturnTest.readyToGetFloatArray();
        return "lidar";
    }
    @ResponseBody
    @GetMapping("/lidartest")
    public HashMap<String, ArrayList> lidartest() throws InterruptedException {
        log.info("lidartest");
        // JVM Stack Frame의 한계로 일정 범위 이상은 Stack이 박살나는 현상을 초래함
        // 좀 더 크게 잡아야 한 번에 데이터를 많이 땡겨올 수 있는데 반복적으로 JNI API를 호출시켜야함
        boolean TF = false;
        float test1 = 0;
        float test2 = 0;
        ArrayList arr_angle = new ArrayList();
        ArrayList arr_dist = new ArrayList();
        while (true)
        {
            ArrayReturnTest.getFloatArray(dist, angle);
            for(int i = 0; i < angle.length; i++) {
                arr_angl_B.add(angle[i]);
                arr_dist_B.add(dist[i]);
                if(angle[i] > 359.0) {
                    TF = true;
                    for(int j = 0; j<arr_dist_B.size(); j++)
                    {
                        test1 = arr_angl_B.get(j);
                        test2 = arr_dist_B.get(j);
                        arr_angle.add(test1);
                        arr_dist.add(test2);
                    }
                    arr_dist_B.clear();
                    arr_angl_B.clear();
                }
            }
            if(TF) {
                break;
            }
        }
        TF = false;
        for(int i = 0; i<arr_angle.size(); i++) {
            log.info(String.valueOf(arr_angl_B.get(1)));
        }
        log.info(String.valueOf(test1));
        log.info(String.valueOf(test2));
        HashMap<String, ArrayList> arr = new HashMap<>();
        arr.put("key_angle", arr_angle);
        arr.put("key_dist", arr_dist);
        return arr;
    }
}