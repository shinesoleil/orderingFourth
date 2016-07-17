package com.thoughtworks.api.support;

import com.thoughtworks.api.domain.user.User;
import com.thoughtworks.api.domain.user.UserRole;

import java.util.*;

public class TestHelper {
    private static int auto_increment_key = 1;
    public static Map<String, Object> deployment(String appName, String releaseId) {
        return new HashMap<String, Object>() {{
            put("app", String.format("http://service-api.tw.com/apps/%s", appName));
            put("release", String.format("http://service-api.tw.com/apps/%s/releases/%s", appName, releaseId));
        }};
    }

    public static Map<String, Object> stackMap(String id, String name) {
        Map<String, Object> stackMap = new HashMap<String, Object>() {{
            put("id", id);
            put("name", name);
        }};
        return stackMap;
    }

//    public static Map<String, Object> userMap(String email, String name) {
//        return new HashMap<String, Object>() {{
//            put("name", name);
//            put("email", email);
//        }};
//    }

    public static User userForTest(String id, String name, UserRole role) {
        String password_123 = "$2a$04$DbgJbGA4dkQSzAvXvJcGBOv5kHuMBzrWfne3x3Cx4JQv4IJcxtBIW";
        return new User(id, name);
    }

//    public static User userFixture(UserRepository userRepository, UserRole role) {
//        final String id = new Integer(auto_increment_key++).toString();
//        User user = userForTest(id, "name-" + id, role);
//        userRepository.save(user);
//        return user;
//    }
//
//    public static Map<String, Object> userJsonForTest(User user) {
//        return new HashMap<String, Object>() {{
//            put("id", user.getUserId().id());
//            put("role", user.getRole());
//        }};
//    }

    public static Map<String, Object> productMap(String id) {
        return new HashMap<String, Object>() {{
            put("id", id);
            put("name", "desk");
            put("description", "black");
            put("price", 610.00);
        }};
    }

    public static Map<String, Object> productMapApi() {
        return new HashMap<String, Object>() {{
            put("name", "desk");
            put("description", "black");
            put("price", 610.00);
        }};
    }

    public static Map<String, Object> userMap(String id) {
        return new HashMap<String, Object>() {{
            put("id", id);
            put("name", "firstUser");
        }};
    }

    public static Map<String, Object> userMapApi() {
        return new HashMap<String, Object>() {{
            put("name", "firstUser");
        }};
    }

    public static Map<String, Object> orderItemMap(String orderId, String productId) {
        return new HashMap<String, Object>() {{
            put("order_id", orderId);
            put("product_id", productId);
            put("quantity", 1);
        }};
    }

    public static Map<String, Object> orderMap(String orderId, String userId, String productId) {
        List<Map<String, Object>> orderItemList = new ArrayList<>();
        orderItemList.add(orderItemMap(orderId, productId));

        return new HashMap<String, Object>() {{
            put("id", orderId);
            put("name", "firstOrder");
            put("address", "Xi'an");
            put("phone", "13099999999");
            put("time", new Date());
            put("user_id", userId);
            put("order_items", orderItemList);
        }};
    }

    public static Map<String, Object> orderItemMapApi(String productId) {
        return new HashMap<String, Object>() {{
            put("product_id", productId);
            put("quantity", 3);
        }};
    }

    public static Map<String, Object> orderMapApi(String productId) {
        List<Map<String, Object>> orderItemList = new ArrayList<>();
        orderItemList.add(orderItemMapApi(productId));

        return new HashMap<String, Object>() {{
            put("name", "firstOrder");
            put("address", "Xi'an");
            put("phone", "13099999999");
            put("time", new Date());
            put("order_items", orderItemList);
        }};
    }

    public static Map<String, Object> paymentMap(String orderId) {
        return new HashMap<String, Object>() {{
            put("order_id", orderId);
            put("pay_type", "cash");
            put("amount", 1000);
        }};
    }

    public static Map<String, Object> paymentMapApi() {
        return new HashMap<String, Object>() {{
            put("pay_type", "cash");
            put("amount", 1000);
        }};
    }
}
