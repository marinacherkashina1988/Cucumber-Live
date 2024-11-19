package utils;

import apiSteps.APISteps;
import org.json.JSONObject;

public class APIPayloadConstants {

    public static String generateTokenPayload(String email, String password) {
        JSONObject obj = new JSONObject();
        obj.put("email", email);
        obj.put("password", password);
        return obj.toString();
    }

    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Siri\",\n" +
                "  \"emp_lastname\": \"GlooGloo\",\n" +
                "  \"emp_middle_name\": \"Ms\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2000-11-11\",\n" +
                "  \"emp_status\": \"Intern\",\n" +
                "  \"emp_job_title\": \"Data Analyst\"\n" +
                "}";
        return createEmployeePayload;
    }


    public static String createEmployeeJsonPayload() {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Siri");
        obj.put("emp_lastname", "GlooGloo");
        obj.put("emp_middle_name", "Ms");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "2000-11-11");
        obj.put("emp_status", "Intern");
        obj.put("emp_job_title", "Data Analyst");
        return obj.toString();
    }

    public static String createEmployeeJsonPayloadDynamic(String emp_firstname,
                                                          String emp_lastname,
                                                          String emp_middle_name,
                                                          String emp_gender,
                                                          String emp_birthday,
                                                          String emp_status,
                                                          String emp_job_title) {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);
        return obj.toString();
    }

    public static String updateEmployee(String emp_firstname,
                                        String emp_lastname,
                                        String emp_middle_name,
                                        String emp_gender,
                                        String emp_birthday,
                                        String emp_status,
                                        String emp_job_title) {
        JSONObject obj = new JSONObject();
        obj.put("employee_id", APISteps.employee_id);
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);
        return obj.toString();
    }

    public static String partialUpdateEmployee(String emp_lastname){
        JSONObject obj = new JSONObject();
        obj.put("employee_id", APISteps.employee_id);
        obj.put("emp_lastname", emp_lastname);
        return obj.toString();
    }
}
